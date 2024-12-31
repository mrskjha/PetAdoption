import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav className="bg-blue-500 p-4">
            <div className="container mx-auto flex justify-between items-center">
                <div className="text-white text-lg font-bold">
                    PetAdoption
                </div>
                <ul className="flex space-x-4">
                    <li>
                        <Link to="/" className="text-white hover:text-gray-300">Home</Link>
                    </li>
                    <li>
                        <Link to="/about" className="text-white hover:text-gray-300">About</Link>
                    </li>
                    <li>
                        <Link to="/contact" className="text-white hover:text-gray-300">Contact</Link>
                    </li>
                    <li>
                        <Link to="/Login" className="text-white hover:text-gray-300">Login</Link>
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default Navbar;