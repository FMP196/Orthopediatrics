package xyzt.orthopediatrics.test;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import xyzt.orthopediatrics.Type;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.db.Database;

/**
 * Test per Amministratore Manager
 */
@SuppressWarnings("deprecation")
public class CAmministratoreTest
{	
	private Database database = new Database();
	private CAmministratore adminManager = new CAmministratore(database);
	
	private Amministratore adminOrtopedia = new Amministratore(0, "admino", "admino");
	
	private Paziente paziente = new Paziente("MRIRSS88L20K100M", "mrossi",	"Mario", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1988, 07, 20), null);
	
	private Prenotazione prenotazione = new Prenotazione(10, new Date(2012,06,20), paziente.getNomeutente(), 
			Type.Priorita.ROSSO, Type.Sala.A1, Type.Reparto.ORTOPEDIA);
	
	private Messaggio messaggio1 = new Messaggio(Type.Messaggio.POSTPONE, paziente.getNomeutente(),
			adminOrtopedia.getNomeutente(), "MESSAGGIO DI SPOSTAMENTO", prenotazione.getId());
	
	private Referto referto = new Referto(prenotazione.getId(), "referto di prova", "Medico", 
			paziente.getNomeutente());
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Admin Manager class ... ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Amministratore manager test finish!");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception { }

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#CAmministratore(xyzt.orthopediatrics.client.db.Database)}.
	 */
	@Test
	public void testCAmministratore() {
		assertNotNull("database", database);
		assertNotNull("adminManager", adminManager);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#login(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogin() {
		Amministratore admin = adminManager.login(0, "admino", "admino");
		assertEquals("login", (Amministratore)adminOrtopedia, (Amministratore)admin);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#getAdmin(int)}.
	 */
	@Test
	public void testGetAdmin() {
		Amministratore admin = adminManager.getAdmin(adminOrtopedia.getReparto());
		assertEquals("test getAdmin()", (Amministratore)adminOrtopedia, (Amministratore)admin);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#reserve(xyzt.orthopediatrics.client.Prenotazione)}.
	 */
	@Test
	public void testReserve() {
		boolean b = adminManager.reserve(prenotazione);
		assertTrue("testReserve", b);		
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#getOccupiedMonthSlots(java.sql.Date, java.sql.Date, int)}.
	 */
	@Test
	public void testGetOccupiedMonthSlots() {
		List<Prenotazione> pList = adminManager.getOccupiedMonthSlots(new Date(2012, 06, 01), new Date(2012, 07, 01), Type.Sala.A1);
		assertEquals("test getOccupiedMonthSlots()", (int)1, (int)pList.size());
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#fetchReservation(xyzt.orthopediatrics.client.Amministratore)}.
	 */
	@Test
	public void testFetchReservation() {
		List<Prenotazione> pList = adminManager.fetchReservation(adminOrtopedia);
		assertEquals("test fetchReservation()", (int)1, (int)pList.size());
		int index = pList.size()-1;
		Prenotazione p = pList.get(index);
		assertEquals("test fetchReservation()", (Prenotazione)prenotazione, (Prenotazione)p);		
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#addReport(xyzt.orthopediatrics.client.Referto)}.
	 */
	@Test
	public void testAddReport() {
		boolean b = adminManager.addReport(referto);
		assertTrue("test addReport()", b);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#getReport(int)}.
	 */
	@Test
	public void testGetReport() {
		Referto r = adminManager.getReport(referto.getPrenotazione());
		assertEquals("test getReport()", (Referto)referto, (Referto)r);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#fetchPendantRequest(xyzt.orthopediatrics.client.Amministratore)}.
	 */
	@Test
	public void testFetchPendantRequest() {
		database.sendMessage(messaggio1);
		LinkedList<Messaggio> msgList = adminManager.fetchPendantRequest(adminOrtopedia);
		Messaggio m = msgList.get(0);
		assertEquals("test fetchPendantRequest()", (Messaggio)messaggio1, (Messaggio)m);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#postponeReservation(xyzt.orthopediatrics.client.Prenotazione, java.sql.Date, int)}.
	 */
	@Test
	public void testPostponeReservation() {
		Date next = new Date(2012, 9, 11);
		int ora = 9;
		boolean b = adminManager.postponeReservation(prenotazione, next, ora);
		assertTrue("test postponeReservation()", b);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#destroyRequestMessage(xyzt.orthopediatrics.client.Messaggio)}.
	 */
	@Test
	public void testDestroyRequestMessage() {
		boolean b = adminManager.destroyRequestMessage(messaggio1);
		assertTrue("test destoryRequestMessage()", b);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CAmministratore#retireReservation(xyzt.orthopediatrics.client.Prenotazione)}.
	 */
	@Test
	public void testRetireReservation() {
		boolean b = adminManager.retireReservation(prenotazione);
		assertTrue("test retireReservation()", b);
	}

}