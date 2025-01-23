// type Column ={
//     name: string;
//     uid: string;
//     sortable?: boolean;
// }
// type Status = {
//     uid: string;
//     name: string;
// }
// export type Data = {
//     id: number;
//     name: string;
//     role: string;
//     team: string;
//     status: string;
//     age: string;
//     avatar: string;
//     email: string;
// }

// export type TableProps = {
//     initialVisibleColumns: string[];
//     columns: Column[];
//     statuses: Status[];
//     data: Data[];

// }
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
};