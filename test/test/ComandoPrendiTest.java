package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {

	private Partita partita;
	private ComandoPrendi prendi;
	private Attrezzo attrezzo;
	private IO console;
	private Stanza stanza;
	private Borsa borsa;

	@Before
	public void setUp() {
		partita=new Partita();
		prendi=new ComandoPrendi();
		console=new IOConsole();
		attrezzo=new Attrezzo("attrezzo", 5);
		prendi.setIO(console);
		stanza=this.partita.getStanzaCorrente();
		borsa=this.partita.getGiocatore().getBorsa();
	}

	@Test
	public void testEsegui_attrezzoPresente() {
		assertFalse(stanza.hasAttrezzo("attrezzo"));
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("attrezzo"));
		assertFalse(borsa.hasAttrezzo("attrezzo"));
		prendi.setParametro("attrezzo");
		prendi.esegui(partita);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
		assertFalse(stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void testEsegui_attrezzoAssente() {
		prendi.setParametro("attrezzo");
		prendi.esegui(partita);
	}
}

