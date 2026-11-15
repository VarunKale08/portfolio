import type { Profile } from "../api/types";
import { useApi } from "../hooks/useApi";

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
      <h1>About</h1>

      {loading && <p className="small">Loading...</p>}
      {error && <p className="small">{error}</p>}

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