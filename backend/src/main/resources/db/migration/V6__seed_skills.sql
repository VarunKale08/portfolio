INSERT INTO skill_category (name, display_order)
VALUES ('Languages', 1),
       ('Backend & Frameworks', 2),
       ('Databases', 3),
       ('Cloud & Tools', 4),
       ('Concepts', 5);

INSERT INTO skill (category_id, name, display_order)
SELECT c.id, s.name, s.display_order
FROM (VALUES ('Languages', 'Java', 1),
             ('Languages', 'Python', 2),
             ('Languages', 'SQL', 3),
             ('Languages', 'HTML', 4),
             ('Languages', 'CSS', 5),
             ('Backend & Frameworks', 'Spring Boot', 1),
             ('Backend & Frameworks', 'Spring MVC', 2),
             ('Backend & Frameworks', 'REST APIs', 3),
             ('Backend & Frameworks', 'OAuth 2.0', 4),
             ('Backend & Frameworks', 'CrewAI', 5),
             ('Databases', 'PostgreSQL', 1),
             ('Databases', 'MongoDB', 2),
             ('Cloud & Tools', 'AWS (EC2, Polly, Boto3)', 1),
             ('Cloud & Tools', 'Git', 2),
             ('Cloud & Tools', 'Linux', 3),
             ('Concepts', 'Object-Oriented Programming', 1),
             ('Concepts', 'Data Structures', 2)
     ) AS s(category, name, display_order)
         JOIN skill_category c ON c.name = s.category;