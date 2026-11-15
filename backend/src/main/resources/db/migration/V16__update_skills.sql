-- Removing the categories also removes their skills (ON DELETE CASCADE).
DELETE FROM skill_category;

INSERT INTO skill_category (name, display_order)
VALUES ('Languages', 1),
       ('Backend & Frameworks', 2),
       ('Frontend', 3),
       ('Databases', 4),
       ('Cloud & Tools', 5);

INSERT INTO skill (category_id, name, display_order)
SELECT c.id, s.name, s.display_order
FROM (VALUES ('Languages', 'Java', 1),
             ('Languages', 'Python', 2),
             ('Languages', 'SQL', 3),
             ('Languages', 'TypeScript', 4),
             ('Languages', 'HTML', 5),
             ('Languages', 'CSS', 6),
             ('Backend & Frameworks', 'Spring Boot', 1),
             ('Backend & Frameworks', 'Spring MVC', 2),
             ('Backend & Frameworks', 'Spring Data JPA', 3),
             ('Backend & Frameworks', 'REST APIs', 4),
             ('Backend & Frameworks', 'OAuth 2.0', 5),
             ('Backend & Frameworks', 'CrewAI', 6),
             ('Frontend', 'React', 1),
             ('Databases', 'PostgreSQL', 1),
             ('Databases', 'MongoDB', 2),
             ('Databases', 'Flyway', 3),
             ('Cloud & Tools', 'Docker', 1),
             ('Cloud & Tools', 'Git', 2),
             ('Cloud & Tools', 'Linux', 3),
             ('Cloud & Tools', 'Render', 4),
             ('Cloud & Tools', 'Vercel', 5)
     ) AS s(category, name, display_order)
         JOIN skill_category c ON c.name = s.category;