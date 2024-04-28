package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	private Partita partita;
	private ComandoPosa posa;
	private Attrezzo attrezzo;
	private IO console;
	private Stanza stanza;
	private Borsa borsa;
	
	@Before
	public void SetUp() {
		partita=new Partita();
		posa=new ComandoPosa();
		console=new IOConsole();
		attrezzo=new Attrezzo("attrezzo", 5);
		posa.setIO(console);
		stanza=this.partita.getStanzaCorrente();
		borsa=this.partita.getGiocatore().getBorsa();
		}
	
	@Test
	public void eseguiTest_attrezzoPresente() {
		assertFalse(borsa.hasAttrezzo("attrezzo"));
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
		assertFalse(stanza.hasAttrezzo("attrezzo"));
		posa.setParametro("attrezzo");
		posa.esegui(partita);
		assertTrue(stanza.hasAttrezzo("attrezzo"));
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void eseguiTest_attrezzoAssente() {
		posa.setParametro("attrezzo");
		posa.esegui(partita);
	}
}
