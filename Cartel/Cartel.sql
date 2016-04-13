CREATE DATABASE cartel;

CREATE USER 'ift2935APP'@'localhost' IDENTIFIED BY '';

USE cartel;

SET NAMES utf8;

CREATE TABLE historiqueprix (
	dateFin	DATE NOT NULL PRIMARY KEY,
	valeur	FLOAT NOT NULL
);

CREATE TABLE cartel (
	nom	varchar(64) NOT NULL PRIMARY KEY
);

CREATE TABLE gisement (
	id			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nom			varchar(128) NOT NULL,
	pays		varchar(16) NOT NULL,
	description	varchar(200) NOT NULL,
	latitude	Decimal(9,6) NOT NULL,
	longitude	Decimal(9,6) NOT NULL
);

CREATE TABLE zone (
	zip			varchar(10) NOT NULL PRIMARY KEY,
	ville		varchar(16) NOT NULL,
	province	varchar(32) NOT NULL,
	pays		varchar(16) NOT NULL
);

CREATE TABLE compagnie (
	nom				varchar(128) NOT NULL PRIMARY KEY,
	noCivique		INT NOT NULL,
	rue				varchar(128) NOT NULL,
	zip				varchar(10) NOT NULL,
	capaciteLimite	INT NOT NULL,
	maisonMere		varchar(128) DEFAULT null,
	CONSTRAINT fk_compagnie
	    	FOREIGN KEY (zip) REFERENCES zone(zip) ON DELETE CASCADE ON UPDATE CASCADE,
    		FOREIGN KEY (maisonMere) REFERENCES compagnie(nom) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE membrecartel (
	nomCartel		varchar(64) NOT NULL,
	nomCompagnie	varchar(128) NOT NULL,
	PRIMARY KEY (nomCartel, nomCompagnie),
	CONSTRAINT fk_membrecartel
		FOREIGN KEY (nomCartel) REFERENCES cartel(nom) ON DELETE CASCADE ON UPDATE CASCADE,
    	FOREIGN KEY (nomCompagnie) REFERENCES compagnie(nom) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE exploitationgisement (
	idGisement				INT NOT NULL,
	nomCompagnie			varchar(128) NOT NULL,
	dateFin					DATE NOT NULL,
	productionJournaliere	INT NOT NULL,
	PRIMARY KEY (idGisement, nomCompagnie, dateFin),
	CONSTRAINT fk_exploitationgisement
		FOREIGN KEY (idGisement) REFERENCES gisement(id) ON DELETE CASCADE ON UPDATE CASCADE,
		FOREIGN KEY (nomCompagnie) REFERENCES compagnie(nom) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE production (
	idGisement		INT NOT NULL,
	annee			varchar(4) NOT NULL,
	capaciteEstimee	INT NOT NULL,
	capaciteReelle	INT DEFAULT -1,
	PRIMARY KEY (idGisement, annee),
	CONSTRAINT fk_production
	FOREIGN KEY (idGisement) REFERENCES gisement(id) ON DELETE CASCADE ON UPDATE CASCADE
);

GRANT ALL PRIVILEGES ON cartel.* TO 'ift2935APP'@'localhost';