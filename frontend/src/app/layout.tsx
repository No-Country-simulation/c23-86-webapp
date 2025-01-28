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
		<html lang='en'>
			<body
				className={`${montserratFont.className} ${robotoFont.className} ${montserratItalicFont.variable} ${robotoItalicFont.variable} antialiased  h-screen flex w-screen bg-gradient-to-r from-blue-500 via-indigo-600 to-purple-700`}>
				<Providers>
					{!isLoginPage && <Sidebar />}
					{children}
					{/* <div className={`flex  flex-grow`}>
						<main className=' flex  bg-opacity-90 rounded-lg shadow-md overflow-hidden'>
							{children}
						</main>
					</div> */}
				</Providers>
			</body>
		</html>
	);
}
