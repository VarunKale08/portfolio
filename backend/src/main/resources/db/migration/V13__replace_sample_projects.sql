-- project_tech rows go automatically: the foreign key has ON DELETE CASCADE.
DELETE FROM project;

INSERT INTO project (slug, title, summary, description, github_url, live_url, featured, display_order)
VALUES ('agri-agents',
        'Multi Agent System for Climate Resilient Agriculture',
        'Eight AI agents that work together to produce fertilizer recommendations in English and Tamil.',
        'A multi-agent system built with CrewAI in which eight specialised agents collaborate to produce climate-resilient fertilizer recommendations for farmers. It runs on the Gemini and Dhenu LLM models through APIs and Ollama, and responds in English and Tamil. The work was published by IEEE in January 2026.',
        'https://github.com/VarunKale08/agri-agents',
        NULL, TRUE, 1),
       ('portfolio',
        'Portfolio Website',
        'This site: a Spring Boot REST API with a React frontend.',
        'A personal portfolio where all content is served by a Spring Boot REST API backed by PostgreSQL, with Flyway migrations and a React frontend.',
        NULL,
        NULL, TRUE, 2);

INSERT INTO project_tech (project_id, name, position)
SELECT p.id, t.name, t.position
FROM (VALUES ('agri-agents', 'Python', 0),
             ('agri-agents', 'CrewAI', 1),
             ('agri-agents', 'Gemini API', 2),
             ('agri-agents', 'Ollama', 3),
             ('portfolio', 'Java', 0),
             ('portfolio', 'Spring Boot', 1),
             ('portfolio', 'PostgreSQL', 2),
             ('portfolio', 'React', 3)
     ) AS t(slug, name, position)
         JOIN project p ON p.slug = t.slug;