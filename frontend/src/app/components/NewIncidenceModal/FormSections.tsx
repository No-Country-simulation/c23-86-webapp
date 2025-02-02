interface SectionProps {
	title: string;
	children: React.ReactNode;
}

const Section: React.FC<SectionProps> = ({ title, children }) => (
	<div className='mb-4 p-1 border-b border-gray-300 dark:border-gray-600'>
		<h3 className='text-lg font-semibold mb-2'>{title}</h3>
		{children}
	</div>
);
export default Section;