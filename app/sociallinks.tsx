"use client";

import feather from "feather-icons";
import { useEffect } from "react";

export default function SocialLinks() {
  useEffect(() => {
    feather.replace();
  }, []);

  return (
      <div className="flex items-center justify-center space-x-8">
          <a href="#" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="twitter" className="text-gray-500 hover:text-gray-800 transition ease-in-out duration-500"></i>
          </a>

          <a href="#" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="dribbble" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="#" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="facebook" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="#" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="codepen" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="#" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="at-sign" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>

          <a href="https://www.instagram.com/patrik_csikos/" className="w-16 h-16 flex items-center justify-center rounded-full hover:bg-gray-200 transition ease-in-out duration-500">
              <i data-feather="instagram" className="text-gray-500 hover:text-gray-700 transition ease-in-out duration-500"></i>
          </a>
      </div>
  );
}