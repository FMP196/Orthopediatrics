package xyzt.orthopediatrics.client.db;

public class DBConst
{	
	public static String Database = "fmp";
	public static String Username = "fmp";
	public static String Password = "minepeza";

	public static final int POOL = 10;
	public static final String HOST  = "localhost";
	public static final String DRIVER = "org.postgresql.Driver";
	public static final String POSTGRESQL = "jdbc:postgresql://"+HOST+"/"+Database;
	
	public static String SQL_CREATE_ADMIN_TABLE = 
			"CREATE TABLE amministratore (" +
			"nomeutente text PRIMARY KEY," +
			"password text NOT NULL," +
			"reparto text NOT NULL);";
	
	public static String SQL_CREATE_PATIENT_TABLE = 
			"CREATE TABLE paziente (" +
			"nomeutente character(16) PRIMARY KEY," +
			"password text NOT NULL," +
			"nome text NOT NULL," +
			"cognome text NOT NULL," +
			"indirizzo text NOT NULL," +
			"telefono text NOT NULL," +
			"email text NOT NULL," +
			"nascita date NOT NULL," +
			"tutore character(16));";
	
	public static String SQL_CREATE_TUTOR_TABLE = 
			"CREATE TABLE  tutore (" +
			"nomeutente character(16) PRIMARY KEY," +
			"password text NOT NULL," +
			"nome text NOT NULL," +
			"cognome text NOT NULL," +
			"indirizzo text NOT NULL," +
			"telefono text NOT NULL," +
			"email text NOT NULL," +
			"nascita date NOT NULL);";
	
	public static String SQL_CREATE_MSG_TABLE = 
			"CREATE TABLE messaggio (" +
			"data date NOT NULL," +
			"orario text NOT NULL," +
			"mittente text NOT NULL," +
			"destinatario text NOT NULL," +
			"content text NOT NULL," +
			"tipo integer NOT NULL," +
			"prenotazione integer);";
	
	public static String SQL_CREATE_REPORT_TABLE = 
			"CREATE TABLE  referto (" +
			"id integer PRIMARY KEY," +
			"prenotazione integer NOT NULL," +
			"contenuto text NOT NULL," +
			"medico text NOT NULL," +
			"paziente text NOT NULL);";
	
	public static String SQL_CREATE_RESERVATION_TABLE = 
			"CREATE TABLE  prenotazione (" +
			"id integer PRIMARY KEY," +
			"paziente character(16) NOT NULL," +
			"priorita integer NOT NULL," +
			"ora integer NOT NULL," +
			"data date NOT NULL," +
			"sala integer NOT NULL," +
			"reparto integer NOT NULL);";
	
	public static String SQL_INSERT_ADMIN_ORTOPEDIA = 
			"INSERT INTO AMMINISTRATORE VALUES('admino', 'admino', 0);";
	
	public static String SQL_INSERT_ADMIN_PEDIATRIA =
			"INSERT INTO AMMINISTRATORE VALUES('adminp', 'adminp', 1);";
}
