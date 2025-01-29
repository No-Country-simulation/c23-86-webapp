'use client'; // components/withAuth.tsx
import { useEffect } from "react";
import { useRouter } from "next/navigation";
import useAuthStore from "@/stores/authStore";

const withAuth = <P extends object>(
	WrappedComponent: React.ComponentType<P>
) => {
	const AuthComponent: React.FC<P> = (props) => {
		const router = useRouter();
		const { isLoggedIn } = useAuthStore();

		useEffect(() => {
			if (!isLoggedIn) {
				router.replace("/login"); // Redirigir a la página de login si no está autenticado
			}
		}, [isLoggedIn, router]);

		return isLoggedIn ? <WrappedComponent {...props} /> : null;
	};

	return AuthComponent;
};

export default withAuth;
