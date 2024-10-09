"use client";

import feather from "feather-icons";
import { useEffect } from "react";

export default function SocialLinks() {
  useEffect(() => {
    feather.replace();
  }, []);

  return (
      <div className="flex items-center justify-center space-x-8">
          <a href="https://github.com/pacsinta/" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="github" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="https://www.linkedin.com/in/patrik-csik%C3%B3s-8166b02a1/" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="linkedin" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="https://www.facebook.com/patrik.csikos.92/" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="facebook" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="https://www.instagram.com/patrik_csikos/" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="instagram" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>
      </div>
  );
}