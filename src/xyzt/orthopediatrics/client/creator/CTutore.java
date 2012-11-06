package xyzt.orthopediatrics.client.creator;

import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.db.Database;

public class CTutore
{
	/**
	 * @uml.property  name="database"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Database database;
	
	/**
	 * Costruttore della classe
	 */
	public CTutore(Database database) {
		this.database = database;
	}	
	
	/**
	 * Login tutore
	 * @return
	 *  NULL se il tutore non e' presente all'interno del sistema,
	 *  altrimenti viene ritornato un nuovo oggetto che fa riferimento
	 *  al tutore
	 */
	public Tutore login(String nomeutente, String password) {
		return database.loginTutor(nomeutente, password);
	}
	
	/**
	 * Estrazione di un tutor dal database
	 * @return
	 *  Istanza del tutor corrispondente al nomeutente;
	 *  NULL se nomeutente non e' presente nel sistema
	 */
	public Tutore getTutor(String nomeutente) {
		return database.getTutor(nomeutente);
	}	
	
	/**
	 * TODO
	 */
	public void tutorCredentials() {
		// TODO
	}
	
	/**
	 * Registrazione di un tutore
	 * @return
	 *  TRUE se la registrazione e' avvenuta con successo;
	 *  FALSE altrimenti
	 */
	public boolean registerNewTutor(Tutore tutore) {
		return database.registerNewTutor(tutore);
	}
	
	/**
	 * Associazione di un tutore ad un paziente
	 * @return
	 *  TRUE se il binding e' avvenuto, FALSE alrimenti
	 */
	public boolean bindTutorForPatient(Paziente paziente, Tutore tutore) {
		if (paziente.getTutore() == null) {
			paziente.setTutore(tutore.getNomeutente());
			return true;
		}
		return false;
	}
	
}
