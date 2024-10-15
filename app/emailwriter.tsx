"use client";

import { sendEmail } from "./api/emails/send";
import { useState } from "react";
import toast, { Toaster } from "react-hot-toast";

export default function EmailWriter() {
    const [showModal, setShowModal] = useState(false);

    const [email, setEmail] = useState('');
    const [subject, setSubject] = useState('');
    const [emailBody, setBody] = useState('');

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();

        const button = document.querySelector('button[type="submit"]');
        if (button) {
            (button as HTMLButtonElement).disabled = true;
            (button as HTMLButtonElement).textContent = 'Sending...';
        }

        const res = await sendEmail({ email: email, subject: subject, emailBody: emailBody });

        if (button) {
            (button as HTMLButtonElement).disabled = false;
            (button as HTMLButtonElement).textContent = 'Send';
        }
        setShowModal(false);
        if(res) {
            setEmail('');
            setSubject('');
            setBody('');
            toast.success('Email sent successfully!');
        }
        else {
            toast.error('Something went wrong during sending!');
        }
    };

    const modal = showModal ? (
        <div className="fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full flex items-center justify-center z-20">
            <div className="p-8 border w-96 shadow-lg rounded-md bg-white">
                <div className="space-y-4">
                    <div>
                        <h3 className="text-2xl font-bold text-gray-900">Call me:</h3>
                        <h3 className="text-xl font-bold text-gray-700">+36 70 4180883</h3>
                    </div>
                </div>
                <div className="text-center">
                    <h3 className="text-2xl font-bold text-gray-900 mt-5">Or write me a message:</h3>
                    <div className="mt-2 px-7 py-3">
                        <form className="mt-4" onSubmit={handleSubmit}>
                            <div className="mb-4">
                                <label htmlFor="recipient" className="block text-left text-gray-700">
                                    Your email:
                                </label>
                                <input
                                    type="email"
                                    id="email"
                                    name="email"
                                    className="mt-1 p-2 w-full border rounded-md"
                                    placeholder="Recipient's email"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="subject" className="block text-left text-gray-700">
                                    Subject:
                                </label>
                                <input
                                    type="text"
                                    id="subject"
                                    name="subject"
                                    className="mt-1 p-2 w-full border rounded-md"
                                    placeholder="Email subject"
                                    value={subject}
                                    onChange={(e) => setSubject(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="body" className="block text-left text-gray-700">
                                    Body:
                                </label>
                                <textarea
                                    id="body"
                                    name="body"
                                    className="mt-1 p-2 w-full border rounded-md"
                                    rows={4}
                                    placeholder="Write your email here"
                                    value={emailBody}
                                    onChange={(e) => setBody(e.target.value)}
                                    required
                                ></textarea>
                            </div>
                            <div className="flex justify-center mt-4 w-full">
                                <button
                                    type="submit"
                                    className="w-24 px-4 py-2 bg-green-600 text-white text-base font-medium rounded-md shadow-sm hover:bg-green-800 focus:outline-none focus:ring-2 focus:ring-blue-300">
                                    Send
                                </button>
                            </div>
                        </form>
                    </div>
                    <div className="flex justify-center mt-4 w-full">
                        <button 
                            className="w-24 px-4 py-2 bg-gray-500 text-white text-base font-medium rounded-md shadow-sm hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-300"
                            onClick={() => setShowModal(false)}>
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div >
    ) : null;

    return (
        <div>
            <Toaster position="top-center" />
            <button 
                className="px-7 py-3 md:px-9 md:py-4 font-medium md:font-semibold bg-gray-700 text-gray-50 text-sm rounded-md hover:bg-gray-50 hover:text-gray-700 transition ease-linear duration-500"
                onClick={() => setShowModal(true)}>
                Notify me
            </button>
            {modal}
        </div>
    );
}