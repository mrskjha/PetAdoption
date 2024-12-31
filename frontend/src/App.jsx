import { Route, Routes } from "react-router-dom";
import HeroSection from "./components/HeroSection";
import Login from "./components/Login";
import Navbar from "./components/Navbar";

// import './App.css'
function App() {
  return (
    <>

      <Routes>
        <Route path="/" element={<><Navbar /><HeroSection /></>} />
        

        <Route path="/Login" element={<Login />} />
      </Routes>
    </>
  );
}

export default App;
