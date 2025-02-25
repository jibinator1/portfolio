import './Navbar.css';

function Navbar() {
    return (
        <nav className="navbar">
            <ul className="nav-links">
                <li><a href="#">Home</a></li>
                <li><a href="#">About Me</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Contact</a></li>
                <li className="resume"><a href="#">Resume</a></li>
            </ul>
        </nav>
    );
}

export default Navbar;