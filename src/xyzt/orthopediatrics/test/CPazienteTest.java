package xyzt.orthopediatrics.test;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import xyzt.orthopediatrics.Type;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.db.Database;

@SuppressWarnings("deprecation")
public class CPazienteTest
{	
	private Database database = new Database();
	private CPaziente patientManager = new CPaziente(database);
	
	private Amministratore adminPediatria = new Amministratore(1, "adminp", "adminp");
	
	private Paziente paziente = new Paziente("MRIRSS88L20K100M", "mrossi",	"Mario", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1988, 07, 20), null);
	
	private Paziente pazienteMinorenne = new Paziente("ANTRSS88L20K100K", "mrossi2",	"Antonio", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1995, 07, 20), null);
	
	private Tutore tutore = new Tutore("MRIRSS88L20K100M", "mrossi",	"Mario", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1988, 07, 20));
	
	private Prenotazione prenotazione = new Prenotazione(10, new Date(2012,06,20), paziente.getNomeutente(), 
			Type.Priorita.ROSSO, Type.Sala.A1, Type.Reparto.ORTOPEDIA);
	
	private Messaggio messaggio3 = new Messaggio(Type.Messaggio.REQUEST, paziente.getNomeutente(),
			adminPediatria.getNomeutente(), "MESSAGGIO DI RICHIESTSA DI PRENOTAZIONE", -1);
	
	private Referto referto = new Referto(prenotazione.getId(), "referto di prova", "Medico", paziente.getNomeutente());
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Patient Manager class ... ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Patient Manager test finish!");
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
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#CPaziente(xyzt.orthopediatrics.client.db.Database)}.
	 */
	@Test
	public void testCPaziente() {
		assertNotNull("database", database);
		assertNotNull("patientManager", patientManager);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#registerNewPatient(xyzt.orthopediatrics.client.Paziente)}.
	 */
	@Test
	public void testRegisterNewPatient() {
		boolean b = patientManager.registerNewPatient(paziente);
		assertTrue("test registerNewPatient()", b);
	}
	
	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#login(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogin() {
		Paziente p = patientManager.login("MRIRSS88L20K100M", "mrossi");
		assertEquals("test login()", (Paziente)paziente, (Paziente)p);
	}
	
	

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#getPaziente(java.lang.String)}.
	 */
	@Test
	public void testGetPaziente() {
		Paziente p = patientManager.getPaziente(paziente.getNomeutente());
		assertEquals("test getPaziente()", (Paziente)paziente, (Paziente)p);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#registerNewPatientFromTutor(xyzt.orthopediatrics.client.Paziente, xyzt.orthopediatrics.client.Tutore)}.
	 */
	@Test
	public void testRegisterNewPatientFromTutor() {
		boolean b = patientManager.registerNewPatientFromTutor(pazienteMinorenne, tutore);
		assertTrue("test registerNewPatientFromTutor()", b);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#fetchReservation(xyzt.orthopediatrics.client.Paziente)}.
	 */
	@Test
	public void testFetchReservation() {
		database.reserve(prenotazione);
		List<Prenotazione> pList = patientManager.fetchReservation(paziente);
		assertEquals("test fetchReservation()", (int)1, (int)pList.size());
		Prenotazione p = pList.get(0);
		assertEquals("test fetchReservation()", (Prenotazione)prenotazione, (Prenotazione)p);	
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#fetchReport(int)}.
	 */
	@Test
	public void testFetchReport() {
		Referto r = patientManager.fetchReport(prenotazione.getId());
		assertNull("test fetchReport()", r);
		database.addReport(referto);
		r = patientManager.fetchReport(prenotazione.getId());
		assertEquals("test fetchReport()", (Referto)referto, (Referto)r);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#retireReservation(xyzt.orthopediatrics.client.Prenotazione)}.
	 */
	@Test
	public void testRetireReservation() {
		boolean b = patientManager.retireReservation(prenotazione);
		assertTrue("test retireReservation()", b);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#deferReservation(xyzt.orthopediatrics.client.Prenotazione)}.
	 */
	@Test
	public void testDeferReservation() {
		boolean b = patientManager.deferReservation(prenotazione);
		assertTrue("test retireReservation()", b);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CPaziente#reserveVisit(xyzt.orthopediatrics.client.Messaggio)}.
	 */
	@Test
	public void testReserveVisit() {
		boolean b = patientManager.reserveVisit(messaggio3);
		assertTrue("test retireReservation()", b);
	}

}