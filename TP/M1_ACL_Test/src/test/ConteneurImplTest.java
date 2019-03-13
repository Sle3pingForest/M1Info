package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.udl.acl.conteneur.ConteneurImpl;
import fr.udl.acl.conteneur.ErreurConteneur;

public class ConteneurImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRight() throws ErreurConteneur{
		ConteneurImpl c = new ConteneurImpl(2);
		c.ajouter(2);
		assertEquals(1, c.taille());
		c.ajouter(4);
		assertEquals(2, c.taille());
	}
	
	@Test(expected=ErreurConteneur.class)
	public void testBoundaryNull() throws ErreurConteneur{
		ConteneurImpl c = new ConteneurImpl(5);
		c.ajouter(null);
		fail("Elem null");
	}

	@Test(expected=ErreurConteneur.class)
	public void testBoundaryDouble() throws ErreurConteneur{
		ConteneurImpl c = new ConteneurImpl(2);
		c.ajouter(1);
		c.ajouter(1);
		fail("Elem Identique");
	}
	
	@Test(expected=ErreurConteneur.class)
	public void testBoundaryObjectEquals() throws ErreurConteneur{
		ConteneurImpl c = new ConteneurImpl(2);
		int i = 2, j = 2;
		c.ajouter(i);
		c.ajouter(j);
		fail("Object Identique");
	}
	

	@Test
	public void testBoundaryC2() throws ErreurConteneur{
		ConteneurImpl c = new ConteneurImpl(2);
		c.ajouter(1);
		assertTrue(c.contient(1));
		c.ajouter(2);
		assertTrue(c.contient(2));
	}
	
	@Test(expected=ErreurConteneur.class)
	public void testBoundary2in1() throws ErreurConteneur{
		ConteneurImpl c = new ConteneurImpl(1);
		c.ajouter(1);
		c.ajouter(2);
	}
}
