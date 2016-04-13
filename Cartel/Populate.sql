
USE cartel;

INSERT INTO cartel(nom) VALUES
	('BESSETTE ENTERPRISES'),
	('NGUYEN AND CO.'), 
	('CHAP DAM INC.');

INSERT INTO historiqueprix(dateFin, valeur) VALUES 
	('2015-12-01', 40.58),
	('2016-01-01', 36.81),
	('2016-02-01', 31.62),
	('2016-03-01', 34.39),
	('2016-04-01', 35.36);
	
INSERT INTO zone(zip, ville, province, pays) VALUES
	('H0H0H0', 'Kuluk Dalaga', 'Swartchzannagerland', 'North Pole'),
	('H1G4D2', 'Montréal', 'Québec', 'Canada'),
	('11365', 'New York', 'Long-Island', 'USA'),
	('7500', 'Paris', 'Paris', 'France'),
	('11011', 'Berlin', 'Berlin', 'Allemagne'),
	('H3C3J7', 'Montréal', 'Québec', 'Canada'),
	('A1B2C3', 'Kuujjuaq', 'Québec', 'Canada');
	
INSERT INTO compagnie(nom, nocivique, zip, rue, capacitelimite, maisonmere) VALUES
	('Kulak Petrol', 5492,'H0H0H0', 'Qualecwaga', 100, null),
	('Potvin Gazoline', 35032, 'H1G4D2', 'St-Catherine', 25, 'Kulak Petrol'),
	('Oscar DiCaprio Petrol Products', 7005, '11365', 'Wall Street', 75, 'Kulak Petrol'),
	('Pétrol LeBlond', 118, '7500', 'Place de la République', 250, null),
	('Wir lieben Geld Unternehmen', 23, '11011', 'Kapperweg', 125,  'Pétrol LeBlond'),
	('Pétrol DIRO', 6128, 'H3C3J7', 'Boul. Édouard-Monpetit', 75, 'Wir lieben Geld Unternehmen'),
	('LaBombe Gas', 3430, 'A1B2C3', 'TAC Road', 25, null);

INSERT INTO gisement(nom, pays, description, latitude, longitude) VALUES
	('Gisement Olympique', 'Canada', 'Gisement de pétrole trouvé dans le sous-sols du stade olympique de Montréal', 45.558, -73.552),
	('Gisement Molossia', 'USA', 'Gisement situé dans la micronation de Molossia sous le contrôle de Kevin Baugh', 39.318998724, -119.536997852),
	('Gisement Google', 'USA', 'Gisement secret trouvé sous le QG de Google', 37.3861, -122.0839),
	('Gisement Louvre', 'France', 'Gisement situé sous la pyramide du louvre à Paris', 48.8606, 2.3376),
	('Gisement Nintendo', 'Japon', 'Gisement situé sous le QG de Nintendo', 35.0116, 135.7680);
	
INSERT INTO production(idgisement, annee, capaciteestimee, capacitereelle) VALUES
	(1, '2014', 56, 35),
	(2, '2014', 54, 48),
	(3, '2014', 30, 20),
	(4, '2014', 13, 45),
	(5, '2014', 24, 35),
	
	(1, '2015', 25, 30),
	(2, '2015', 50, 48),
	(3, '2015', 30, 12),
	(4, '2015', 40, 70),
	(5, '2015', 35, 35),
	
	(1, '2016', 32, null),
	(2, '2016', 64, null),
	(3, '2016', 13, null),
	(4, '2016', 75, null),
	(5, '2016', 45, null);

INSERT INTO membrecartel(nomcartel, nomcompagnie) VALUES
	('BESSETTE ENTERPRISES', 'Kulak Petrol'),
	('BESSETTE ENTERPRISES', 'Potvin Gazoline'),
	('BESSETTE ENTERPRISES', 'Oscar DiCaprio Petrol Products'),
	('NGUYEN AND CO.', 'Pétrol LeBlond'),
	('NGUYEN AND CO.', 'Wir lieben Geld Unternehmen'),
	('NGUYEN AND CO.', 'Pétrol DIRO'),
	('BESSETTE ENTERPRISES', 'LaBombe Gas'),
	('NGUYEN AND CO.', 'LaBombe Gas'),
	('CHAP DAM INC.', 'LaBombe Gas');
	
INSERT INTO exploitationgisement(idgisement, nomcompagnie, datefin, productionjournaliere) VALUES
	(1, 'Kulak Petrol', '2016-04-01', 5),
	(2, 'Potvin Gazoline', '2016-04-01', 4),
	(3, 'Oscar DiCaprio Petrol Products', '2016-04-01', 6),
	(4, 'Pétrol LeBlond', '2016-04-01', 8),
	(5, 'Wir lieben Geld Unternehmen', '2016-04-01', 5),
	(2, 'Pétrol DIRO', '2016-04-01', 3),
	(4, 'LaBombe Gas', '2016-04-01', 7);
	
	
	
	
	
	
	
	
	
	
	
	
	