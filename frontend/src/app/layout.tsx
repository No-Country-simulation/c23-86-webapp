// layout.tsx
import Link from "next/link";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css"; // Si tienes tu archivo de estilos

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
      <body className={`${geistSans.variable} ${geistMono.variable} antialiased h-screen flex bg-gradient-to-r from-blue-500 via-indigo-600 to-purple-700`}>
        {/* Navbar lateral */}
        <nav className="w-20 bg-gray-900 text-white flex flex-col items-center py-4 shadow-lg">
          {/* Íconos de logo */}
          <div className="mb-6">
            <Link href="/" className="hover:text-gray-400">
            <span className="text-3xl font-bold">LOGO</span>
            </Link>
          </div>
          <ul className="space-y-6">
            <li>
              <Link href="/" className="hover:text-gray-400">
                Dashboard
              </Link>
            </li>
            <li>
              <Link href="/calls" className="hover:text-gray-400">
                Calls
              </Link>
            </li>
            <li>
              <Link href="/reports" className="hover:text-gray-400">
               Reportes
              </Link>
            </li>
          </ul>
        </nav>

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
