"use client";

import React, { useState } from "react";
import Input from "@/app/components/Input";
import Button from "@/app/components/Button";
import LinkComponent from "@/app/components/LinkComponent";
import HidePassword from "@/app/components/Login/HidePassword";
import ShowPassword from "@/app/components/Login/ShowPassword";

const LoginForm= () => {
	const [email, setEmail] = useState("");
	const [emailError, setEmailError] = useState<string | null>(null);

	const [password, setPassword] = useState("");
	const [passwordError, setPasswordError] = useState<string | null>(null);
	const [showPassword, setShowPassword] = useState(false);

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

	const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
		event.preventDefault();
	};

	const showPasswordHandler = () => {
		setShowPassword(!showPassword);
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
				inputType={showPassword ? "text" : "password"}
				item={
					<Button
						type='button'
						disableOptions={false}
						handler={showPasswordHandler}
						buttonName={showPassword ? <HidePassword /> : <ShowPassword />}
					/>
				}
			/>
			<LinkComponent
				nombre='He olvidado la contraseña'
				redireccion='/regis'
				target='_blank'></LinkComponent>
			<Button
				type='submit'
				disableOptions={!!emailError || !!passwordError}
				buttonName='Enviar'
			/>
		</form>
	);
};

export default LoginForm;
