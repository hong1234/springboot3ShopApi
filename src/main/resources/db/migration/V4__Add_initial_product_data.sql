INSERT INTO
    categories (id, title)
VALUES
    ('a1b9b31d-e73c-4112-af7c-b68530f38222', 'JavaScript'), 
    ('819e1fbf-8b7e-4f6d-811f-693534916a8b', 'Java'),
    ('9d927bff-8d5b-4929-8c26-a9be00173adc', 'Toys');

INSERT INTO
    products (id, title, supplier, image, unit_price, category_id)
VALUES
    ('510a0d7e-8e83-4193-b483-e27e09ddc34d', 'JavaScript for Gurus', 'Hong Le', '/images/Antifragile.jpg', 19.99, 'a1b9b31d-e73c-4112-af7c-b68530f38222'),
    ('03fef6ac-1896-4ce8-bd69-b798f85c6e0b', 'Fundamentals of Java', 'Tommy Le', '/images/Sapiens.jpeg', 39.99, '819e1fbf-8b7e-4f6d-811f-693534916a8b'),
    ('d3588630-ad8e-49df-bbd7-3167f7efb246', 'Spring in Action', 'Maxell Dam', '/images/Hackers.jpg', 49.99, '819e1fbf-8b7e-4f6d-811f-693534916a8b'),
    ('892422cd-0835-479e-84de-9265d3f2dc6a', 'JavaScript for Beginner', 'Marx Plank', '/images/ZeroToOne.jpg', 29.99, 'a1b9b31d-e73c-4112-af7c-b68530f38222');