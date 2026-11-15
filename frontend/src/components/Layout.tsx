import { Link, NavLink, Outlet } from "react-router";
import { API_URL } from "../api/client";
import ThemeToggle from "./ThemeToggle";
import portrait from "../assets/portrait.jpg"; 
export default function Layout() {
  return (
    <div className="shell">
      <aside className="panel">
        <div className="panel-top">
          <Link className="name" to="/">
            Varun Kale
            <small>Software Engineer</small>
          </Link>
          <nav className="nav" aria-label="Pages">
            <NavLink to="/" end>About</NavLink>
            <NavLink to="/projects">Projects</NavLink>
            <NavLink to="/cv">CV</NavLink>
            <NavLink to="/contact">Contact</NavLink>
            <a className="resume arrow" href={`${API_URL}/api/resume`}>
              download resume.pdf
            </a>
            <ThemeToggle />
          </nav>
        </div>
        <img className="portrait" src={portrait} alt="Varun Kale" />
      </aside>

      <main>
        <Outlet />
        <footer>
          <button className="top" type="button" onClick={() => window.scrollTo(0, 0)}>
            top
          </button>
          <span>&copy; Varun Kale 2026 &middot; last update 15.11.2026</span>
        </footer>
      </main>
    </div>
  );
}