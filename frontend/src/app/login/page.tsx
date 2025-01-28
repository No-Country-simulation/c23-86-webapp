import LoginForm from "@/app/components/Login/LoginForm";
import LoginHead from "../components/Login/LoginHead";

const Login = () => {
	return (
		<div className='flex flex-col justify-center items-center  w-screen h-screen '>
			<LoginHead/>
			<LoginForm />
		</div>
	);
};

export default Login;
