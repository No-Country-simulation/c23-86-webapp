"use client";

import React, { useState } from "react";
import Input from "@/app/components/Input";

const Login = () => {
	const [email, setEmail] = useState("");
	const [emailError, setEmailError] = useState<string | null>(null);

	const [password, setPassword] = useState("");
	const [passwordError, setPasswordError] = useState<string | null>(null);

	// Validación del correo electrónico
	const validateEmail = (value: string) => {
		if (!value) {
			setEmailError("El campo no puede estar vacío.");
		} else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value)) {
			setEmailError("El correo electrónico no es válido.");
		} else {
			setEmailError(null);
		}
		setEmail(value);
	};

	// Validación de la contraseña
	const validatePassword = (value: string) => {
		if (!value) {
			setPasswordError("El campo no puede estar vacío.");
		} else if (value.length < 8) {
			setPasswordError("La contraseña debe tener al menos 8 caracteres.");
		} else {
			setPasswordError(null);
		}
		setPassword(value);
	};

	return (
		<form>
			<Input
				nombre='Email'
				value={email}
				error={emailError ?? ""}
				cambio={validateEmail}
				inputType='email'
			/>

			<Input
				nombre='Contraseña'
				value={password}
				error={passwordError ?? ""}
				cambio={validatePassword}
				inputType='password'
			/>

			<button type='submit' disabled={!!emailError || !!passwordError}>
				Enviar
			</button>
		</form>
	);
};

export default Login;
