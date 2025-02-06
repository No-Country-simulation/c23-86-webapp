"use client";

import { useEffect, useState } from "react";
import useTicketsStats from "@/hooks/useTicketsStats";
import StatisticsSummary from "./components/StatisticsSummary";
import TicketsTable from "./components/TicketsTable";
import withAuth from "./components/WithAuth";
import useIncidenceStore from "@/stores/incidenceStore";
import Table from "./components/Table/Table";
import handlerViewClick from "@/utils/functions/handlerViewClick";
import Notifications from "./components/Notifications/Notifications";
import handlerDeleteClick from "@/utils/functions/handlerDeleteClick";
import handlerEditClick from "@/utils/functions/handlerEditClick";
import { Incidence } from "@/props/IncidenceProps";
import IncidencePostModal from "./components/NewIncidenceModal/IncidencePostModal";

const Dashboard = () => {
  const initialState = {
    id: 0,
    idCliente: "",
    cliente: {
      id: 0,
      nombre: "",
      apellido: "",
      dni: 0,
      correo: "",
      telefono: "",
      estado: "",
    },
    servicio: {
      id: 0,
      nombre: "",
      descripcion: "",
    },
    descripcion: "",
    fechaDeAlta: "",
    detalles: [
      {
        idEmpleado: 0,
        nombreEmpleado: "",
        apellidoEmpleado: "",
        fechaDeModificacion: "",
        descripcion: "",
        estado: "",
        prioridad: "",
      },
    ],
  };

  const { stats, recentTickets } = useTicketsStats();
  const [selectedState, setSelectedState] = useState<string | null>(null);
  const [showNotifications, setShowNotifications] = useState(false);
  const [modalOpen, setModalOpen] = useState(false);
  const [formData, setFormData] = useState(initialState);

  const { incidences, getIncidences, postIncidences } = useIncidenceStore();

  useEffect(() => {
    getIncidences();
  }, []);

  const handleCardClick = (state: string) => {
    setSelectedState(state);
    setShowNotifications(!showNotifications);
  };

  const handleModalInputAndTextareaChange = (field: string, value: string) => {
    setFormData((prev) => ({
      ...prev,
      [field]: value,
    }));
  };

  const handleFormSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    postIncidences(formData as Incidence);
    setModalOpen(false);
    setFormData(initialState);
  };

  const handleDeclineForm = () => {
    setModalOpen(false);
    setFormData(initialState);
  };

  const handleViewClick = async (id: string) => {
    const apiUrlForIncidences = process.env.apiForIncidence || "";
    await handlerViewClick(apiUrlForIncidences, id);
  };

  const handleDeleteClick = async (id: string) => {
    const apiUrlForIncidences = process.env.apiForIncidence || "";
    await handlerDeleteClick(apiUrlForIncidences, id);
  };

  const handleEditClick = async (id: string) => {
    const apiUrlForIncidences = process.env.apiForIncidence || "";
    await handlerEditClick(apiUrlForIncidences, id);
  };

  return (
    <section className='flex w-full min-h-screen bg-background1 text-primary3 dark:bg-background3 dark:text-primary2 lg:p-6 gap-4'>
      {modalOpen && (
        <IncidencePostModal
          handleInputChange={handleModalInputAndTextareaChange}
          formData={formData}
          statuses={[
            { uid: "active", name: "Active" },
            { uid: "paused", name: "Paused" },
            { uid: "vacation", name: "Vacation" },
          ]}
          cambio={handleModalInputAndTextareaChange}
          handleFormSubmit={handleFormSubmit}
          handleDecline={handleDeclineForm}
        />
      )}

      {/* Contenedor para Sidebar y Notificaciones */}
      <div className='flex flex-col lg:flex-row'>
        {/* Sidebar Placeholder */}
        <div className='w-20 lg:w-20 xl:w-20 2xl:w-20'></div>

        {/* Notificaciones */}
        <div className='w-64 bg-white dark:bg-gray-800 shadow-lg p-4'>
          <Notifications />
        </div>
      </div>

      {/* Contenido Principal */}
      <div className='flex flex-col flex-grow w-full overflow-auto bg-white dark:bg-background3 shadow-lg p-4'>
        <h1 className='text-2xl lg:text-3xl font-bold text-primary1 dark:text-primary2 mb-4'>
          Dashboard y Reportes
        </h1>

        <StatisticsSummary stats={stats} onCardClick={handleCardClick} />

        {selectedState && recentTickets[selectedState] && (
          <div className='mt-4'>
            <h2 className='text-lg lg:text-xl font-semibold mb-4 text-accent1 dark:text-accent3'>
              Tickets: {selectedState}
            </h2>
            <TicketsTable tickets={recentTickets[selectedState]} />
          </div>
        )}

        <hr className='my-4 border-secondary1' />

        <div className='w-full'>
          <h1 className='text-xl lg:text-2xl font-bold mb-4 text-primary1 dark:text-primary2'>
            Reportes
          </h1>
          <p className='text-secondary1 mb-4'>Bienvenido a la sección de reportes.</p>

          <div className='overflow-x-auto'>
            <div className='min-w-[800px]'>
              <Table
                sortable={["name", "status"]}
                data={incidences.map((incidence) => incidence.detalles)}
                initialVisibleColumns={["all"]}
                statuses={[
                  { uid: "active", name: "Active" },
                  { uid: "paused", name: "Paused" },
                  { uid: "vacation", name: "Vacation" },
                ]}
                viewClick={handleViewClick}
                editClick={handleEditClick}
                deleteClick={handleDeleteClick}
                actions={true}
                handleAddClick={() => setModalOpen(true)}
              />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default withAuth(Dashboard);
