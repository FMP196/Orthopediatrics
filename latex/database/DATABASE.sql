CREATE TABLE amministratore (
    nomeutente text PRIMARY KEY,
    password text NOT NULL
);

CREATE TABLE referto (
    id integer PRIMARY KEY,
    contenuto text NOT NULL
);

CREATE TABLE sala (
    numero integer PRIMARY KEY,
    amministratore text NOT NULL,
    unique (numero, amministratore),
    foreign key (amministratore) references amministratore(nomeutente)
);

CREATE TABLE tutore (
    nomeutente character(16) PRIMARY KEY,
    nome text NOT NULL,
    cognome text NOT NULL,
    indirizzo text NOT NULL,
    telefono text NOT NULL,
    email text NOT NULL,
    nascita date NOT NULL,
    password text NOT NULL,
    unique (nome,cognome,indirizzo,telefono,email,nascita,password)
);

CREATE TABLE paziente (
    nomeutente character(16) PRIMARY KEY,
    nome text NOT NULL,
    cognome text NOT NULL,
    indirizzo text NOT NULL,
    telefono text NOT NULL,
    email text NOT NULL,
    nascita date NOT NULL,
    password text NOT NULL,
    tutore character(16) NOT NULL,
    unique (nome,cognome,indirizzo,telefono,email,nascita,password,tutore),
    foreign key (tutore) references tutore(nomeutente)
);

CREATE TABLE mamministratore (
	destinatario character(16) NOT NULL,
	mittente text NOT NULL,
	type number(1) NOT NULL,
	prenot integer,
	content text,
	foreign key (prenot) references prenotazione(id),
	foreign key (mittente) references amministratore(
	nomeutente),
	foreign key (destinatario) references paziente(nomeutente)
);


CREATE TABLE mpaziente (
    	mittente character(16) NOT NULL,
	destinatario text NOT NULL,
	type number(1) NOT NULL,
	prenot integer,
	content text,
	foreign key (prenot) references prenotazione(id),
	foreign key (destinatario) references amministratore(
	nomeutente),
	foreign key (mittente) references paziente(nomeutente)
);


CREATE TABLE prenotazione (
    id integer PRIMARY KEY,
    priorita integer NOT NULL,
    medico text NOT NULL,
    ora integer NOT NULL,
    data date NOT NULL,
    referto integer NOT NULL,
    sala integer NOT NULL,
    paziente text NOT NULL,
    foreign key (paziente) references paziente(nomeutente),
    foreign key (referto) references referto(id),
    foreign key (sala) references sala(numero),
    unique (priorita, medico, ora, data, referto, sala, paziente)
);

