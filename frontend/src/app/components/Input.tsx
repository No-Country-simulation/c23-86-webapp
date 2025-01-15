"use client";
import React from "react";
import { InputProps } from "@/props/InputProps";

const Input = ({ nombre, error, cambio, value, item, inputType }: InputProps) => {
    const handleChange= (event: React.ChangeEvent<HTMLInputElement>) => {
        const newValue = event.target.value;
        cambio(newValue)
    }
    
	return (
		<div>
			<label htmlFor={inputType}>{nombre}</label>
			<input
				type={inputType}
				id={inputType}
				name={nombre}
				value={value}
				onChange={handleChange}
			/>
			
			{error && <span className='error-message'>{error}</span>}
			{item && item}
		</div>
	);
};

export default Input;
