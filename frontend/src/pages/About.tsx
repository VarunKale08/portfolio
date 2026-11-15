import type { Profile } from "../api/types";
import Status from "../components/Status";
import { useApi } from "../hooks/useApi";
import portrait from "../assets/portrait.jpg";
// "https://github.com/VarunKale08" -> "github.com/VarunKale08"
function displayUrl(url: string): string {
  return url.replace(/^mailto:/, "").replace(/^https?:\/\/(www\.)?/, "").replace(/\/$/, "");
}

export default function About() {
  const { data: profile, error, loading } = useApi<Profile>("/api/profile");

  return (
    <div className="page">
      <div className="crumb">
        <span>varun kale / about</span>
        <span>{profile?.location}</span>
      </div>
      <img className="portrait about-photo" src={portrait} alt="Varun Kale" />
      <h1>About</h1>

    <Status loading={loading} error={error} />
      {profile && (
        <>
          <p>{profile.tagline}</p>
          <p>{profile.about}</p>

          <h2>Elsewhere</h2>
          <div className="pairs">
            {profile.links.map((link) => (
              <div key={link.platform} style={{ display: "contents" }}>
                <span>{link.platform}</span>
                <a className="arrow" href={link.url}>
                  {displayUrl(link.url)}
                </a>
              </div>
            ))}
          </div>
        </>
      )}
    </div>
  );
}