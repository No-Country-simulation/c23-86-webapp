import React from 'react'
import Input from "../Input";
import { PostIncidenceProps } from '@/props/IncidenceProps';

const ClientsForm = ({formData, handleInputChange}:{ formData: PostIncidenceProps, handleInputChange:(field: string, value: string) => void;}) => (
	<div className='grid grid-cols-2 gap-4'>
		<Input
			nombre='Nombre'
			inputType='text'
			cambio={handleInputChange}
			value={formData.nombre || ""}
		/>
		<Input
			nombre='Apellido'
			inputType='text'
			cambio={handleInputChange}
			value={formData.apellido || ""}
		/>
		<Input
			nombre='DNI'
			inputType='number'
			cambio={handleInputChange}
			value={formData.dni || ""}
		/>
		<Input
			nombre='Correo'
			inputType='email'
			cambio={handleInputChange}
			value={formData.correo || ""}
		/>
		<Input
			nombre='Telefono'
			inputType='tel'
			cambio={handleInputChange}
			value={formData.telefono || ""}
		/>
		<select
			className='w-full p-2 rounded border dark:bg-gray-700'
			value={formData.estado || ""}
			onChange={(e) => handleInputChange("estado", e.target.value)}>
			<option value='activo'>Activo</option>
			<option value='inactivo'>Inactivo</option>
		</select>
	</div>
);

export default ClientsForm
