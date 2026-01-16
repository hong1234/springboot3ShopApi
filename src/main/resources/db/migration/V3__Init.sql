DROP TABLE categories IF EXISTS;
DROP TABLE products IF EXISTS;

CREATE TABLE categories (
    id uuid NOT NULL DEFAULT random_uuid(),
    title VARCHAR(100) NOT NULL,
    -- isbn VARCHAR(255) NOT NULL,
    -- author VARCHAR(100) NOT NULL,
    -- publication_year INT NOT NULL
    PRIMARY KEY(id)
);

CREATE TABLE products (
    id uuid NOT NULL DEFAULT random_uuid(),
    title VARCHAR(100) NOT NULL, 
    autor VARCHAR(100) NOT NULL,
    image VARCHAR(200) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    category_id uuid NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(id)
    -- book_id INT NOT NULL,
    -- is_available BOOLEAN NOT NULL,
    -- CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book(book_id)
);