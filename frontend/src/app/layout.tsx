// layout.tsx
"use client";
import { Montserrat, Roboto } from "next/font/google";
import "./globals.css"; // Si tienes tu archivo de estilos
import Sidebar from "./components/Layout/Sidebar";
import { Providers } from "./providers";
import { usePathname } from "next/navigation";

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

const RootLayout = ({ children }: { children: React.ReactNode }) => {
	const pathname = usePathname();
	const isLoginPage = pathname === "/login";
	return (
		<html lang='en'>
			<body
				// className={`${montserratFont.variable} ${robotoFont.variable} antialiased h-full w-full flex`}>
				className={`${montserratFont.variable} ${robotoFont.variable} `}>
				{/* className={`${montserratFont.variable} ${robotoFont.variable} antialiased flex flex-grow h-screen w-full bg-gradient-to-r from-blue-500 via-indigo-600 to-purple-700 dark:bg-background3 overflow-hidden`}> */}
				<Providers>
					<div className='antialiased grid grid-cols-[auto_1fr] h-screen w-full bg-gradient-to-r from-blue-500 via-indigo-600 to-purple-700 dark:bg-background3 overflow-hidden'>
						<div>{!isLoginPage && <Sidebar />}</div>

						<div>{children}</div>
					</div>
				</Providers>
			</body>
		</html>
	);
};
export default RootLayout;
