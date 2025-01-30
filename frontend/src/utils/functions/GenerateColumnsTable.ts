import { Data } from "@/props/tableProps";

export const generateTableColumns = (data: Data) => {
	if (!data.length) return [];
	const keys = Object.keys(data[0]);
	return keys
		.map((key) => ({
			name: key.toUpperCase(),
			uid: key,
			sortable: ["id", "name", "age", "role", "status"].includes(key),
		}))
	;
};
