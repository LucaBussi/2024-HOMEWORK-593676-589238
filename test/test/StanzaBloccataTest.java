package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private Stanza stanza;

	
	@Before
	public void setUp() {
		stanza=new StanzaBloccata("stanza", "chiave", "sud");
	}
	
	@Test
	public void testGetStanzaAdiacente_Bloccata() {
		assertEquals(stanza, stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Sbloccata() {
		Attrezzo chiave=new Attrezzo("Passepartout", 0);
		stanza.addAttrezzo(chiave);
		assertNull(stanza.getStanzaAdiacente("sud"));
	}
	
	@Test 
	public void testGetStanzaAdiacente_ChiaveErrata() {
		Attrezzo chiaveErrata=new Attrezzo("ChiaveErrata", 0);
		stanza.addAttrezzo(chiaveErrata);
		assertEquals(stanza, stanza.getStanzaAdiacente("sud"));
	}
}
