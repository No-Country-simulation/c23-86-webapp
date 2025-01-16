// layout.tsx
import Link from "next/link";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css"; // Si tienes tu archivo de estilos
import Sidebar from "./components/Layout/Sidebar";

// Definir fuentes personalizadas
const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body
        className={`${geistSans.variable} ${geistMono.variable} antialiased h-screen flex bg-gradient-to-r from-blue-500 via-indigo-600 to-purple-700`}
      >
        {/* Barra lateral */}
        <Sidebar />

        {/* Contenido principal */}
        <div className="flex flex-grow">
          <main className="flex-grow bg-white bg-opacity-90 rounded-lg m-6 p-6 shadow-md overflow-auto">
            {children}
          </main>
        </div>
      </body>
    </html>
  );
}
