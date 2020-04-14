insert into GENRE (ID, GENRE_NAME) values(1, 'Fantasy');
insert into GENRE (ID, GENRE_NAME) values(2, 'Drama');
insert into GENRE (ID, GENRE_NAME) values(3, 'Adventure');
insert into GENRE (ID, GENRE_NAME) values(4, 'Magical Realism');
insert into GENRE (ID, GENRE_NAME) values(5, 'Romance');
insert into GENRE (ID, GENRE_NAME) values(6, 'Science Fiction');

INSERT INTO author(ID, NAME,MOST_KNOWN_FOR, MORE_INFO) values(1,'Francis Scott Fitzgerald', 'The great Gatsby', 'https://en.wikipedia.org/wiki/F._Scott_Fitzgerald');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(2,'George Orwell', '1984', 'https://en.wikipedia.org/wiki/George_Orwell');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(3, 'Jerome David Salinger', 'The Catcher in the Rye', 'https://en.wikipedia.org/wiki/J._D._Salinger');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(4, 'Gabriel Garcia Marquez', 'One Hundred Years of Solitude', 'https://en.wikipedia.org/wiki/Gabriel_Garc%C3%ADa_M%C3%A1rquez');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(5,'John Steinbeck', 'Of Mice and Men', 'https://en.wikipedia.org/wiki/John_Steinbeck');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(6, 'Frank Herbert', 'Dune', 'https://en.wikipedia.org/wiki/Frank_Herbert');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(7, 'James Joyce', 'Ulysess', 'https://en.wikipedia.org/wiki/James_Joyce');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(8, 'Neil Gaiman', 'American Gods', 'https://en.wikipedia.org/wiki/Neil_Gaiman');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(9, 'Alexandre Dumas', 'The Three Musketeers', 'https://en.wikipedia.org/wiki/Alexandre_Dumas');
INSERT INTO author(ID, NAME, MOST_KNOWN_FOR, MORE_INFO) values(10, 'Michael Crichton', 'Jurassic Park', 'https://en.wikipedia.org/wiki/Michael_Crichton');

ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 1 minvalue 1;
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values (nextval('HIBERNATE_SEQUENCE'), 'The Great Gatsby', '1568497202',1, 5,218, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values (nextval('HIBERNATE_SEQUENCE'), '1984', '0140862544',2, 6,328, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'The Catcher in the Rye', '0316769177',3,2,233, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'One Hundred Years of Solitude', '0224618539',4,4, 401, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values (nextval('HIBERNATE_SEQUENCE'), 'East of Eden', '0142000655',5,2,873, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'Dune', '059309932X',6,1,500, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'Ulysess', '0394450051',7, 2,754, false);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'American Gods', '0061122912',8,3,543, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'The Count of Monte Cristo', '0140449264',9,2,1276, true);
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID, GENRE_ID, PAGES, READ) values ( nextval('HIBERNATE_SEQUENCE'), 'Jurassic Parc', '0345538986',10, 3,448, true);
