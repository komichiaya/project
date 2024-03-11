import { NavLink } from "react-router-dom"

export default function Navbar() {
    return (
        <nav className="nav">
            <img src="./src/assets/images/CCEAC.png" className="cceac" />

            <ul>
                <NavLink to="/" className="link">Home</NavLink>
                <NavLink to="/search" className="link">Search</NavLink>
                <NavLink to="/submit" className="link">Submit</NavLink>
                <NavLink to="/about" className="link">About</NavLink>
                <NavLink to="/admin" className="link">Admin</NavLink>
            </ul>
        </nav>
    )
}