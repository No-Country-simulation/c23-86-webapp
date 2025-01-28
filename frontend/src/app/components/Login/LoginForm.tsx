"use client";

import React, { useState } from "react";
import Input from "@/app/components/Input";
import Button from "@/app/components/Button";
import ItemButton from "@/app/components/Login/ItemButton";
import LinkComponent from "@/app/components/LinkComponent";
import HidePassword from "@/app/components/Login/HidePassword";
import ShowPassword from "@/app/components/Login/ShowPassword";
import { useRouter } from "next/navigation";
import useAuthStore from "@/stores/authStore";

const LoginForm = () => {
	const [email, setEmail] = useState("");
	const [emailError, setEmailError] = useState<string | null>(null);
	const [password, setPassword] = useState("");
	const [passwordError, setPasswordError] = useState<string | null>(null);
	const [showPassword, setShowPassword] = useState(false);
	const router = useRouter();
	const { login } = useAuthStore();
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

		// Simulación de credenciales válidas
		const validEmail = "usuario@example.com";
		const validPassword = "password123";

		if (email === validEmail && password === validPassword) {
			// Redirige al home si las credenciales son válidas
			 login({ username: email });
			router.push("/");
		} else {
			// Muestra un mensaje de error si las credenciales no son válidas
			alert("Credenciales incorrectas. Por favor, inténtalo de nuevo.");
		}
		setEmail("");
		setPassword("");
	};
	const showPasswordHandler = () => {
		setShowPassword(!showPassword);
	};
	return (
		<form onSubmit={handleSubmit}>
			<Input
				nombre='tucorreo@gmail.com'
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
					<ItemButton
						type='button'
						disableOptions={false}
						handler={showPasswordHandler}
						buttonName={showPassword ? <HidePassword /> : <ShowPassword />}
					/>
				}
			/>
			<div className='font-montserrat font-normal text-[14px] leading-[17px] italic'>
				<LinkComponent
					cssClass='underline'
					nombre='Olvidé mi contraseña'
					redireccion='/regis'
					target='_blank'></LinkComponent>
			</div>
			<div className='flex justify-center'>
				<Button
					type='submit'
					disableOptions={!!emailError || !!passwordError}
					buttonName='Iniciar sesión'
				/>
			</div>
		</form>
	);
};

export default LoginForm;
