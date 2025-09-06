export default function Experience() {
    return (
        <section className="py-10 md:py-16">
            <div className="container max-w-screen-xl mx-auto px-4">
                <h1 className="font-medium text-gray-700 dark:text-gray-200 text-3xl md:text-4xl mb-5">Experience</h1>
                <p className="font-normal text-gray-500 dark:text-gray-400 text-xs md:text-base mb-20">Below is a summary of the places I worked at</p>

                <div className="flex flex-col lg:flex-row justify-between">
                    <div className="space-y-8 md:space-y-16 mb-16 md:mb-0">
                        <h6 className="font-medium text-gray-400 dark:text-gray-300 text-base uppercase">Company</h6>
                        <p className="font-semibold text-gray-600 dark:text-gray-200 text-base">ExxonMobil <span className="font-normal text-gray-300 dark:text-gray-400">/ Budapest</span></p>
                        <p className="font-semibold text-gray-600 dark:text-gray-200 text-base">Robert Bosch <span className="font-normal text-gray-300 dark:text-gray-400">/ Budapest</span></p>
                    </div>

                    <div className="space-y-8 md:space-y-16 mb-16 md:mb-0">
                        <h6 className="font-medium text-gray-400 dark:text-gray-300 text-base uppercase">Position</h6>
                        <p className="font-normal text-gray-400 dark:text-gray-200 text-base">Full-Stack developer</p>
                        <p className="font-normal text-gray-400 dark:text-gray-200 text-base">C++ developer</p>
                    </div>

                    <div className="space-y-8 md:space-y-16">
                        <h6 className="font-medium text-gray-400 dark:text-gray-300 text-base uppercase">Year</h6>
                        <p className="font-normal text-gray-400 dark:text-gray-200 text-base">2025</p>
                        <p className="font-normal text-gray-400 dark:text-gray-200 text-base">2022 - 2025</p>
                    </div>
                </div>

            </div>
        </section>
    );
}