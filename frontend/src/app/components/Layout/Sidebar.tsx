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
    <nav className="h-screen  bg-primary1 text-white flex flex-col items-center py-6 shadow-lg fixed left-0 top-0">
      {/* Logo */}
      <NavbarLogo />

      <ul className="mt-10 w-full">
        {navLinks.map((link) => (
          <NavItem key={link.href} href={link.href} label={link.label} />
        ))}
      </ul>
    </nav>
  );
}
