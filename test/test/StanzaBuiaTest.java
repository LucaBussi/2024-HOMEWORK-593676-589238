package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private Stanza stanza;
	
	@Before
	public void setUp() {
		stanza=new StanzaBuia("stanza", "lanterna");
	}
	
	@Test
	public void testGetDescrizione_SenzaLuce() {
		assertEquals("Qui c'è un buio pesto", stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_ConLuce() {
		Attrezzo luce=new Attrezzo("lanterna", 0);
		stanza.addAttrezzo(luce);
		assertNotEquals("Qui c'è un buio pesto", stanza.getDescrizione());
	}
}
