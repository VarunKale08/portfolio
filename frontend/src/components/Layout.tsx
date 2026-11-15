import { Link, NavLink, Outlet } from "react-router";

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
          </nav>
        </div>
        <div className="portrait">your photo</div>
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