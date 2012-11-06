package xyzt.orthopediatrics.client.db;

import ejp.DatabaseManager;

public class DBMS
{
	private DatabaseManager databaseManager;
	
	/**
	 * Costruttore della classe
	 */
	public DBMS() {
		databaseManager = new DatabaseManager(DBConst.Database, DBConst.POOL, 
			DBConst.DRIVER, DBConst.POSTGRESQL, DBConst.Username, DBConst.Password);
	}
	
	/**
	 * Creazione dell'oggetto database
	 * @return
	 *  Un nuovo oggetto in grado di interfacciarsi con il  database;
	 *  se la connessione non avviene con successo viene restituito NULL
	 *  NB: e' consigliabile chiudere l'oggetto non appena si
	 *  termina con l'utilizzo
	 */
	public DatabaseManager getDBManager() {
		return databaseManager;
	}
		
	/**
	 * Chiusura del database
	 * @return
	 *  TRUE se il database e' stato chiuso correttamente,
	 *  FALSE altrimenti
	 */
	public boolean closeDBManager() {
		boolean status = true;
		try {
			databaseManager.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		
		return status;
	}
}