package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita;
	
	@Before
	public void setUp() {
		partita=new Partita();
	}
	
	@Test
	public void testGetStanzaCorrente_Iniziale() {
		assertNotNull(partita.getStanzaCorrente());
	}

	@Test
	public void testSetStanzaCorrente() {
		Stanza stanza=new Stanza("stanza");
		partita.setStanzaCorrente(stanza);
		assertEquals(stanza, partita.getStanzaCorrente());
	}

	@Test
	public void testVinta_persa() {
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testVinta_vinta() {
		Stanza stanza=partita.getLabirinto().getStanzaVincente();
		partita.setStanzaCorrente(stanza);
		assertTrue(partita.vinta());
	}

	@Test
	public void testIsFinita_nonfinita() {
		assertFalse(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_cfufiniti() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_finita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_vinta() {
		Stanza stanza=partita.getLabirinto().getStanzaVincente();
		partita.setStanzaCorrente(stanza);
		assertTrue(partita.isFinita());
	}
}
