import React from "react";
import Link from "next/link";
import { LinkProps } from "@/props/linkProps";

const LinkComponent = ({ nombre, redireccion }: LinkProps) => {
	return <Link href={redireccion}>{nombre}</Link>;
};

export default LinkComponent;
