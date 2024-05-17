package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {

	private Partita partita;
	private ComandoPrendi prendi;
	private Attrezzo attrezzo;
	private IOSimulator console;
	private Stanza stanza;
	private Borsa borsa;
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	@Before
	public void setUp() {
		Labirinto lab=new LabirintoBuilder()
				.addStanzaIniziale("stanza")
				.getLabirinto();
		partita=new Partita(lab);
		prendi=new ComandoPrendi();
		attrezzo=new Attrezzo("attrezzo", 5);
		prendi.setIO(new IOConsole());
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

	@Test
	public void testComandoPrendiEasy() {
		List<String> cmd=new ArrayList<>();
		cmd.add("prendi spada");
		cmd.add("vai nord");
		console=new Fixture().testPartitaEasy(cmd);
		assertTrue(console.hasNext());
		assertEquals(MESSAGGIO_BENVENUTO, console.next());
		assertTrue(console.hasNext());
		assertEquals("Hai raccolto spada (3kg)!", console.next());
		assertTrue(console.hasNext());
		assertEquals("biblioteca", console.next());
		assertTrue(console.hasNext());
		assertEquals("Hai vinto!", console.next());
	}
	@Test
	public void testEseguiEasy() {
		List<String> cmd = new ArrayList<String>();
		cmd.add("prendi spada");
		cmd.add("vai nord");
		console = new Fixture().testPartitaEasy(cmd);
		assertTrue(this.console.hasNext());
		assertEquals(this.console.next(),this.MESSAGGIO_BENVENUTO);
		assertTrue(this.console.hasNext());
		assertEquals(this.console.next(),"Hai raccolto spada (3kg)!");
		assertTrue(this.console.hasNext());
		assertEquals(this.console.next(),"biblioteca");
		assertTrue(this.console.hasNext());
		assertEquals(this.console.next(),"Hai vinto!");
	}
}

