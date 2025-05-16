interface PortfolioElementProps {
  title: string;
  description: string;
  index: string | number;
}

function PortfolioElement({ title, description, index }: PortfolioElementProps) {
    return (
        <div className="flex space-x-6">
            <h1 className="font-normal text-gray-700 text-3xl md:text-4xl">{index}</h1>

            <span className="w-28 h-0.5 bg-gray-300 mt-5"></span>

            <div className="w-full">
                <h1 className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">{title}</h1>
                <p className="font-normal text-gray-500 text-sm md:text-base">{description}</p>
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
                                title: "CIS benchmark analyzer",
                                description: "This software can analyze if the system is compliant with the CIS benchmark. It uses generative AI to read and verify the system settings and compare them with the benchmark."
                            },
                            {
                                title: "Signature tester",
                                description: "This software can validate handwritten signatures. It uses a recurrent neural network to compare the signatures."
                            },
                            {
                                title: "Parking visualization",
                                description: "I was part of a project to develop parking software for automobiles. We were working on software capable of 360° visualization around the car."
                            },
                            {
                                title: "Tennis monsters game",
                                description: "This is a multiplayer game where each player can control a monster. The goal is to successfully hit the ball to the other player's field."
                            },
                            {
                                title: "Can you find it",
                                description: 'I created this mobile app to try out text recognition on Android. The goal in this app is to find a "Hello World" text with the camera in the real world. If you find it, there is a reward for you.'
                            }
                        ].map((project, idx) => (
                            <PortfolioElement
                                key={idx}
                                index={`0${idx + 1}`}
                                title={project.title}
                                description={project.description}
                            />
                        ))}
                    </div>
                </div>

            </div>

        </section>
    );
}