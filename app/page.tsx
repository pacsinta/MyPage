import EmailWriter from "./emailwriter";
import SocialLinks from "./sociallinks";
import Image from 'next/image';

export default function Home() {
  return (
    <div>

      <section className="py-10 md:py-16">
        <div className="container max-w-screen-xl mx-auto px-4">
          <nav className="flex items-center justify-between mb-40">
            <Image src="/icon2.jpg" alt="Logo" className="w-10 h-10" width={40} height={40} />
            <a href="/patrik_csikos-cv.pdf" download className="px-7 py-3 md:px-9 md:py-4 bg-white font-medium md:font-semibold text-gray-700 text-md rounded-md hover:bg-gray-700 hover:text-white transition ease-linear duration-500">Get my CV</a>
          </nav>

          <div className="text-center">
            <div className="flex justify-center mb-16">
              <Image src="/profile1.png" alt="Image" width={360} height={360} />
            </div>
            <h6 className="font-medium text-gray-600 text-lg md:text-2xl uppercase mb-8">Patrik Csikós</h6>
            <h1 className="font-normal text-gray-900 text-4xl md:text-7xl leading-none mb-8">Junior Developer</h1>
            <p className="font-normal text-gray-600 text-md md:text-xl mb-16">I have a passion for software. I enjoy creating tools that make life easier for people.</p>
            <EmailWriter />
          </div>
        </div>
      </section>

      <section className="py-10 md:py-16">
        <div className="container max-w-screen-xl mx-auto px-4">
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            <div className="bg-gray-50 px-8 py-10 rounded-md">
              <div className="w-20 py-6 flex justify-center bg-gray-100 rounded-md mb-4">
                <i data-feather="heart"></i>
              </div>
              <h4 className="font-medium text-gray-700 text-lg mb-4">High motivation</h4>
              <p className="font-normal text-gray-500 text-md">
                I have a deep passion for technology and its <br /> 
                transformative potential. It can make life more <br />
                enjoyable. I believe it defines the future. </p>
            </div>
            <div className="bg-gray-50 px-8 py-10 rounded-md">
              <div className="w-20 py-6 flex justify-center bg-gray-100 rounded-md mb-4">
                <i data-feather="book"></i>
              </div>
              <h4 className="font-medium text-gray-700 text-lg mb-4">Lifelong learning</h4>
              <p className="font-normal text-gray-500 text-md">
                Lifelong learning in IT is essential due to <br />
                the rapid pace of technological advancements <br />
                and the ever-evolving landscape of the <br />
                industry.  </p>
            </div>

            <div className="bg-gray-50 px-8 py-10 rounded-md">
              <div className="w-20 py-6 flex justify-center bg-gray-100 rounded-md mb-4">
                <i data-feather="coffee"></i>
              </div>

              <h4 className="font-medium text-gray-700 text-lg mb-4">Enjoyable side projects</h4>
              <p className="font-normal text-gray-500 text-md">
                I believe the best way to stay sharp in IT <br /> 
                is to always work on something from the heart. <br /> 
                It motivates, gives challenges and creates <br />
                useful skills in the process. </p>
            </div>
          </div>

        </div>

      </section>

      <section className="py-10 md:py-16">

        <div className="container max-w-screen-xl mx-auto px-4">

          <div className="flex flex-col lg:flex-row justify-between">
            <div className="mb-10 lg:mb-0">
              <h1 className="font-medium text-gray-700 text-3xl md:text-4xl mb-5">Portfolio</h1>

              <p className="font-normal text-gray-500 text-xs md:text-base">I have brought here my biggest and favorite works <br /> as a professional.</p>
            </div>

            <div className="space-y-24">
              <div className="flex space-x-6">
                <h1 className="font-normal text-gray-700 text-3xl md:text-4xl">01</h1>

                <span className="w-28 h-0.5 bg-gray-300 mt-5"></span>

                <div>
                  <a href="https://github.com/pacsinta/signatureTester" className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">
                    <h1 className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">Signature tester</h1>
                  </a>

                  <p className="font-normal text-gray-500 text-sm md:text-base">
                    This software can validate handwritten signitures. <br /> 
                    It uses a recurrent neural network to compare the signatures.  </p>
                </div>
              </div>

              <div className="flex space-x-6">
                <h1 className="font-normal text-gray-700 text-3xl md:text-4xl">02</h1>

                <span className="w-28 h-0.5 bg-gray-300 mt-5"></span>

                <div>
                  <h1 className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">Parking visualization</h1>

                  <p className="font-normal text-gray-500 text-sm md:text-base">
                    I was working on a project to develop parking software for automotives. <br /> 
                    We were working on a SW capable 360<sup>o</sup> visualization around the car. </p>
                </div>
              </div>

              <div className="flex space-x-6">
                <h1 className="font-normal text-gray-700 text-3xl md:text-4xl">03</h1>

                <span className="w-28 h-0.5 bg-gray-300 mt-5"></span>

                <div>
                  <a href="https://github.com/pacsinta/TenisMonsters">
                    <h1 className="font-normal text-gray-700 text-3xl md:text-4xl mb-5">Tenis monsters game</h1>
                  </a>

                  <p className="font-normal text-gray-500 text-sm md:text-base">
                    This is a multiplayer game where each player can control a monster. <br/>
                    The goal is to successfully hit the ball to the other player&apos;s field.
                    </p>
                </div>
              </div>
            </div>
          </div>

        </div>

      </section>

      <section className="py-10 md:py-16">
        <div className="container max-w-screen-xl mx-auto px-4">
          <h1 className="font-medium text-gray-700 text-3xl md:text-4xl mb-5">Education</h1>
          <p className="font-normal text-gray-500 text-xs md:text-base mb-20">Below is a summary of the places I studied</p>

          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            <div className="bg-gray-50 px-8 py-10 rounded-md">
              <h3 className="font-medium text-black text-lg mb-1">Szent István High School</h3>
              <h4 className="font-medium text-gray-700 text-lg mb-4">2016 – 2020</h4>
              <p className="font-normal text-gray-500 text-md mb-4">
                I learned the basics here. I had the <br />
                opportunity to learn robotics with the Lego <br />
                Mindstorms / Arduino platforms and programming in C#. </p>
              <div className="relative">
                <a href="https://szigbp.hu/" className="font-semibold text-gray-500 text-md relative z-10">See the place here</a>
                <span className="w-32 h-1 bg-blue-200 absolute bottom-1 left-0 z-0"></span>
              </div>
            </div>

            <div className="bg-gray-50 px-8 py-10 rounded-md">
              <h3 className="font-medium text-black text-lg mb-1">Budapest University of Technology and Economics</h3>
              <h4 className="font-medium text-gray-700 text-lg mb-4">2020 – 2024</h4>
              <p className="font-normal text-gray-500 text-md mb-4">
                This was the place where I started to <br /> 
                understand the main concepts behind <br />
                computers and programming. This is where <br />
                 I created my first serious projects. </p>
              <div className="relative">
                <a href="https://www.vik.bme.hu/en/welcome-to-bme-vik/" className="font-semibold text-gray-500 text-md relative z-10">See the place here</a>
                <span className="w-32 h-1 bg-blue-200 absolute bottom-1 left-0 z-0"></span>
              </div>
            </div>

            <div className="bg-gray-50 px-8 py-10 rounded-md">
              <h3 className="font-medium text-black text-lg mb-1">Budapest University of Technology and Economics</h3>
              <h4 className="font-medium text-gray-700 text-lg mb-4">2024 – (2026)</h4>
              <p className="font-normal text-gray-500 text-md mb-4">
                I&apos;m currently doing my Master&apos;s degree here. <br />
                It is the continuation of the Bachler&apos;s course.  <br />
                I hope I&apos;ll extend my knowledge with more useful <br />
                SW architecture and skills. </p>
              <div className="relative">
                <a href="https://www.vik.bme.hu/en/welcome-to-bme-vik/" className="font-semibold text-gray-500 text-md relative z-10">See the place here</a>
                <span className="w-32 h-1 bg-blue-200 absolute bottom-1 left-0 z-0"></span>
              </div>
            </div>
          </div>

        </div>

      </section>

      <section className="py-10 md:py-16">
        <div className="container max-w-screen-xl mx-auto px-4">
          <h1 className="font-medium text-gray-700 text-3xl md:text-4xl mb-5">Experience</h1>
          <p className="font-normal text-gray-500 text-xs md:text-base mb-20">Below is a summary of the places I worked at</p>

          <div className="flex flex-col lg:flex-row justify-between">
            <div className="space-y-8 md:space-y-16 mb-16 md:mb-0">
              <h6 className="font-medium text-gray-400 text-base uppercase">Company</h6>
              <p className="font-semibold text-gray-600 text-base">Robert Bosch <span className="font-normal text-gray-300">/ Budapest</span></p>
            </div>

            <div className="space-y-8 md:space-y-16 mb-16 md:mb-0">
              <h6 className="font-medium text-gray-400 text-base uppercase">Position</h6>
              <p className="font-normal text-gray-400 text-base">Junior embedded developer</p>
            </div>

            <div className="space-y-8 md:space-y-16">
              <h6 className="font-medium text-gray-400 text-base uppercase">Year</h6>
              <p className="font-normal text-gray-400 text-base">2023</p>
            </div>
          </div>

        </div>

      </section>

      <footer className="py-10 md:py-16 mb-20 md:mb-40 lg::mb-52">

        <div className="container max-w-screen-xl mx-auto px-4">

          <div className="text-center">
            <h1 className="font-medium text-gray-700 text-4xl md:text-5xl mb-5">About myself</h1>
            <p className="font-normal text-md md:text-lg mb-5"> 
              I&apos;m currently working on my Master&apos;s degree at the Budapest University of Technology and Economics. <br/>
              However, I started programming as a kid. Initially, I learned from my dad in Excel Visual Basic. <br/>
              Shortly after that, I was learning how to build robots on the Lego Mindstorms platform. <br/>
              From this point on, programming drew me in and I began learning more complex concepts. <br />
              I have a big passion for creating things that help people with the boring stuff to enjoy their lives more.</p>
            <p className="font-normal text-gray-400 text-md md:text-lg mb-20">
              Work as hard as you can and as good as you can, but don&apos;t forget to enjoy your life </p>

            <SocialLinks />
          </div>

        </div>

      </footer>
    </div>
  );
}
