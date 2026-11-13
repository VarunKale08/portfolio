INSERT INTO experience (role, company, location, start_date, end_date, display_order)
VALUES ('Global Information Technology Intern', 'Colgate-Palmolive', 'Mumbai, India',
        '2025-06-15', '2026-05-15', 1);

INSERT INTO experience_highlight (experience_id, title, detail, display_order)
SELECT e.id, h.title, h.detail, h.display_order
FROM (VALUES ('API Integration',
              'Architected the integration of the UiPath Test Manager API via OAuth 2.0 with a frontend application, successfully decoupling test executions and reducing platform license dependencies.', 1),
             ('Data Pipelines',
              'Engineered Google Apps Script utilities and a Gemini API pipeline to process complex SAP IFTT PDFs into automated reports, validating migration datasets across 30+ sheets.', 2),
             ('Code Enhancement',
              'Developed targeted code enhancements for failing SAP GUI workflows and executed test suites for 160+ scripts, stabilizing autonomous regression testing.', 3)
     ) AS h(title, detail, display_order)
         JOIN experience e ON e.company = 'Colgate-Palmolive';