import { Data } from "@/props/tableProps";

export const generateTableColumns = (data: Data, sortable: string[]) => {
	if (!data.length) return [];
	const keys = Object.keys(data[0]);
	return keys.map((key) => ({
		name: key.toUpperCase(),
		uid: key,
		sortable: sortable.includes(key),
	}));
};

export const generateColumns = (data: Data) => {
	if (!data.length) return [];
	const keys = Object.keys(data[0]);
	return keys.map((key) => ({
		name: key.toUpperCase(),
		uid: key,
	}));
 }