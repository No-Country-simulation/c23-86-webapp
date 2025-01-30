import { Data } from "@/props/tableProps";

export const generateTableColumns = (data: Data, sortable: string[]) => {
	if (!data.length) return [];
	const keys = Object.keys(data[0]);
	const filteredKeys = keys.filter((key) => key !== "id");
	return filteredKeys.map((key) => ({
		name: key.toUpperCase(),
		uid: key,
		sortable: sortable.includes(key),
	}));
};
