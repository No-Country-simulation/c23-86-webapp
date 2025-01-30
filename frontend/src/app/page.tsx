"use client";

import { useState } from "react";
import useTicketsStats from "@/hooks/useTicketsStats";
import StatisticsSummary from "./components/StatisticsSummary";
import TicketsTable from "./components/TicketsTable";
import withAuth from "./components/WithAuth";
import useAuthStore from "@/stores/authStore";
import { users } from "@/utils/Data/data";
import Table from "./components/Table/Table";
import handlerViewClick from "@/utils/functions/handlerViewClick";
import { Data } from "@/props/tableProps";
import Notifications from "./components/Notifications/Notifications";
import { users2 } from "@/utils/Data/data2";
import handlerDeleteClick from "@/utils/functions/handlerDeleteClick";
import handlerEditClick from "@/utils/functions/handlerEditClick";

const Dashboard = () => {
	// Hook personalizado para obtener datos de estadísticas y tickets
	const { stats, recentTickets } = useTicketsStats();
	//?const { user } = useAuthStore(); user en el estado global.
	// Estado para manejar la estadística seleccionada
	const [selectedState, setSelectedState] = useState<string | null>(null);
	const [showNotifications, setShowNotifications] = useState(false);

	// Función para manejar clics en las tarjetas de estadísticas
	const handleCardClick = (state: string) => {
		setSelectedState(state);
		setShowNotifications(!showNotifications);
	};
	const apiUrlForIncidences = process.env.apiForIncidence || "";

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
		<section className='flex flex-grow max-w-[calc(100vw-50px)] overflow-hidden min-h-screen bg-background1 text-primary3 dark:bg-background3 dark:text-primary2'>
			{/* Notificaciones dentro del layout */}
			<Notifications />

			{/* Contenedor Principal */}
			<div className='flex flex-col flex-grow w-full px-6 py-4 overflow-hidden'>
				{/* Título de la página */}
				<h1 className='text-3xl font-bold text-primary1 dark:text-primary2 mb-6'>
					Dashboard y Reportes
				</h1>

				{/* Sección de Estadísticas */}
				<StatisticsSummary stats={stats} onCardClick={handleCardClick} />

				{/* Tabla de Tickets según el estado seleccionado */}
				{selectedState && recentTickets[selectedState] && (
					<div className='mt-6'>
						<h2 className='text-xl font-semibold mb-4 text-accent1 dark:text-accent3'>
							Tickets: {selectedState}
						</h2>
						<TicketsTable tickets={recentTickets[selectedState]} />
					</div>
				)}

				{/* Separador Visual */}
				<hr className='my-8 border-secondary1' />

				{/* Sección de Reportes */}
				<div className='w-full flex-grow'>
					<h1 className='text-2xl font-bold mb-4 text-primary1 dark:text-primary2'>
						Reportes
					</h1>
					<p className='text-secondary1'>
						Bienvenido a la sección de reportes.
					</p>

					{/* 🔥 Contenedor de la Tabla Ajustado */}
					<div className='max-w-full overflow-x-auto'>
						<div className='min-w-[800px]'>
							<Table
								sortable = {["name", "status"]}
								data={users}
								initialVisibleColumns={[
									"id",
									"name",
									"age",
									"role",
									"team",
									"email",
									"status",
								]}
								statuses={[
									{ uid: "active", name: "Active" },
									{ uid: "paused", name: "Paused" },
									{ uid: "vacation", name: "Vacation" },
								]}
								viewClick={handleViewClick}
								editClick={handleEditClick}
								deleteClick={handleDeleteClick}
								actions= {true}
							/>
						</div>
					</div>
				</div>
			</div>
		</section>
		// </div>
	);
};
export default withAuth(Dashboard);
