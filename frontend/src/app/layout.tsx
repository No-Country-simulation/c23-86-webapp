"use client";
import { Montserrat, Roboto } from "next/font/google";
import "./globals.css";
import Sidebar from "./components/Layout/Sidebar";
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
      <body className={`${montserratFont.variable} ${robotoFont.variable} antialiased h-full w-full`}>
        <Providers>
          {!isLoginPage && (
            <div className="flex h-full">
              {/* Sidebar */}
              <Sidebar />

              {/* Contenedor Principal */}
              <main className="flex-grow min-h-screen bg-white shadow-lg p-4 lg:p-6 xl:p-8 2xl:p-10 flex">
                {/* Contenido Dinámico */}
                <div className="flex-grow">
                  {children}
                </div>
              </main>
            </div>
          )}

          {isLoginPage && <main className="w-full min-h-screen p-4 lg:p-6 xl:p-8 2xl:p-10">{children}</main>}
        </Providers>
      </body>
    </html>
  );
};

export default RootLayout; 
