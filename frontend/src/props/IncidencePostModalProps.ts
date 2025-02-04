import { Incidence, PostIncidenceProps } from "./IncidenceProps";

type Status = {
	uid: string;
	name: string;
};

type Data<T = Record<string, any>> = T;

export type IncidencePostModalProps<T = Record<string, any>> = {
	cambio: Function;
    statuses: Status[];
    formData: PostIncidenceProps;
    handleDecline: () => void;
    handleFormSubmit: (e: React.FormEvent<HTMLFormElement>) => void;
    handleInputChange: (field: string, value: string) => void;
};
