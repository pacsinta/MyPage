import Education from "./components /Education";
import Experience from "./components /Experience";
import Portfolio from "./components /Portfolio";
import EmailWriter from "./emailwriter";
import SocialLinks from "./sociallinks";
import Image from 'next/image';

export default function Home() {
  return (
    <div>
      <section className="py-10 md:py-16">
        <div className="container max-w-screen-xl mx-auto px-4">
          <nav className="flex items-center justify-between mb-40">
            <a href="https://github.com/pacsinta/MyPage"><Image src="/icon2.jpg" alt="Logo" className="w-10 h-10" width={40} height={40} /></a>
            <a href="/patrik_csikos-cv-eng.pdf" download className="px-7 py-3 md:px-9 md:py-4 bg-blue-300 font-medium md:font-semibold text-gray-700 text-md rounded-md hover:bg-gray-500 hover:text-black transition ease-linear duration-200">Get my CV</a>
          </nav>

          <div className="text-center">
            <div className="flex justify-center mb-16">
              <Image src="/profile1.png" alt="Image" width={360} height={360} />
            </div>
            <h6 className="font-medium text-gray-600 dark:text-gray-200 text-lg md:text-2xl uppercase mb-8">Patrik Csikós</h6>
            <h1 className="font-normal text-gray-900 dark:text-gray-100 text-4xl md:text-7xl leading-none mb-8">Software Developer</h1>
            <p className="font-normal text-gray-600 dark:text-gray-300 text-md md:text-xl mb-16">I have a passion for software. I enjoy creating tools that make life easier for people.</p>
            <EmailWriter />
          </div>
        </div>
      </section>

      <section className="py-10 md:py-16">
        <div className="container max-w-screen-xl mx-auto px-4">
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            <div className="bg-gray-50 dark:bg-gray-800 px-8 py-10 rounded-md">
              <div className="w-20 py-6 flex justify-center bg-gray-100 dark:bg-gray-600 rounded-md mb-4">
                <i data-feather="heart"></i>
              </div>
              <h4 className="font-medium text-gray-700 dark:text-gray-200 text-lg mb-4">High motivation</h4>
              <p className="font-normal text-gray-500 dark:text-gray-400 text-md">
                I have a deep passion for technology and its <br /> 
                transformative potential. It can make life more <br />
                enjoyable. I believe it defines the future. </p>
            </div>
            <div className="bg-gray-50 dark:bg-gray-800 px-8 py-10 rounded-md">
              <div className="w-20 py-6 flex justify-center bg-gray-100 dark:bg-gray-600 rounded-md mb-4">
                <i data-feather="book"></i>
              </div>
              <h4 className="font-medium text-gray-700 dark:text-gray-200 text-lg mb-4">Lifelong learning</h4>
              <p className="font-normal text-gray-500 dark:text-gray-400 text-md">
                Lifelong learning in IT is essential due to <br />
                the rapid pace of technological advancements <br />
                and the ever-evolving landscape of the <br />
                industry.  </p>
            </div>

            <div className="bg-gray-50 dark:bg-gray-800 px-8 py-10 rounded-md">
              <div className="w-20 py-6 flex justify-center bg-gray-100 dark:bg-gray-600 rounded-md mb-4">
                <i data-feather="coffee"></i>
              </div>

              <h4 className="font-medium text-gray-700 dark:text-gray-200 text-lg mb-4">Enjoyable side projects</h4>
              <p className="font-normal text-gray-500 dark:text-gray-400 text-md">
                I believe the best way to stay sharp in IT <br /> 
                is to always work on something from the heart. <br /> 
                It motivates, gives challenges and creates <br />
                useful skills in the process. </p>
            </div>
          </div>

        </div>

      </section>

      
      <Portfolio />
      <Experience />
      <Education />

      <footer className="py-10 md:py-16 mb-20 md:mb-40 lg::mb-52">

        <div className="container max-w-screen-xl mx-auto px-4">

          <div className="text-center">
            <h1 className="font-medium text-gray-700 dark:text-gray-200 text-4xl md:text-5xl mb-5">About myself</h1>
            <p className="font-normal text-md md:text-lg mb-5 dark:text-gray-300"> 
              I&apos;m currently working on my Master&apos;s degree at the Budapest University of Technology and Economics. <br/>
              However, I started programming as a kid. Initially, I learned from my dad in Excel Visual Basic. <br/>
              Shortly after that, I learned how to build robots on the Lego Mindstorms platform. <br/>
              From this point on, programming drew me in and I began learning more complex concepts. <br />
              I have a big passion for creating things that help people with the boring stuff to enjoy their lives more.</p>
            <p className="font-normal text-gray-400 dark:text-gray-400 text-md md:text-lg mb-20">
              Work as hard as you can and as good as you can, but don&apos;t forget to enjoy your life </p>

            <SocialLinks />
          </div>

        </div>

      </footer>
    </div>
  );
}
