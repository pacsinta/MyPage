import Link from "next/link";
import { title } from "process";

interface PortfolioElementProps {
    title: string;
    description: string;
    index: string;
    link?: string;
}

function PortfolioElement({ title, description, index, link }: PortfolioElementProps) {
    return (
        <div className="flex space-x-6 cursor-pointer">
            <h1 className="font-normal text-gray-700 dark:text-gray-200 text-3xl md:text-4xl">{index}</h1>

            <span className="w-28 h-0.5 bg-gray-300 dark:bg-gray-700 mt-5"></span>

            <div className="w-full">
                {link ? (
                    <Link href={link} target="_blank" rel="noopener noreferrer">
                        <h2 className="font-normal text-gray-700 dark:text-gray-200 text-3xl md:text-4xl mb-5">{title}</h2>
                        <p className="font-normal text-gray-500 dark:text-gray-400 text-sm md:text-base">{description}</p>
                    </Link>
                ) : (
                    <>
                        <h2 className="font-normal text-gray-700 dark:text-gray-200 text-3xl md:text-4xl mb-5">{title}</h2>
                        <p className="font-normal text-gray-500 dark:text-gray-400 text-sm md:text-base">{description}</p>
                    </>
                )}
            </div>
        </div>
    );
}

export default function Portfolio() {
    return (
        <section className="py-10 md:py-16">

            <div className="container max-w-screen-xl mx-auto px-4">

                <div className="flex flex-col lg:flex-row justify-between">
                    <div className="mb-10 lg:mb-0 lg:w-2/5 flex-shrink-0">
                        <h1 className="font-medium text-gray-700 dark:text-gray-200 text-3xl md:text-4xl mb-5">Portfolio</h1>

                        <p className="font-normal text-gray-500 dark:text-gray-400 text-xs md:text-base">I have brought here my biggest and favorite works <br /> as a professional.</p>
                    </div>

                    <div className="space-y-24">
                        {[
                            {
                                title: "Storage AI",
                                description: "I built a cloud storage app that uses an LLM to help with file management and search. It is deployed to my homelab Kubernetes server, and I hope it will be live soon."
                            },
                            {
                                title: "Cyber security ticketing page",
                                description: "I collaborated on the development of a vulnerability management webpage designed to track security findings, coordinate testing schedules, and streamline application requests."
                            },
                            {
                                title: "Contract Change Classifier",
                                description: "I helped develop a tool that uses large language models to categorize contract modifications into predefined classes, helping with contract management and analysis.",
                                link: "https://github.com/pacsinta/contract-classifier"
                            },
                            {
                                title: "CIS Benchmark Analyzer",
                                description: "I created a solution that leverages generative AI to assess system compliance with CIS benchmarks by automatically evaluating configurations against security standards.",
                            },
                            {
                                title: "Signature Verification System",
                                description: "I built an application that validates handwritten signatures using recurrent neural networks for comparison and authentication purposes.",
                                link: "https://github.com/pacsinta/signatureTester"
                            },
                            {
                                title: "360° Parking Visualization",
                                description: "I contributed to an automotive parking system that provides drivers with a comprehensive 360-degree view of their surroundings for safer parking maneuvers."
                            },
                            {
                                title: "Tennis Monsters",
                                description: "I designed a multiplayer game where players control monsters in a tennis-style competition, aiming to successfully return the ball to the opponent's court."
                            }
                        ].map((project, idx) => (
                            <PortfolioElement
                                key={idx}
                                index={`0${idx + 1}`}
                                title={project.title}
                                description={project.description}
                                link={project.link}
                            />
                        ))}
                    </div>
                </div>

            </div>

        </section>
    );
}