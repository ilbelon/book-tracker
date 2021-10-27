INSERT INTO bt_author (name, surname) VALUES 
	('R.A.', 'Salvatore'),('E.D.', 'Greenwood'),('Margaret', 'Weis'),('Stephen', 'King'),('J. R. R.', 'Tolkien')
	ON DUPLICATE KEY UPDATE name=name;
INSERT INTO bt_setting (name) VALUES 
	('Forgotten Realms'),('Dragonlance'),('Terra di Mezzo')
	ON DUPLICATE KEY UPDATE id=id;

INSERT INTO bt_book (title,setting_id) VALUES
	('Il buio profondo',1),('L\'esilio',1),('Il mondo di sopra',1),('Raistlin l\'alba del male',2),('La compagnia dell\'anello',3)
	ON DUPLICATE KEY UPDATE  title=title;
	
INSERT INTO bt_book_author (author_id,book_id) VALUES
	(1,1),(1,2),(1,3),(3,4),(5,5)
	ON DUPLICATE KEY UPDATE  book_id=book_id;

INSERT INTO bt_serie (name) VALUES
	('La leggenda di Drizzt'),('Le cronache di Raistlin'),('Il Signore degli anelli')
	ON DUPLICATE KEY UPDATE  name=name;

--INSERT INTO bt_book_serie_number ( book_id,serie_id,number_of_this_book_in_serie) VALUES
--	(1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,3,1)
--	ON DUPLICATE KEY UPDATE  book_id=book_id;

INSERT INTO bt_user (email, name, username) VALUES 
	('robertorossi@mail.com','Roberto Rossi', 'rossi85'),('giorgialentini@mail.com', 'giorgia lentini' ,'giolenti'),
	('giofer@gmail.com','Giovanni Ferraro' , 'ferro89'),('mastrota@yahoo.com','Giogio Mastrota' , 'keeperofInox')
	ON DUPLICATE KEY UPDATE name=name;
