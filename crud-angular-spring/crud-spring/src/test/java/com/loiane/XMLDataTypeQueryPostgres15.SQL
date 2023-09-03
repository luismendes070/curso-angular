CREATE TABLE courses (
                         id SERIAL PRIMARY KEY,
                         name TEXT NOT NULL,
                         description TEXT NOT NULL,
                         xml_data XML NOT NULL
);
INSERT INTO courses (name, description, xml_data)
VALUES ('Intro to XML', 'Learn the basics of XML', '<course><level>Beginner</level><duration>8 hours</duration></course>');

CREATE TABLE XMLCourses (
                            id serial PRIMARY KEY,
                            name varchar(100) NOT NULL,
                            category varchar(10) NOT NULL,
                            status varchar(10) NOT NULL DEFAULT 'Ativo'
);


INSERT INTO XMLCourses (name, category, status)
VALUES ('Java Fundamentals', 'Back-end', 'Ativo');




