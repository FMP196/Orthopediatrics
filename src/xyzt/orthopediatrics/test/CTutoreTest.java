package xyzt.orthopediatrics.test;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.creator.CTutore;
import xyzt.orthopediatrics.client.db.Database;

@SuppressWarnings("deprecation")
public class CTutoreTest
{
	private Database database = new Database();
	private CTutore tutorManager = new CTutore(database);
	
	private Paziente pazienteMinorenne = new Paziente("ANTRSS88L20K100K", "mrossi2",	"Antonio", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1995, 07, 20), null);
	
	private Tutore tutore = new Tutore("MRIRSS88L20K100M", "mrossi",	"Mario", "Rossi",
			"Via S. Vitale", "+39 332 3134 6817", "mrossi@email.it", new Date(1988, 07, 20));
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Tutor Manager class ... ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tutor Manager test finish!");
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
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CTutore#CTutore(xyzt.orthopediatrics.client.db.Database)}.
	 */
	@Test
	public void testCTutore() {
		assertNotNull("database", database);
		assertNotNull("tutorManager", tutorManager);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CTutore#registerNewTutor(xyzt.orthopediatrics.client.Tutore)}.
	 */
	@Test
	public void testRegisterNewTutor() {
		boolean b = tutorManager.registerNewTutor(tutore);
		assertTrue("test registerNewTutor()", b);
	}
	
	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CTutore#login(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogin() {
		Tutore t = null;

		t = tutorManager.login("MRIRSS88L20K100M", "mrossi");
		assertEquals("test login()", (Tutore)tutore, (Tutore)t);

		t = tutorManager.login("blablalbla", "blablabla");
		assertNull("test login()", t);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CTutore#getTutor(java.lang.String)}.
	 */
	@Test
	public void testGetTutor() {
		Tutore t = tutorManager.getTutor(tutore.getNomeutente());
		assertEquals("test getTutor()", (Tutore)tutore, (Tutore)t);
	}

	/**
	 * Test method for {@link xyzt.orthopediatrics.client.creator.CTutore#bindTutorForPatient(xyzt.orthopediatrics.client.Paziente, xyzt.orthopediatrics.client.Tutore)}.
	 */
	@Test
	public void testBindTutorForPatient() {
		boolean b = tutorManager.bindTutorForPatient(pazienteMinorenne, tutore);
		assertTrue("test bindTutorForPatient()", b);
	}
}