import { Link } from "react-router";

export default function NotFound() {
  return (
    <div className="page">
      <div className="crumb">
        <span>varun kale / not found</span>
      </div>
      <h1>Page not found</h1>
      <p>The page you are looking for doesn't exist or has been moved.</p>
      <Link className="arrow" to="/">
        back to about
      </Link>
    </div>
  );
}