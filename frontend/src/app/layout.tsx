"use client";
import { Montserrat, Roboto } from "next/font/google";
import "./globals.css";
import Sidebar from "./components/Layout/Sidebar";
import Notifications from "./components/Notifications/Notifications";
import { Providers } from "./providers";
import { usePathname } from "next/navigation";

// Fuentes
const montserratFont = Montserrat({
  subsets: ["latin"],
  weight: ["400", "700"],
  variable: "--font-montserrat",
});

const robotoFont = Roboto({
  subsets: ["latin"],
  weight: ["400", "700"],
  variable: "--font-roboto",
});

const RootLayout = ({ children }: { children: React.ReactNode }) => {
  const pathname = usePathname();
  const isLoginPage = pathname === "/login";

  return (
    <html lang="en" className="h-full">
      <body
        className={`${montserratFont.variable} ${robotoFont.variable} antialiased h-full w-full flex`}
      >
        <Providers>
          {!isLoginPage && (
            <div className="flex">
              {/* Sidebar */}
              <Sidebar />

              {/* Contenedor de notificaciones + contenido principal */}
              <div className="flex">
                {/* Notificaciones pegadas al Sidebar */}
                <Notifications />

                {/* Contenido principal: Ajustamos `flex-grow` y `w-full` para que ocupe todo el espacio restante */}
				<main className="flex-grow w-full min-h-screen bg-white shadow-lg p-8">
				{children}
                </main>
              </div>
            </div>
          )}

          {isLoginPage && <main className="w-full min-h-screen">{children}</main>}
        </Providers>
      </body>
    </html>
  );
};

export default RootLayout;
