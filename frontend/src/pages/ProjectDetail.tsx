import { Link, useParams } from "react-router";
import type { Project } from "../api/types";
import { useApi } from "../hooks/useApi";
import Status from "../components/Status";

export default function ProjectDetail() {
  // 1. Read the slug from the URL
  const { slug } = useParams();
  
  // 2. Fetch the single project (note the backticks)
  const { data: project, error, loading } = useApi<Project>(`/api/projects/${slug}`);

  return (
    <div className="page">
      <div className="crumb">
        <span>varun kale / projects / {slug}</span>
      </div>

    <Status loading={loading} error={error} />

      {project && (
        <>
          <h1>{project.title}</h1>
          <p>{project.description}</p>
          
          <span className="small">{project.techStack.join(", ")}</span>
          
          <div className="links">
            {project.githubUrl && (
              <a className="arrow" href={project.githubUrl} target="_blank" rel="noreferrer">
                github
              </a>
            )}
            {project.liveUrl && (
              <a className="arrow" href={project.liveUrl} target="_blank" rel="noreferrer">
                live
              </a>
            )}
          </div>
          
          <div style={{ marginTop: "2rem" }}>
            <Link className="arrow" to="/projects">
              all projects
            </Link>
          </div>
        </>
      )}
    </div>
  );
}