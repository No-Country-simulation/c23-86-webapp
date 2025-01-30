import Link from "next/link";
import NavbarLogo from "./NavbarLogo";
import NavItem from "./NavItem";
import { AlertTriangle, FileText, Home, Phone, UserCog } from "lucide-react";
import { useState } from "react";

{/*lista de enlaces*/ }

const navLinks = [
  { href: "/", label: "Dashboard", icon: <Home size={24} /> },
  { href: "/calls", label: "Calls", icon: <Phone size={24} /> },
  { href: "/reports", label: "Reportes", icon: <FileText size={24} /> },
  { href: "/incident", label: "Incidentes", icon: <AlertTriangle size={24} /> },
  { href: "/admin", label: "Admin", icon: <UserCog size={24} /> },
];


export default function Sidebar() {
  const [hoveredItem, setHoveredItem] = useState<string | null>(null);

  return (
<nav className="h-screen w-20 bg-primary1 text-white flex flex-col items-center py-6 shadow-lg fixed left-0 top-0 transition-all duration-300">
{/* Logo */}
      <NavbarLogo />

      <ul className="mt-10 w-full flex flex-col gap-4 items-center">
        {navLinks.map(({ href, label, icon }) => (
          <li
            key={href}
            className="relative flex items-center group"
            onMouseEnter={() => setHoveredItem(label)}
            onMouseLeave={() => setHoveredItem(null)}
          >
            <Link href={href} className="flex items-center justify-center w-12 h-12 rounded-md hover:bg-primary3 transition duration-300">
              {icon}
            </Link>
            
            {/* Texto emergente con animación */}
            {hoveredItem === label && (
              <span className="absolute left-16 bg-primary3 text-white px-3 py-1 rounded-md text-sm transition-opacity duration-300 opacity-100">
                {label}
              </span>
            )}
          </li>
        ))}
      </ul>
    </nav>
  );
}