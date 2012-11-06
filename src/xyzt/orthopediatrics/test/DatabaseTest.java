package xyzt.orthopediatrics.test;

import java.sql.Date;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xyzt.orthopediatrics.Type;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.db.Database;

/**
 * Modulo per effettuare il testing dell'interfacciamento con il database.
 * NB: I testing devono essere fatti con il database inizialmente vuoto in
 * quanto i record vengono aggiunti e rimossi a run-time    
 */
@SuppressWarnings("deprecation")
public class DatabaseTest
{
	private Database database = new Database();
	
	private Amministratore adminOrtopedia = new Amministratore(0, "admino", "admino");
	private Amministratore adminPediatria = new Amministratore(1, "adminp", "adminp");
	
	private Paziente paziente = new Paziente("MRIRSS88L20K100M", "mrossi",	"Mario", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1988, 07, 20), null);
	
	private Tutore tutore = new Tutore("MRIRSS88L20K100M", "mrossi",	"Mario", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1988, 07, 20));
	
	private Prenotazione prenotazione = new Prenotazione(10, new Date(2012,06,20), paziente.getNomeutente(), 
			Type.Priorita.ROSSO, Type.Sala.A1, Type.Reparto.ORTOPEDIA);
	
	private Messaggio messaggio1 = new Messaggio(Type.Messaggio.POSTPONE, paziente.getNomeutente(),
			adminOrtopedia.getNomeutente(), "MESSAGGIO DI SPOSTAMENTO", prenotazione.getId());
	private Messaggio messaggio2 = new Messaggio(Type.Messaggio.CANCEL, paziente.getNomeutente(),
			adminPediatria.getNomeutente(), "MESSAGGIO DI CANCELLAZIONE", prenotazione.getId());
	private Messaggio messaggio3 = new Messaggio(Type.Messaggio.REQUEST, paziente.getNomeutente(),
			adminPediatria.getNomeutente(), "MESSAGGIO DI PRENOTAZIONE", -1);
	
	@Before
	public void initDatabaseTest() throws Exception {
		System.out.println("Test: Start database testing ... ");
		
	}

	@After
	public void closeDatabaseTest() throws Exception {
		System.out.println("Test: Database testing end successfully!");
	}

	@Test 
	public void loginAdminTest() {
		Amministratore admin = null;
		admin = database.loginAdmin(0, "admino", "admino");
		assertEquals("Amministratore", (Amministratore) admin, (Amministratore) adminOrtopedia);
		admin = database.loginAdmin(1, "adminp", "adminp");
		assertEquals("Amministratore", (Amministratore) admin, (Amministratore) adminPediatria);
	}

	@Test
	public void fetchPendantRequestsAdminTest() {
		LinkedList<Messaggio> msgList = new LinkedList<Messaggio>();
		msgList = database.fetchPendantRequestAdmin(adminOrtopedia);
		assertEquals("fetchPendantRequestsAdmin()", 0, (int)msgList.size());
	}	
	
	@Test
	public void fetchReservationAdminTest() {
		LinkedList<Prenotazione> pList = new LinkedList<Prenotazione>();
		pList = database.fetchReservationAdmin(adminOrtopedia);
		assertEquals("fetchPendantRequestsAdmin()", 0, (int)pList.size());
	}
	
	@Test
	public void getAdminTest() {
		Amministratore admin = null;
		admin = database.getAdmin(Type.Reparto.ORTOPEDIA);
		assertEquals("getAdminTest()", (Amministratore) admin, (Amministratore) adminOrtopedia);
		admin = database.getAdmin(Type.Reparto.PEDIATRIA);
		assertEquals("getAdminTest()", (Amministratore) admin, (Amministratore) adminPediatria);
	}
	
	@Test
	public void reserveTest() {
		boolean b = database.reserve(prenotazione);
		assertEquals("reserveTest()", true, (boolean) b);
	}
	
	@Test
	public void addReportTest() {
		boolean b = database.addReport(new Referto(prenotazione.getId(), "contenuto", "Mario Rossi", paziente.getNomeutente()));
		assertEquals("addReportTest()", true, (boolean) b);
	}
	
	@Test
	public void loginNonExistingPatientTest() {
		Paziente p = database.loginPatient("xxxxx", "yyyyy");
		assertEquals("loginPatientTest()", null, (Paziente)p);
	}

	@Test
	public void registerNewPatientTest() {
		boolean b = database.registerNewPatient(paziente);
		assertEquals("registerNewPatientTest()", true, (boolean) b);
	}

	@Test
	public void loginExistingPatientTest() {
		Paziente p = database.loginPatient(paziente.getNomeutente(), paziente.getPassword());
		assertEquals("loginPatientTest()", (Paziente) p, (Paziente) paziente);
	}
	
	@Test
	public void getPatientTest() {
		Paziente p = database.getPatient(paziente.getNomeutente());
		assertEquals("getPatientTest()", (Paziente)p, (Paziente)paziente);
	}
	
	@Test
	public void fetchReservationPatientTest() {
		LinkedList<Prenotazione> pList = database.fetchReservetionsPatient(paziente);
		assertEquals("fetchReservationPatientTest()", 1, (int) pList.size());
	}
	
	@Test
	public void sendMessageTest() {
		boolean b1 = database.sendMessage(messaggio1);
		boolean b2 = database.sendMessage(messaggio2);
		boolean b3 = database.sendMessage(messaggio3);
		assertEquals("sendMessageTest()", true, (boolean)b1);
		assertEquals("sendMessageTest()", true, (boolean)b2);
		assertEquals("sendMessageTest()", true, (boolean)b3);
	}
	
	@Test
	public void deferReservationPatientTest() {
		boolean b = database.deferReservationPatient(prenotazione);
		assertEquals("deferReservationPatientTest()", true, (boolean)b);
	}
	
	@Test
	public void retireReservationPatientTest() {
		boolean b = database.retireReservationAdmin(prenotazione);
		assertEquals("retireReservationPatientTest()", true, (boolean)b);
	}
	
	@Test
	public void retireReservationAdminTest() {
		boolean b = database.retireReservationAdmin(prenotazione);
		assertEquals("reserveTest()", true, (boolean)b);
	}
	
	public void postponeReservationAdminTest() {
		boolean b = database.postponeReservation(prenotazione, new Date(2012, 10, 22), 8);
		assertEquals("postponeReservationAdminTest()", true, (boolean)b);
	}
	
	@Test
	public void loginNonExistingTutorTest() {
		Tutore t = database.loginTutor("abcdef", "ghijklm");
		assertEquals("loginNonExistingTutorTest()", null, (Tutore)t);
	}
	
	@Test
	public void registerNewTutor() {
		boolean b = database.registerNewTutor(tutore);
		assertEquals("registerNewTutor()", true, (boolean)b);
	}
	
	@Test
	public void loginExistingTutorTest() {
		Tutore t = database.loginTutor(tutore.getNomeutente(), tutore.getPassword());	
		assertEquals("loginExistingTutoreTest()", (Tutore) tutore, (Tutore) t);
	}
	
	@Test
	public void getTutorTest() {
		Tutore t = database.getTutor(tutore.getNomeutente());
		assertEquals("getTutorTest()", (Tutore)t, (Tutore)tutore);
	}
	
	@Test
	public void getOccupiedMonthSlotsTest() {
		database.reserve(prenotazione);
		LinkedList<Prenotazione> pList = database.getOccupiedMonthSlots(
				new Date(2012, 06, 01), new Date(2012, 07, 01), Type.Sala.A1);
		assertEquals("getOccupiedMonthSlotsTest()", 1, (int)pList.size());
	}
	
	@Test
	public void getReservationTest() {
		Prenotazione p = database.getReservation(prenotazione.getId());
		assertEquals("getReservationTest()", (Prenotazione)p, (Prenotazione)prenotazione);
	}
	
	
}