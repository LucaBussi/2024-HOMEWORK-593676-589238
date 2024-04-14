package test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test
	public void testGetAttrezzo_stanzaVuota() {
		Stanza vuota=new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));  //restituisce uno o zero in base a quello che trova nel metodo
	}
	
	@Test
	public void testGetAttrezzo_stanzaNonVuota_Presente() {
		Stanza stanza=new Stanza("stanza");
		Attrezzo attrezzo=new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzo_stanzaNonVuota_Assente() {
		Stanza stanza=new Stanza("stanza");
		Attrezzo attrezzo=new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("nomeDiAttrezzoNonPresente"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Isolata() {
		Stanza stanza= new Stanza("stanza");
		assertNull(stanza.getStanzaAdiacente("direzione"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Presente() {
		Stanza stanza= new Stanza("stanza");
		Stanza stanzaAdiacente=new Stanza("stanzaAdiacente");
		stanza.impostaStanzaAdiacente("direzione", stanzaAdiacente);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("direzione"));
	}
	
	/*public void testGetStanzaAdiacente_DirezioneErrata() {
		Stanza stanza= new Stanza("stanza");
		Stanza stanzaAdiacente=new Stanza("stanzaAdiacente");
		stanza.impostaStanzaAdiacente("direzione", stanzaAdiacente);
		assertNull(stanza.getStanzaAdiacente("direzioneErrata"));
	}*/
	
	@Test
	public void testHasAttrezzo_inesistente() {
		Stanza vuota=new Stanza("vuota");
		assertFalse(vuota.hasAttrezzo("inesistente"));
	}
	
	@Test
	public void testAddAttrezzo_esistente() {
		Stanza stanza=new Stanza("stanza");
		Attrezzo attrezzo=new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("attrezzo"));
	}
	
	/*public void testHasAttrezzo_errato() {
		Stanza stanza=new Stanza("stanza");
		Attrezzo attrezzo=new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertFalse(stanza.hasAttrezzo("attrezzoErrato"));
	}*/
	
	@Test
	public void testRemoveAttrezzo() {
		Stanza stanza=new Stanza("stanza");
		Attrezzo attrezzo=new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		stanza.removeAttrezzo(attrezzo);
		assertFalse(stanza.hasAttrezzo("attrezzo"));
	}

	
}



