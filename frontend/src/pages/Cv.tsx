
import type { Education, Experience, Publication, SkillCategory } from "../api/types";
import Status from "../components/Status";
import { useApi } from "../hooks/useApi";
import { monthYear, yearOf } from "../utils/dates";

function ExperienceSection() {
  const { data, error, loading } = useApi<Experience[]>("/api/experience");
  return (
    <>
      <h2>Experience</h2>
      <Status loading={loading} error={error} />
      {data && (
        <div className="entries">
          {data.map((job) => (
            <div className="entries" key={job.company + job.startDate}>
              <div className="entry">
                <b>
                  <span className="date">
                    {monthYear(job.startDate)} &ndash; {job.endDate ? monthYear(job.endDate) : "present"}
                  </span>
                  {job.role}
                </b>
                <span>
                  {job.company}, {job.location}
                </span>
              </div>
              {job.highlights.map((highlight) => (
                <div className="entry" key={highlight.title}>
                  <b>{highlight.title}</b>
                  <p>{highlight.detail}</p>
                </div>
              ))}
            </div>
          ))}
        </div>
      )}
    </>
  );
}

function EducationSection() {
  const { data, error, loading } = useApi<Education[]>("/api/education");
  return (
    <>
      <h2>Education</h2>
      <Status loading={loading} error={error} />
      {data && (
        <div className="entries">
          {data.map((item) => (
            <div className="entry" key={item.degree}>
              <b>
                <span className="date">{yearOf(item.endDate)}</span>
                {item.degree}
              </b>
              <span>
                {item.institution}, {item.location}
              </span>
              <span className="small">
                {item.grade}
                {item.honors && ` · ${item.honors}`}
              </span>
            </div>
          ))}
        </div>
      )}
    </>
  );
}

function PublicationsSection() {
  const { data, error, loading } = useApi<Publication[]>("/api/publications");
  return (
    <>
      <h2>Publications</h2>
      <Status loading={loading} error={error} />
      {data && (
        <div className="entries">
          {data.map((item) => (
            <div className="entry" key={item.title}>
              <b>
                <span className="date">{monthYear(item.publishedDate)}</span>
                {item.title}
              </b>
              <span>{item.publisher}</span>
              {item.url && (
                <div className="links">
                  <a className="arrow" href={item.url}>
                    read on IEEE Xplore
                  </a>
                </div>
              )}
            </div>
          ))}
        </div>
      )}
    </>
  );
}

function SkillsSection() {
  const { data, error, loading } = useApi<SkillCategory[]>("/api/skills");
  return (
    <>
      <h2>Skills</h2>
      <Status loading={loading} error={error} />
      {data && (
        <div className="pairs">
          {data.map((group) => (
            <div key={group.category} style={{ display: "contents" }}>
              <span>{group.category}</span>
              <span>{group.skills.join(", ")}</span>
            </div>
          ))}
        </div>
      )}
    </>
  );
}

export default function Cv() {
  return (
    <div className="page">
      <h1>CV</h1>
      <ExperienceSection />
      <EducationSection />
      <PublicationsSection />
      <SkillsSection />
    </div>
  );
}