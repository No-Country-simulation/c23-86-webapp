import React from "react";
import Input from "../Input";
import Textarea from "../Textarea";
import { PostIncidenceProps } from "@/props/IncidenceProps";

const DetailsForm = ({
	formData,
	handleInputChange,
}: {
	formData: PostIncidenceProps;
	handleInputChange: (field: string, value: string) => void;
}) => {
	return (
		<div className='grid grid-cols-2 gap-4'>
			<Input
				nombre='Código de empleado'
				inputType='number'
				cambio={handleInputChange}
				value={formData.idEmpleado || ""}
			/>
			<Input
				nombre='Nombre de empleado'
				inputType='text'
				cambio={handleInputChange}
				value={formData.nombreEmpleado || ""}
			/>
			<Input
				nombre='Apellido de empleado'
				inputType='text'
				cambio={handleInputChange}
				value={formData.apellidoEmpleado || ""}
			/>
			<Input
				nombre='Fecha de modificacion'
				inputType='date'
				cambio={handleInputChange}
				value={formData.fechaDeModificacion || ""}
			/>
			<Textarea
				nombre='Descripción'
				cambio={handleInputChange}
				value={formData.descripcion || ""}
			/>
			<select
				className='w-full p-2 rounded border dark:bg-gray-700'
				value={formData.estado || ""}
				onChange={(e) => handleInputChange("estado", e.target.value)}>
				<option value='pendiente'>Pendiente</option>
				<option value='completado'>Completado</option>
			</select>
			<select
				className='w-full p-2 rounded border dark:bg-gray-700'
				value={formData.prioridad || ""}
				onChange={(e) => handleInputChange("prioridad", e.target.value)}>
				<option value='alta'>Alta</option>
				<option value='media'>Media</option>
				<option value='baja'>Baja</option>
			</select>
		</div>
	);
};

export default DetailsForm;
