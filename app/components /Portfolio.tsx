import Link from "next/link";

interface PortfolioElementProps {
    title: string;
    description: string;
    index: string;
    link?: string;
}

function PortfolioElement({ title, description, index, link }: PortfolioElementProps) {
    return (
        <div className="flex space-x-6 cursor-pointer">
            <h1 className="font-normal text-gray-700 text-3xl md:text-4xl">{index}</h1>

            <span className="w-28 h-0.5 bg-gray-300 mt-5"></span>

            <div className="w-full">
                {link ? (
                    <Link href={link} target="_blank" rel="noopener noreferrer">
                        <h2 className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">{title}</h2>
                        <p className="font-normal text-gray-500 text-sm md:text-base">{description}</p>
                    </Link>
                ) : (
                    <>
                        <h2 className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">{title}</h2>
                        <p className="font-normal text-gray-500 text-sm md:text-base">{description}</p>
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
                        <h1 className="font-medium text-gray-700 text-3xl md:text-4xl mb-5">Portfolio</h1>

                        <p className="font-normal text-gray-500 text-xs md:text-base">I have brought here my biggest and favorite works <br /> as a professional.</p>
                    </div>

                    <div className="space-y-24">
                        {[
                            {
                                title: "Contract change classifier",
                                description: "I helped to develop a software that can classify contract changes. Is used an LLM to classify each modified section of the contract into a predefined category.",
                            },
                            {
                                title: "CIS benchmark analyzer",
                                description: "This software can analyze if the system is compliant with the CIS benchmark. It uses generative AI to read and verify the system settings and compare them with the benchmark.",
                            },
                            {
                                title: "Signature tester",
                                description: "This software can validate handwritten signatures. It uses a recurrent neural network to compare the signatures.",
                                link: "https://github.com/pacsinta/signatureTester"
                            },
                            {
                                title: "Parking visualization",
                                description: "I was part of a project to develop parking software for automobiles. We were working on software capable of 360° visualization around the car."
                            },
                            {
                                title: "Tennis monsters game",
                                description: "This is a multiplayer game where each player can control a monster. The goal is to successfully hit the ball to the other player's field."
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