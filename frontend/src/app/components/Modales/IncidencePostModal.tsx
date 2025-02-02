import React from "react";
import Button from "@/app/components/Button";
import Textarea from "../Textarea";
import Input from "../Input";
import { IncidencePostModalProps } from "@/props/IncidencePostModalProps";
import { capitalize } from "@/utils/functions/capitalize";
import { generateColumns } from "@/utils/functions/GenerateColumnsTable";

const IncidencePostModal = ({
	formData,
	statuses,
	cambio,
	handleDecline,
	handleFormSubmit,
	handleInputChange,
}: IncidencePostModalProps) => {
	const columns = generateColumns(formData);
	return (
		<div className='fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50'>
			<div className='bg-white dark:bg-gray-800 p-6 rounded-lg w-full max-w-2xl'>
				<h2 className='text-xl font-bold mb-4'>Agregar nueva incidencia</h2>
				<form onSubmit={handleFormSubmit}>
					<div className='grid grid-cols-1 gap-4 mb-4'>
						{columns
							.filter(
								(column) => column.uid !== "actions" && column.uid !== "id"
							)
							.map((column) => (
								<div key={column.uid}>
									<label className='block text-sm font-medium mb-1'>
										{capitalize(column.name)}
									</label>

									{column.uid === "status" ? (
										<select
											className='w-full p-2 rounded border dark:bg-gray-700'
											value={formData[column.uid] || ""}
											onChange={(e) =>
												handleInputChange(column.uid, e.target.value)
											}>
											{statuses.map((status) => (
												<option key={status.uid} value={status.uid}>
													{status.name}
												</option>
											))}
										</select>
									) : column.uid === "descripcion" ? (
										<Textarea
											nombre='descripcion'
											cambio={cambio}
											value={formData[column.uid] || ""}
										/>
									) : (
										<Input
											inputType='text'
											nombre={column.uid}
											cambio={cambio}
											value={formData[column.uid] || ""}
										/>
									)}
								</div>
							))}
					</div>

					<div className='flex justify-end gap-2'>
						<Button
							type='button'
							buttonName='Cancel'
							disableOptions={false}
							handler={handleDecline}
						/>
						<Button type='submit' buttonName='Save' disableOptions={false} />
					</div>
				</form>
			</div>
		</div>
	);
};

export default IncidencePostModal;
