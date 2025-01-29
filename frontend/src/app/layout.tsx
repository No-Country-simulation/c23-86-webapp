// layout.tsx
"use client";
import { Montserrat, Roboto } from "next/font/google";
import "./globals.css"; // Si tienes tu archivo de estilos
import Sidebar from "./components/Layout/Sidebar";
import { Providers } from "./providers";
import { usePathname } from "next/navigation";
import LoginForm from "./components/Login/LoginForm";

// Definir fuentes personalizadas
const montserratFont = Montserrat({
	subsets: ["latin"],
	weight: ["400", "700"], // Sin italic
	variable: "--font-montserrat",
});

const robotoFont = Roboto({
	subsets: ["latin"],
	weight: ["400", "700"],
	variable: "--font-roboto",
});

// Fuentes en cursiva (italic)
const montserratItalicFont = Montserrat({
	subsets: ["latin"],
	style: "italic",
	weight: ["400", "700"],
	variable: "--font-montserrat-italic",
});

const robotoItalicFont = Roboto({
	subsets: ["latin"],
	style: "italic",
	weight: ["400", "700"],
	variable: "--font-roboto-italic",
});

export default function RootLayout({
	children,
}: {
	children: React.ReactNode;
}) {
	const pathname = usePathname();
	const isLoginPage = pathname === "/login";
	return (
		<html lang="en" className="h-full">
      <body className={`${montserratFont.variable} ${robotoFont.variable} antialiased h-full w-full flex`}>
			
				<Providers>
					{!isLoginPage && <Sidebar />}
					<main className="ml-64 flex-grow h-screen w-full bg-gradient-to-r from-blue-500 via-indigo-600 to-purple-700 dark:bg-background3 flex flex-col overflow-hidden">
					<div className="flex-grow w-full h-full p-8 bg-white shadow-lg rounded-lg overflow-auto">
					{children}
						</div>
					</main>
				</Providers>
			</body>
		</html>
	);
}
