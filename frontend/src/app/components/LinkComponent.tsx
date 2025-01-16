import React from "react";
import Link from "next/link";
import { LinkProps } from "@/props/linkProps";

const LinkComponent = ({ nombre, redireccion, target }: LinkProps) => {
	return <Link href={redireccion} target={target}>{nombre}</Link>;
};

export default LinkComponent;
