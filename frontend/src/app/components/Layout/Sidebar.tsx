import NavbarLogo from "./NavbarLogo";
import NavItem from "./NavItem";

export default function Sidebar() {
  return (
    <nav className="w-20 bg-gray-900 text-white flex flex-col items-center py-4 shadow-lg">
      {/* Logo */}
      <NavbarLogo />

      {/* Lista de enlaces */}
      <ul className="space-y-6 mt-6">
        <NavItem href="/" label="Dashboard" />
        <NavItem href="/calls" label="Calls" />
        <NavItem href="/reports" label="Reportes" />
      </ul>
    </nav>
  );
}
