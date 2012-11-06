package xyzt.orthopediatrics.client.creator;

import java.sql.Date;
import java.util.LinkedList;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.db.Database;

public class CAmministratore
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
	public CAmministratore(Database database) {
		this.database = database;
	}
	
	/**
	 * Autenticazione dell'amministratore
	 * @return
	 *  Istanza dell'amministratore che ha eseguito l'autenticazione;
	 *  NULL se l'amministratore non esiste
	 */
	public Amministratore login(int reparto, String nomeutente, String password) {
		return database.loginAdmin(reparto, nomeutente, password);
	}
	
	/**
	 * Cambia le credenziali dell'amministratore
	 * @param username - Username
	 * @param password - Password
	 * @return
	 *  TRUE se le credenziali dell'amministratore sono state cambiate,
	 *  FALSE altrimenti
	 */
	public boolean changeCredentials(Amministratore amministratore, String username, String password) {
		return database.adminChangeCredentials(amministratore, username, password);
	}
	
	/**
	 * Estrazione del amministratotore appartenente ad un reparto
	 * @return
	 *  Istanza dell'amministratore che gestisce il reparto
	 */
	public Amministratore getAdmin(int reparto) {
		return database.getAdmin(reparto);
	}
	
	/**
	 * Estrazione del range di date occupate
	 * @param start - Data di partenza
	 * @param end   - Data di fine
	 */
	public LinkedList<Prenotazione> getOccupiedMonthSlots(Date start, Date end, int sala) {
		return database.getOccupiedMonthSlots(start, end, sala);
	}
	
	/**
	 * Estrazione della lista delle prenotazioni presenti nel sistema
	 * @return
	 *  Lista delle prenotazioni presenti nel sistema
	 */
	public LinkedList<Prenotazione> fetchReservation(Amministratore admin) {
		return database.fetchReservationAdmin(admin);
	}
	
	/**
	 * Inserimentod di un referto
	 * @param referto - Referto da inserire
	 * @return
	 *  TRUE se l'inserimento e' avvenuto con successo,
	 *  FALSE altrimenti
	 */
	public boolean addReport(Referto referto) {
		return database.addReport(referto);
	}
	
	/**
	 * Modifica di un referto
	 * @param referto - Referto da inserire
	 * @return
	 *  TRUE se l'inserimento e' avvenuto con successo,
	 *  FALSE altrimenti
	 */
	public boolean editReport(Referto referto) {
		return database.editReport(referto);
	}
	
	/**
	 * Estrazione di un referto
	 * @param idPrenotazione - ID della prenotazione
	 * @return
	 *  Il referto a cui la prenotazione fa riferimento, NULL se la
	 *  prenotazione non dispone ancora di un referto
	 */
	public Referto getReport(int idPrenotazione) {
		return database.getReport(idPrenotazione);
	}
	
	
	
	/**
	 * Spostamento della prenotazione
	 * @param prenotazione - Prenotazione da spostare
	 * @param data         - Data della nuova prenotazione
	 * @param ora          - Ora della nuova prenotazione
	 * @return
	 *  TRUE se lo spostamento della prenotazione e' avvenuto con successo,
	 *  FALSE altrimenti;
	 */
	public boolean postponeReservation(Prenotazione prenotazione, Date data, int ora) {
		return database.postponeReservation(prenotazione, data, ora);
	}
	
	/**
	 * L'amministratore conferma la prenotazione
	 * @param prenotazione - Prenotazione
	 * @return
	 *  TRUE se la prenotazione e' avvenuta con successo,
	 *  FALSE altrimenti
	 */
	public boolean reserve(Prenotazione prenotazione) { 
		return database.reserve(prenotazione);
	}
	
	/**
	 * Estrazione di tutti i messaggi di richiesta di prenotazione
	 * @return
	 *  Elenco delle richieste; NULL se non ci sono richieste
	 */
	public LinkedList<Messaggio> fetchPendantRequest(Amministratore admin) {
		return database.fetchPendantRequestAdmin(admin);
	}
	
	/**
	 * Rimozione di un messaggio di richiesta con riferimento
	 * ad una specifica prenotazione
	 * @return
	 *  TRUE se il messaggio e' stato cancellato,
	 *  FALSE altrimenti
	 */
	public boolean destroyRequestMessage(Messaggio messaggio) {
		return database.deleteMessage(messaggio);
	}
	
	/**
	 * Cancellazione di una determinata prenotazione
	 * @return
	 *  TRUE se la cancellazione della prenotazione e' avvenuta con
	 *  successo, FALSE altrimenti
	 */
	public boolean retireReservation(Prenotazione prenotazione) {		
		return database.retireReservationAdmin(prenotazione);
	}
}