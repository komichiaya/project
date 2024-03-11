import { Navigate, Route, Routes } from "react-router-dom"
import About from "./components/about/About"
import Admin from "./components/admin/Admin"
import Error from "./components/error/Error"
import Home from "./components/home/Home"
import Navbar from "./components/Navbar"
import Search from "./components/search/Search"
import Submit from "./components/submit/Submit"

export default function App() {
    return (
        <div className="app">
            <Navbar />

            <div className="container">
                <Routes>
                    <Route path="/about" element={<About />} />
                    <Route path="/admin" element={<Admin />} />
                    <Route path="*" element={<><Navigate to="/error" /><Error /></>} />
                    <Route path="/" element={<Home />} />
                    <Route path="/search" element={<Search />} />
                    <Route path="/submit" element={<Submit />} />
                </Routes>
            </div>

            <div className="widgets">
                <br />

                <div className="widget">
                    <h3>Contact Us</h3>

                    <div>
                        &#x2709;

                        <a href="mailto:info@cceac.ca">info@cceac.ca</a>
                    </div>
                </div>

                <div className="widget">
                    <h3>Follow Us</h3>

                    <a href="https://www.linkedin.com/groups/12366098/" className="linkedin">
                        <img src="./src/assets/images/LinkedIn.png" className="linkedin" />
                    </a>
                </div>
            </div>

            <div className="footer">
                <p>2024 © All Rights Reserved By Canadian Centre of Excellence for Anti-Corruption</p>
            </div>
        </div>
    )
}