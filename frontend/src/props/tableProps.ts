

type Column = {
	name: string;
	uid: string;
	sortable?: boolean;
};

type Status = {
	uid: string;
	name: string;
};

// Data genérico para aceptar diferentes estructuras
export type Data<T = Record<string, any>> = T;

export type TableProps<T = Record<string, any>> = {
	initialVisibleColumns: string[];
	columns: Column[];
	statuses: Status[];
	data: Data<T>[];
	editClick?: (data: Data<T>) => void;
	viewClick?: (data: Data<T>) => void;
	deleteClick?: (data: Data<T>) => void;
};