INSERT INTO book(title, category, pages) values ('The Fellowship of the Ring', 'fantasy', 398);
INSERT INTO book(title, category, pages) values ('The Two Towers', 'fantasy', 302);
INSERT INTO book(title, category, pages) values ('The Return of the King', 'fantasy', 491);
INSERT INTO book(title, category, pages) values ('A Short History of Nearly Everything', 'nonfiction', 672);
INSERT INTO book(title, category, pages) values ('Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future', 'biography', 416);

INSERT INTO author(first_name, last_name) values ('John', 'Tolkien');
INSERT INTO author(first_name, last_name) values ('Bill', 'Bryson');
INSERT INTO author(first_name, last_name) values ('Ashlee', 'Vance');
INSERT INTO author(first_name, last_name) values ('Jacek', 'Piekara');
INSERT INTO author(first_name, last_name) values ('Stanislaw', 'Lem');

INSERT INTO Author_Book(author_id, book_id) values (1,1);
INSERT INTO Author_Book(author_id, book_id) values (1,2);
INSERT INTO Author_Book(author_id, book_id) values (1,3);
INSERT INTO Author_Book(author_id, book_id) values (2,4);
INSERT INTO Author_Book(author_id, book_id) values (3,5);
