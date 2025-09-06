export default function Education() {
    return (
        <section className="py-10 md:py-16">
            <div className="container max-w-screen-xl mx-auto px-4">
                <h1 className="font-medium text-gray-700 dark:text-gray-200 text-3xl md:text-4xl mb-5">Education</h1>
                <p className="font-normal text-gray-500 dark:text-gray-400 text-xs md:text-base mb-20">Below is a summary of the places I studied</p>

                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    <div className="bg-gray-50 dark:bg-gray-800 px-8 py-10 rounded-md">
                        <h3 className="font-medium text-black dark:text-gray-100 text-lg mb-1">Szent István High School</h3>
                        <h4 className="font-medium text-gray-700 dark:text-gray-200 text-lg mb-4">2016 – 2020</h4>
                        <p className="font-normal text-gray-500 dark:text-gray-400 text-md mb-4">
                            I learned the basics here. I had the <br />
                            opportunity to learn robotics with the Lego <br />
                            Mindstorms / Arduino platforms and programming in C#. </p>
                        <div className="relative">
                            <a href="https://szigbp.hu/" className="font-semibold text-gray-500 dark:text-gray-300 text-md relative z-10">See the place here</a>
                            <span className="w-32 h-1 bg-blue-200 dark:bg-blue-900 absolute bottom-1 left-0 z-0"></span>
                        </div>
                    </div>

                    <div className="bg-gray-50 dark:bg-gray-800 px-8 py-10 rounded-md">
                        <h3 className="font-medium text-black dark:text-gray-100 text-lg mb-1">Budapest University of Technology and Economics</h3>
                        <h4 className="font-medium text-gray-700 dark:text-gray-200 text-lg mb-4">2020 – 2024</h4>
                        <p className="font-normal text-gray-500 dark:text-gray-400 text-md mb-4">
                            This was the place where I started to <br />
                            understand the main concepts behind <br />
                            computers and programming. This is where <br />
                            I created my first serious projects. </p>
                        <div className="relative">
                            <a href="https://www.vik.bme.hu/en/welcome-to-bme-vik/" className="font-semibold text-gray-500 dark:text-gray-300 text-md relative z-10">See the place here</a>
                            <span className="w-32 h-1 bg-blue-200 dark:bg-blue-900 absolute bottom-1 left-0 z-0"></span>
                        </div>
                    </div>

                    <div className="bg-gray-50 dark:bg-gray-800 px-8 py-10 rounded-md">
                        <h3 className="font-medium text-black dark:text-gray-100 text-lg mb-1">Budapest University of Technology and Economics</h3>
                        <h4 className="font-medium text-gray-700 dark:text-gray-200 text-lg mb-4">2024 – (2026)</h4>
                        <p className="font-normal text-gray-500 dark:text-gray-400 text-md mb-4">
                            I&apos;m currently doing my Master&apos;s degree here. <br />
                            It is the continuation of the Bachler&apos;s course.  <br />
                            I hope I&apos;ll extend my knowledge with more <br />
                            useful SW architectures and skills. </p>
                        <div className="relative">
                            <a href="https://www.vik.bme.hu/en/welcome-to-bme-vik/" className="font-semibold text-gray-500 dark:text-gray-300 text-md relative z-10">See the place here</a>
                            <span className="w-32 h-1 bg-blue-200 dark:bg-blue-900 absolute bottom-1 left-0 z-0"></span>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}