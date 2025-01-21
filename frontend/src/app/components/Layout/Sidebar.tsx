import { link } from "fs";
import NavbarLogo from "./NavbarLogo";
import NavItem from "./NavItem";

{/*lista de enlaces*/ }

const navLinks = [
  { href: "/", label: "Dashboard" },
  { href: "/calls", label: "Calls" },
  { href: "/reports", label: "Reportes" },
  {href: "/incident", label: "Incidentes"},
  {href: "/admin", label: "admin"}
  
  // Aca agregamos los links que hagan falta...
];


export default function Sidebar() {
  return (
    <nav className="w-20 bg-gray-900 text-white flex flex-col items-center py-4 shadow-lg">
      {/* Logo */}
      <NavbarLogo />

      <ul className="space-y-6 mt-6">
        {navLinks.map((link) => (
          <NavItem key={link.href} href={link.href} label={link.label} />
        ))}
      </ul>
    </nav>
  );
}
