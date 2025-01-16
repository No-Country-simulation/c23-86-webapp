"use client";
import React from "react";
import { InputProps } from "@/props/InputProps";

const Input = ({
	nombre,
	error,
	cambio,
	value,
	item,
	inputType,
}: InputProps) => {
	const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
		const newValue = event.target.value;
		cambio(newValue);
	};

	return (
		<div className='flex flex-row gap-2  '>
			<label htmlFor={inputType}>{nombre}</label>
			<div className='relative flex items-center '>
				<input
					className=' w-full  border border-solid box-border '
					type={inputType}
					id={inputType}
					name={nombre}
					value={value}
					onChange={handleChange}
				/>
				{item && (
					<div className='hover:cursor-pointer hover:transform hover:scale-110 absolute right-0 top-[3px] w-auto h-full flex items-center justify-end  '>
						{item}
					</div>
				)}
			</div>
			{error && <span className='error-message'>{error}</span>}
		</div>
	);
};

export default Input;
