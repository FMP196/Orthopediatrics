-- cancella tutte le tabelle
drop table if exists amministratore, referto, tutore, paziente, messaggio, 
	prenotazione cascade;

CREATE TABLE amministratore (
	nomeutente text PRIMARY KEY,
	password text NOT NULL,
	reparto text NOT NULL,
	unique (nomeutente, password)
);

CREATE TABLE referto (
	id integer PRIMARY KEY,
	prenotazione integer NOT NULL,
	contenuto text NOT NULL,
	medico text NOT NULL,
	paziente text NOT NULL,
	unique (id, prenotazione, contenuto, medico, paziente)
);

CREATE TABLE tutore (
    nomeutente character(16) PRIMARY KEY,
    password text NOT NULL,
    nome text NOT NULL,
    cognome text NOT NULL,
    indirizzo text NOT NULL,
    telefono text NOT NULL,
    email text NOT NULL,
    nascita date NOT NULL,
    unique (nomeutente, password, nome, cognome, indirizzo, 
    	telefono, email, nascita)
);

CREATE TABLE paziente (
    nomeutente character(16) PRIMARY KEY,
    password text NOT NULL,
    nome text NOT NULL,
    cognome text NOT NULL,
    indirizzo text NOT NULL,
    telefono text NOT NULL,
    email text NOT NULL,
    nascita date NOT NULL,
    tutore character(16),
    unique (nomeutente, password, nome, cognome, indirizzo, 
    	telefono, email, nascita, tutore)
);

CREATE TABLE messaggio (
	data date NOT NULL,
	orario text NOT NULL,
	mittente text NOT NULL,
	destinatario text NOT NULL,
	content text NOT NULL,
	tipo integer NOT NULL,
	prenotazione integer,
	unique (data, orario, mittente, destinatario, content,
		tipo, prenotazione)
);

CREATE TABLE prenotazione (
    id integer PRIMARY KEY,
    paziente character(16) NOT NULL,
    priorita integer NOT NULL,
    ora integer NOT NULL,
    data date NOT NULL,
    sala integer NOT NULL,
    reparto integer NOT NULL,
    unique (id, paziente, priorita, ora, data, sala, reparto)
);

-- inserimento di due amministratori predefiniti
insert into amministratore values('admino', 'admino', 0);
insert into amministratore values('adminp', 'adminp', 1);
