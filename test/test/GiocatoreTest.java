package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	private Giocatore giocatore;
	
	@Before
	public void setUp() {
		giocatore=new Giocatore();
	}
	
	@Test
	public void testGetCfu() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		giocatore.setCfu(10);
		assertEquals(10, giocatore.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		assertNotNull(giocatore.getBorsa());
	}

}
