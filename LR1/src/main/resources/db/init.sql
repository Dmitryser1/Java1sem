-- Create Authors table
CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE,
    nationality VARCHAR(50)
);

-- Create Books table
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE,
    publication_year INTEGER,
    author_id INTEGER REFERENCES authors(id),
    available_copies INTEGER DEFAULT 0
);

-- Insert sample data
INSERT INTO authors (first_name, last_name, birth_date, nationality) VALUES
    ('Leo', 'Tolstoy', '1828-09-09', 'Russian'),
    ('Jane', 'Austen', '1775-12-16', 'British');

INSERT INTO books (title, isbn, publication_year, author_id, available_copies) VALUES
    ('War and Peace', '9780140447934', 1869, 1, 5),
    ('Pride and Prejudice', '9780141439518', 1813, 2, 3);
