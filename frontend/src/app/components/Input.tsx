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
		<div className='flex flex-col gap-2  '>
		
			<div className='relative flex items-center '>
				<input
					className=' w-[318px] h-[37px] rounded-[4px] border border-solid font-normal  box-border text-[14px] leading-[17px]   italic font-montserrat '
					type={inputType}
					id={inputType}
					name={nombre}
					value={value}
					onChange={handleChange}
					placeholder={nombre}
				/>
				{item && (
					<div className='hover:cursor-pointer hover:transform hover:scale-110 absolute right-0 top-[3px] w-auto h-full flex items-center justify-end  '>
						{item}
					</div>
				)}
			</div>
			<div>

			{error && <span className='error-message'>{error}</span>}
			</div>
		</div>
	);
};

export default Input;
