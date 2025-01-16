import Link from "next/link";

export default function NavbarLogo() {
  return (
    <div className="mb-6">
      <Link href="/" className="hover:text-gray-400">
        <span className="text-3xl font-bold">LOGO</span>
      </Link>
    </div>
  );
}
