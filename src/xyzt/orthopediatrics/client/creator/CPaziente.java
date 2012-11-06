package xyzt.orthopediatrics.client.creator;

import java.util.LinkedList;

import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.db.Database;

public class CPaziente
{
	/**
	 * @uml.property  name="database"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Database database;
	
	/**
	 * Costruttore della classe
	 * @param database - Database
	 */
	public CPaziente(Database database) {
		this.database = database;
	}
	
	/**
	 * Autenticazione del paziente
	 * @return
	 *  Istanza del paziente che ha eseguito l'autenticazione;
	 *  NULL se il paziente non risulta precedentemente registrato
	 */
	public Paziente login(String nomeutente, String password) {
		return database.loginPatient(nomeutente, password);
	}
	
	/**
	 * Estrazione di un paziente dal database
	 * @return
	 *  Istanza del paziente corrispondente al nomeutente;
	 *  NULL se nomeutente non e' presente nel sistema
	 */
	public Paziente getPaziente(String nomeutente) {
		return database.getPatient(nomeutente);
	}
	
	/**
	 * Registrazione di un nuovo paziente (senza tutor)
	 * @return
	 *  TRUE se la registrazione e' avvenuta con successo,
	 *  FALSE altrimenti
	 */
	public boolean registerNewPatient(Paziente paziente) {
		return database.registerNewPatient(paziente);
	}
	
	/**
	 * Registrazione di un nuovo paziente con tutor
	 * @return
	 *  TRUE se la registrazione e' avvenuta con successo,
	 *  FALSE altrimenti
	 */
	public boolean registerNewPatientFromTutor(Paziente paziente, Tutore tutore) {
		CTutore tutorCreator = new CTutore(database);
		if (tutorCreator.bindTutorForPatient(paziente, tutore))
			return registerNewPatient(paziente);
		return false;
	}
	
	/**
	 * Estrazione messaggi indirizzati al paziente
	 * @return
	 *  Elenco dei messaggi di 'conferma prenotazione' indirizzati
	 *  al paziente; NULL se non ci sono messaggi inviati al paziente
	 */
	public LinkedList<Prenotazione> fetchReservation(Paziente paziente) { 
		return database.fetchReservetionsPatient(paziente);
	}
	
	/**
	 * Estrazione di un referto
	 * @param idPrenotazione - ID prenotazione
	 * @return
	 *  Il referto a cui la prenotazione fa riferimento,
	 *  null se la prenotazione non dispone ancora di un referto
	 */
	public Referto fetchReport(int idPrenotazione) {
		return database.getReport(idPrenotazione);
	}
	
	/**
	 * Cancellazione della prenotazione
	 * @param prenotazione - Prenotazione da cancellare
	 * @return
	 *  TRUE se la prenotazione e' avvenuta con successo,
	 *  FALSE altrimenti
	 */
	public boolean retireReservation(Prenotazione prenotazione) {
		return database.retireReservationPatient(prenotazione);
	}
	
	/**
	 * Richiesta di spostamento della prenotazione
	 * @param prenotazione - Prenotazione da spostare
	 * @return
	 *  TRUE se lo spostamento della prenotazione e' avvenuto con
	 *  successo, FALSE altrimenti;
	 */
	public boolean deferReservation(Prenotazione prenotazione) {
		return database.deferReservationPatient(prenotazione);
	}
	
	/**
	 * Richiesta di prenotazione; 
	 * viene inviato un messaggio all'amministratore
	 * @return
	 *  TRUE se la richiesta e' stata spedita; FALSE altrimenti
	 */
	public boolean reserveVisit(Messaggio messaggio) {
		return database.sendMessage(messaggio);
	}
}