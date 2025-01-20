import Link from "next/link";

type NavItemProps = {
  href: string;
  label: string;
};

export default function NavItem({ href, label } : NavItemProps) {
  return (
    <li>
      <Link href={href} className="hover:text-gray-400">
        {label}
      </Link>
    </li>
  );
}