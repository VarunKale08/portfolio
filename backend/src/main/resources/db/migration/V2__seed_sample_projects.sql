INSERT INTO project (slug, title, summary, description, featured, display_order)
VALUES ('portfolio-website', 'Portfolio Website',
        'Personal portfolio with a React frontend and a Spring Boot API.',
        'Sample description. Replace it with your own.', TRUE, 1),
       ('sample-project', 'Sample Project',
        'A placeholder project for testing the API.',
        NULL, FALSE, 2);

INSERT INTO project_tech (project_id, name, position)
VALUES ((SELECT id FROM project WHERE slug = 'portfolio-website'), 'Java', 0),
       ((SELECT id FROM project WHERE slug = 'portfolio-website'), 'Spring Boot', 1),
       ((SELECT id FROM project WHERE slug = 'portfolio-website'), 'PostgreSQL', 2),
       ((SELECT id FROM project WHERE slug = 'portfolio-website'), 'React', 3);