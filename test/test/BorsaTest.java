package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.borsa=new Borsa();
		this.attrezzo=new Attrezzo("attrezzo", 5);
	}
	
	@Test
	public void testAddAttrezzo() {
		assertFalse(borsa.hasAttrezzo("attrezzo"));
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, borsa.getPesoMax());
	}

	@Test
	public void testGetAttrezzo_assente() {
		assertNull(borsa.getAttrezzo("assente"));
	}
	
	@Test
	public void testGetAttrezzo_presente() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, borsa.getAttrezzo("attrezzo"));
	}

	@Test
	public void testGetPeso_BorsaVuota() {
		assertEquals(0, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaNonVuota() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(5, borsa.getPeso());
	}
	
	@Test
	public void testGetNumeroAttrezzi_BorsaVuota() {
		assertEquals(0, borsa.getNumeroAttrezzi());
	}
	
	@Test
	public void testGetNumeroAttrezzi_BorsaNonVuota() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(1, borsa.getNumeroAttrezzi());
	}

	@Test
	public void testIsEmpty_Vuota() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testIsEmpty_NonVuota() {
		borsa.addAttrezzo(attrezzo);
		assertFalse(borsa.isEmpty());
	}

	@Test
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
		assertEquals(attrezzo, borsa.removeAttrezzo("attrezzo"));
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}

}
