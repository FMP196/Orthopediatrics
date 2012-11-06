package xyzt.orthopediatrics.client.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.Type;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.Tutore;
import ejp.DatabaseException;

public class Database
{
	/**
	 * @uml.property  name="dbms"
	 * @uml.associationEnd  readOnly="true"
	 */
	private DBMS dbms;

	/**
	 * Costruttore di default
	 * @param dbms - Gestore del database
	 */
	public Database() {
		this.dbms = new DBMS();
	}	
	
	/**
	 * Verifica l'esistenza di un database
	 * @return
	 *  True se il database esiste, False altrimenti;
	 */
	public boolean existsDatabase()
	{	
		boolean status = true;
		
		/* all'atto di creazione del database vengono inseriti
		 * anche gli amministratori; se questi esistono allora
		 * il database e' stato creato correttamente
		 */
		try {
			dbms.getDBManager().loadObject(Amministratore.class);
		}
		catch (DatabaseException e) {
			status = false;
		}
		finally {
			dbms.closeDBManager();
		}
				
		return status;
	}
	
	/**
	 * Creazione del database e di tutte le relazioni
	 * @return
	 *  TRUE se la creazione del database avviene con successo,
	 *  FALSE altrimenti
	 */
	public boolean createDatabase() {
		boolean status = true;
		try {
			dbms.getDBManager().executeUpdate(DBConst.SQL_CREATE_ADMIN_TABLE);
			dbms.getDBManager().executeUpdate(DBConst.SQL_CREATE_PATIENT_TABLE);
			dbms.getDBManager().executeUpdate(DBConst.SQL_CREATE_TUTOR_TABLE);
			dbms.getDBManager().executeUpdate(DBConst.SQL_CREATE_MSG_TABLE);
			dbms.getDBManager().executeUpdate(DBConst.SQL_CREATE_REPORT_TABLE);
			dbms.getDBManager().executeUpdate(DBConst.SQL_CREATE_RESERVATION_TABLE);
			dbms.getDBManager().executeUpdate(DBConst.SQL_INSERT_ADMIN_ORTOPEDIA);
			dbms.getDBManager().executeUpdate(DBConst.SQL_INSERT_ADMIN_PEDIATRIA);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			status = false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return status;
	}
	

	
	
	/************************************
	 *     Gestione Amministratore      * 
	 ************************************/
	
	/**
	 * Cambia le credenziali dell'amministratore
	 * @param username - Username
	 * @param password - Password
	 * @return
	 *  TRUE se le credenziali dell'amministratore sono state cambiate,
	 *  FALSE altrimenti
	 */
	public boolean adminChangeCredentials(Amministratore admin, String newUsername, String newPassword) {
		String SQL = "";
		SQL += "UPDATE amministratore SET nomeutente = '"+newUsername+"', password = '"+newPassword+"' ";
		SQL += "WHERE nomeutente='"+admin.getNomeutente()+"' AND " + "password = '" + admin.getPassword() + "';";
		
		try {
			dbms.getDBManager().executeUpdate(SQL);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	/** 
	 * Esegue il login di un amministratore
	 * @return
	 *  Un oggetto di tipo Amministratore con tutti i campi pre-impostati se
	 *  'username', 'password' e 'reparto' appartengono allo stesso amministratore;
	 *  NULL altrimenti
	 */
	public Amministratore loginAdmin(int reparto, String nomeutente, String password) {
		List<Amministratore> adminList = new ArrayList<Amministratore>();
		try {
			dbms.getDBManager().loadObjects(adminList, Amministratore.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// scansione degli amministratori presenti nel sistema
		for (Amministratore admin : adminList) {
			if ((admin.getNomeutente().equals(nomeutente)) && 
				(admin.getPassword().equals(password)) && (admin.getReparto() == reparto))
			{
				return admin;
			}
		}
		return null;
	}	
	
	/**
	 * Estrazione di tutte le richieste di prenotazione
	 * @return
	 *   NULL se non ci sono messaggi per diretti all'amministratore,
	 *   altrimenti viene restituito vettore di messaggi riguardanti
	 *   le richieste di prenotazione da parte dei pazienti
	 */
	public LinkedList<Messaggio> fetchPendantRequestAdmin(Amministratore amministratore)
	{
		LinkedList<Messaggio> list = new LinkedList<Messaggio>();
		LinkedList<Messaggio> msgList = new LinkedList<Messaggio>();
		
		try {
			dbms.getDBManager().loadObjects(msgList, Messaggio.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}

		// scansione di tutti i messaggi presenti nel sistema
		for (Messaggio m : msgList) {	
			if (m.getDestinatario().equals(amministratore.getNomeutente())) {
				list.add(new Messaggio(m.getTipo(), m.getData(), m.getOrario(), m.getMittente(),
						m.getDestinatario(), m.getContent(), m.getPrenotazione()));
			}
		}
		return list;
	}	
	
	/**
	 * Estrazione della lista delle prenotazioni presenti nel sistema
	 * @return
	 *  Lista delle prenotazioni presenti nel sistema
	 */
	public LinkedList<Prenotazione> fetchReservationAdmin(Amministratore admin)
	{	
		LinkedList<Prenotazione> pList = new LinkedList<Prenotazione>();
		LinkedList<Prenotazione> subList = new LinkedList<Prenotazione>();
			
		try {
			dbms.getDBManager().loadObjects(pList, Prenotazione.class);
		}	
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		/* scansione di tutti i messaggi presenti nel sistema;
		 * vengono estratti solo quelli appartenenti allo stesso reparto 
		 * che gestisce l'amministratore
		 */
		for (Prenotazione prenotazione : pList) {
			if (prenotazione.getReparto() == admin.getReparto())
				subList.add(prenotazione);
		}
			
		return subList;
	}
	
	/**
	 * Estrae dal database l'amministratore appartenente ad un
	 * certo reparto
	 * @param reparto - Reparto dell'amministratore
	 * @return
	 *   Amministratore appartenente al reparto
	 * @throws DatabaseException 
	 */
	public Amministratore getAdmin(int reparto)
	{
		List<Amministratore> adminList = new ArrayList<Amministratore>();
		try {
			dbms.getDBManager().loadObjects(adminList, Amministratore.class);
		}
		catch (DatabaseException e) {	
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// scansione degli amministratori presenti nel sistema
		for (Amministratore admin : adminList) {
			if (admin.getReparto() == reparto) {
				return admin;
			}
		}
		
		return null;
	}
	
	/**
	 * Conferma di prenotazione
	 * @param prenotazione - Prenotazione da confermare
	 * @return
	 *  TRUE se la prenotazione e' avvenuta con successo,
	 *  FALSE altrimenti
	 */
	public boolean reserve(Prenotazione prenotazione)
	{
		try {
			dbms.getDBManager().saveObject(prenotazione);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	/**
	 * Cancellazione della prenotazione da parte dell'amministratore
	 * @param prenotazione - Prenotazione da cancellare
	 * @return
	 *  TRUE se la cancellazione della prenotazione e' avvenuta con
	 *  successo, FALSE altrimenti
	 */
	public boolean retireReservationAdmin(Prenotazione prenotazione)
	{
		try {
			dbms.getDBManager().deleteObject(prenotazione);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	/**
	 * Spostamento della prenotazione
	 * @param prenotazione - Prenotazione da spostare
	 * @param data         - Data della nuova prenotazione
	 * @return
	 *  TRUE se lo spostamento della prenotazione e' avvenuto con successo,
	 *  FALSE altrimenti;
	 */
	public boolean postponeReservation(Prenotazione prenotazione, Date data, int ora)
	{
		if ((retireReservationAdmin(prenotazione)) == true) {
			String paziente = prenotazione.getPaziente();
			int priorita = prenotazione.getPriorita();
			int sala = prenotazione.getSala();
			int reparto = prenotazione.getReparto();
			return reserve(new Prenotazione(ora, data, paziente, priorita, sala, reparto));
		}
		
		return false;
	}
	
	
	/**
	 * Inserimentod di un referto
	 * @param referto - Referto da inserire
	 * @return
	 *  TRUE se l'inserimento e' avvenuto con successo,
	 *  FALSE altrimenti
	 */
	public boolean addReport(Referto referto) {
		try {
			dbms.getDBManager().saveObject(referto);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	/**
	 * Modifica di un report
	 * @param referto
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean editReport(Referto referto) {
		try {
			dbms.getDBManager().updateObject(referto);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	
	/**
	 * Autenticazione del paziente paziente
	 * @return
	 *  Istanza del paziente che ha eseguito il login
	 */
	public Paziente loginPatient(String nomeutente, String password)
	{		
		List<Paziente> patientList = new ArrayList<Paziente>();
		try {
			dbms.getDBManager().loadObjects(patientList, Paziente.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// scansione degli amministratori presenti nel sistema
		for (Paziente paziente : patientList) {
			if ((paziente.getNomeutente().equals(nomeutente)) && (paziente.getPassword().equals(password))) {
				return new Paziente(paziente.getNomeutente(), paziente.getPassword(), paziente.getNome(),
						paziente.getCognome(), paziente.getIndirizzo(), paziente.getTelefono(), paziente.getEmail(),
						paziente.getNascita(), paziente.getTutore());
			}
		}
		
		return null;
	}
	
	
	/**
	 * Estrazione di un paziente
	 * @return
	 *   Il paziente corrispondente
	 */
	public Paziente getPatient(String nomeutente) 
	{
		List<Paziente> patientList = new ArrayList<Paziente>();
		try {
			dbms.getDBManager().loadObjects(patientList, Paziente.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// scansione degli amministratori presenti nel sistema
		for (Paziente paziente : patientList) {			
			if (paziente.getNomeutente().equals(nomeutente)) {
				return paziente;
			}
		}
		
		return null;
	}
	
	
	/**
	 * Registrazione di un paziente
	 * @param paziente - Paziente da registrare
	 * @throws DatabaseException 
	 */
	public boolean registerNewPatient(Paziente paziente) 
	{
		// si verificha che l'utente non risulti gia' registrato
		if ((getPatient(paziente.getNomeutente())) == null)
		{
			try {
				dbms.getDBManager().saveObject(paziente);
			}
			catch (DatabaseException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				dbms.closeDBManager();
			}
		}
		
		return true;
	}
	
	/**
	 * Estrazione delle risposte di prenotazione
	 * @return
	 *  NULL se non ci sono messaggi per diretti al paziente,
	 *  altrimenti viene restituito il vettore di messaggi riguardanti
	 *  le risposte di prenotazione da parte dei pazienti
	 */
	public LinkedList<Prenotazione> fetchReservetionsPatient(Paziente paziente)
	{
		LinkedList<Prenotazione> pList = new LinkedList<Prenotazione>();
		LinkedList<Prenotazione> list = new LinkedList<Prenotazione>();

		try {
			dbms.getDBManager().loadObjects(pList, Prenotazione.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// scansione di tutti i messaggi presenti nel sistema
		for (Prenotazione prenotazione : pList) {
			if (prenotazione.getPaziente().equals(paziente.getNomeutente()))
				list.add(prenotazione);
		}
		
		return list;
	}
	
	
	/**
	 * Cancellazione della prenotazione da parte del paziente
	 * @param prenotazione - Prenotazione da cancellare
	 * @return
	 *  TRUE se la cancellazione e' avvenuta con successo,
	 *  FALSE altrimenti
	 */
	public boolean retireReservationPatient(Prenotazione prenotazione)
	{
		List<Prenotazione> pList = new ArrayList<Prenotazione>();
		try {
			dbms.getDBManager().loadObjects(pList, Prenotazione.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		/* scansione di tutte le prenotazioni all'interno del database
		 */
		for (Prenotazione p : pList) {			
			if (p.getId() == prenotazione.getId()) 
			{
				/* la prenotazione esiste
				 * creazione del messaggio di richiesta
				 */
				int type = Type.Messaggio.CANCEL;
				int idPrenotazione = prenotazione.getId();
				String mittente = prenotazione.getPaziente();
				String destinatario = getAdmin(prenotazione.getReparto()).getNomeutente();

				// Contenuto del messaggio
				String content = "";
				content += "Il paziente " + getPatient(mittente).getNome() + " " + getPatient(mittente).getCognome() + " ";
				content += "richiede la cancellazione della prenotazione n. " + idPrenotazione + " con le seguenti info:\n";
				content += " >> " + prenotazione.toString();
	
				// creazione del messaggio da inviare all'amministratore
				Messaggio messaggio = new Messaggio(type, mittente, destinatario, content, idPrenotazione);					
				sendMessage(messaggio);
				
				return true;
			}
		}
		
		return false;
			
	}
	
	/**
	 * Richiesta di spostamento della prenotazione da parte del paziente
	 * @param prenotazione - Prenotazione da spostare
	 * @return
	 *  TRUE se lo spostamento della prenotazione e' avvenuto con
	 *  successo, FALSE altrimenti;
	 */
	public boolean deferReservationPatient(Prenotazione prenotazione)
	{
		List<Prenotazione> pList = new ArrayList<Prenotazione>();
		try {
			dbms.getDBManager().loadObjects(pList, Prenotazione.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		/* scansione di tutte le prenotazioni all'interno del database
		 */
		for (Prenotazione p : pList) {			
			if (p.getId() == prenotazione.getId()) 
			{
				/* la prenotazione esiste
				 * creazione del messaggio di richiesta
				 */
				int type = Type.Messaggio.POSTPONE;
				int idPrenotazione = prenotazione.getId();
				String mittente = prenotazione.getPaziente();
				String destinatario = getAdmin(prenotazione.getReparto()).getNomeutente();

				// Contenuto del messaggio
				String content = "";
				content += "Il paziente " + getPatient(mittente).getNome() + " " + getPatient(mittente).getCognome() + " ";
				content += "richiede lo spostamento della prenotazione n. " + idPrenotazione + " con le seguenti info:\n";
				content += " >> " + prenotazione.toString();
				
				// creazione del messaggio da inviare all'amministratore
				Messaggio messaggio = new Messaggio(type, mittente, destinatario, content, idPrenotazione);
				sendMessage(messaggio);
				
				return true;
			}
		}
		
		return false;
	}
	
	
	// -- TUTORE

	/**
	 * Login di un tutore
	 * @param nomeutente - Username del tutore
	 * @param password   - Password del tutore
	 * @return           - Un oggetto che rappresenta il tutore
	 * @throws DatabaseException 
	 */
	public Tutore loginTutor(String nomeutente, String password)
	{
		List<Tutore> tutorList = new ArrayList<Tutore>();		
		try {
			dbms.getDBManager().loadObjects(tutorList, Tutore.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}

		// scansione dei tutor presenti nel sistema
		for (Tutore tutore : tutorList) {		
			if ((tutore.getNomeutente().equals(nomeutente)) && (tutore.getPassword().equals(password))) {
				return tutore;
			}
		}
		
		return null;
	}
	
	/**
	 * Registrazione di un tutore
	 * @param paziente - tutore da registrare
	 * @throws DatabaseException 
	 */
	public boolean registerNewTutor(Tutore tutore) 
	{
		// verifichiamo che il tutore non risulti registrato precedentemente
		if (getTutor(tutore.getNomeutente()) == null)
		{
			try {
				dbms.getDBManager().saveObject(tutore);
			}
			catch (DatabaseException e) {
				e.printStackTrace();
			}
			finally {
				dbms.closeDBManager();
			}
		}
		
		return true;
	}
	
	
	/**
	 * Estrazione di un tutor dal database
	 * @return
	 *  Istanza del tutor corrispondente al nomeutente;
	 *  NULL se nomeutente non e' presente nel sistema
	 */
	public Tutore getTutor(String nomeutente)
	{
		List<Tutore> tutorList = new ArrayList<Tutore>();
		try {
			dbms.getDBManager().loadObjects(tutorList, Tutore.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		for (Tutore tutore : tutorList) {
			if (tutore.getNomeutente().equals(nomeutente))
				return tutore;
		}
		
		return null;
	}	
	

	
	/**
	 * Salva un messaggio all'interno del database
	 * @param msg - Messaggio da inserire
	 * @return
	 *   TRUE se il messaggio e' stato inserito, FALSE altrimenti
	 * @throws DatabaseException
	 */
	public boolean sendMessage(Messaggio msg)
	{
		try {
			msg.setData(new Calendario().getCurrentDate());			
			dbms.getDBManager().saveObject(msg);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	
	/**
	 * Rimuove un messaggio dal database
	 * @param msg - Messaggio da rimuovere
	 * @return
	 *   TRUE se il messaggio e' stato rimosso, FALSE altrimenti
	 * @throws DatabaseException
	 */
	public boolean deleteMessage(Messaggio msg)
	{
		try {
			dbms.getDBManager().deleteObject(msg);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			dbms.closeDBManager();
		}
		
		return true;
	}
	
	/**
	 * Estrazione del range di date occupate
	 * @param start - Data di partenza
	 * @param end   - Data di fine
	 */
	public LinkedList<Prenotazione> getOccupiedMonthSlots(Date start, Date end, int sala)
	{
		List<Prenotazione> pList = new ArrayList<Prenotazione>();
		LinkedList<Prenotazione> list = new LinkedList<Prenotazione>();
		try {
			dbms.getDBManager().loadObjects(pList, Prenotazione.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// estrazione delle prenotazioni
		for (Prenotazione p : pList) {
			if ((p.getData().after(start)) && p.getData().before(end))
				list.add(p);
		}
		
		return list;
	}
	
	
	/**
	 * Estrazione di una determinata prenotazione
	 * @param ID
	 * @return
	 */
	public Prenotazione getReservation(int ID)
	{
		List<Prenotazione> pList = new ArrayList<Prenotazione>();
		try {
			dbms.getDBManager().loadObjects(pList, Prenotazione.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		// estrazione della prenotazioni
		for (Prenotazione prenotazione : pList)
			if (prenotazione.getId() == ID)
				return prenotazione;
		
		return null;
	}
	
	
	/**
	 * Estrazione di un referto dal database
	 * @param idPrenotazione - ID della prenotazione a cui il referto
	 * fa riferimento
	 * @return
	 *  Il referto a cui la prenotazione fa riferimento,
	 *  null se la prenotazione non dispone ancora di un referto
	 */
	public Referto getReport(int idPrenotazione)
	{
		List<Referto>  reportList = new ArrayList<Referto>();
		try {
			dbms.getDBManager().loadObjects(reportList, Referto.class);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
		finally {
			dbms.closeDBManager();
		}
		
		for (Referto referto : reportList) {
			if (referto.getPrenotazione() == idPrenotazione)
				return referto;
		}
		
		return null;
	}
	
}