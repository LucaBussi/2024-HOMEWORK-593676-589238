package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private Stanza stanza;

	
	@Before
	public void setUp() {
		stanza=new StanzaBloccata("stanza", "chiave", Direzione.sud);
	}
	
	@Test
	public void testGetStanzaAdiacente_Bloccata() {
		assertEquals(stanza, stanza.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test
	public void testGetStanzaAdiacente_Sbloccata() {
		Attrezzo chiave=new Attrezzo("chiave", 0);
		stanza.addAttrezzo(chiave);
		assertNull(stanza.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test 
	public void testGetStanzaAdiacente_ChiaveErrata() {
		Attrezzo chiaveErrata=new Attrezzo("ChiaveErrata", 0);
		stanza.addAttrezzo(chiaveErrata);
		assertEquals(stanza, stanza.getStanzaAdiacente(Direzione.sud));
	}
}
