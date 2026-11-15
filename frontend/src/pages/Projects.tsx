import { Link } from "react-router";
import type { Project } from "../api/types";
import { useApi } from "../hooks/useApi";

export default function Projects() {
  const { data: projects, error, loading } = useApi<Project[]>("/api/projects");

  return (
    <div className="page">
      <div className="crumb">
        <span>varun kale / projects</span>
        <span>{projects && `${projects.length} projects`}</span>
      </div>
      <h1>Projects</h1>

      {loading && <p className="small">Loading...</p>}
      {error && <p className="small">{error}</p>}

      {projects && (
        <div className="entries">
          {projects.map((project) => (
            <div className="entry" key={project.slug}>
              <b>{project.title}</b>
              <p>{project.summary}</p>
              <span className="small">{project.techStack.join(", ")}</span>
              <div className="links">
                <Link className="arrow" to={`/projects/${project.slug}`}>
                  details
                </Link>
                {project.githubUrl && (
                  <a className="arrow" href={project.githubUrl}>
                    github
                  </a>
                )}
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}