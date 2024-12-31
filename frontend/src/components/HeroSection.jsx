import React from 'react';

const HeroSection = () => {
    return (
        <div className="bg-gray-100 py-20">
            <div className="container mx-auto flex flex-col md:flex-row items-center">
                <div className="flex flex-col w-full md:w-1/2 justify-center items-start text-center md:text-left">
                    <h1 className="text-5xl font-bold leading-tight mb-4">Welcome to Pet Adoption</h1>
                    <p className="text-xl mb-8">Find your perfect pet companion today!</p>
                    <a href="#adopt" className="bg-blue-500 text-white py-2 px-4 rounded-full hover:bg-blue-700 transition duration-300">
                        Adopt Now
                    </a>
                </div>
                <div className="w-screen h98 bg-cover md:w-1/2  text-center">
                    <img src="https://images.unsplash.com/photo-1514984879728-be0aff75a6e8?q=80&w=1984&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Hero" className="w-full rounded-lg shadow-lg" />
                </div>
            </div>
        </div>
    );
};

export default HeroSection;