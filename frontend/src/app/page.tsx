import withAuth from "./components/WithAuth";

const Home=()=> {
	return (
		<div>
			<h1 className='text-2xl font-bold'>Dashboard</h1>
			<p>Bienvenido al dashboard principal.</p>
		</div>
	);
}
export default withAuth(Home)