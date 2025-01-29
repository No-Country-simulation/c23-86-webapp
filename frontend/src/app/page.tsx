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

const Dashboard = () => {
	// Hook personalizado para obtener datos de estadísticas y tickets
	const { stats, recentTickets } = useTicketsStats();
	//?const { user } = useAuthStore(); user en el estado global. 
	// Estado para manejar la estadística seleccionada
	const [selectedState, setSelectedState] = useState<string | null>(null);

	// Función para manejar clics en las tarjetas de estadísticas
	const handleCardClick = (state: string) => {
		setSelectedState(state);
	};

	const handleViewClick = (data: Data) => {
		if ("apiUrl" in data && "id" in data) {
			handlerViewClick({ apiUrl: data.apiUrl, id: data.id });
		} else {
			console.error("Error: Datos inválidos para viewClick", data);
		}
	};

	// Definición de columnas para la tabla de reportes
	const columnas = [
		{ name: "ID", uid: "id", sortable: true },
		{ name: "NAME", uid: "name", sortable: true },
		{ name: "AGE", uid: "age", sortable: true },
		{ name: "ROLE", uid: "role", sortable: true },
		{ name: "TEAM", uid: "team" },
		{ name: "EMAIL", uid: "email" },
		{ name: "STATUS", uid: "status", sortable: true },
		{ name: "ACTIONS", uid: "actions" },
	];

	return (
		<section className='flex flex-grow w-full min-h-screen bg-background1 text-primary3 dark:bg-background3 dark:text-primary2'>
			<Notifications />

			<div className='w-3/5 flex flex-col px-6 py-4 overflow-auto'>
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

					<Table
						columns={columnas}
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
					/>
				</div>
			</div>
		</section>
	);
};
export default withAuth(Dashboard);
