package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private Labirinto lab;
	private Partita partita;
	private String direzione;
	private ComandoVai vai;
	private IOSimulator console;
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
		lab=new LabirintoBuilder()
				.addStanzaIniziale("stanza1")
				.addStanzaVincente("stanza2")
				.addAdiacenza("stanza1", "stanza2", "direzione")
				.getLabirinto();
		partita=new Partita(lab);
		vai=new ComandoVai();
		vai.setIO(new IOConsole());
	}

	@Test
	public void testEsegui_direzioneEsistente() {
		assertSame(this.partita.getStanzaCorrente(), this.lab.getStanzaIniziale());
		vai.setParametro("direzione");
		vai.esegui(partita);
		assertSame(this.partita.getStanzaCorrente(), this.lab.getStanzaVincente());
	}
	
	@Test
	public void testEsegui_direzioneInesistente() {
		assertSame(this.partita.getStanzaCorrente(), this.lab.getStanzaIniziale());
		vai.setParametro("direzione inesistente");
		vai.esegui(partita);
		assertSame(this.partita.getStanzaCorrente(), this.lab.getStanzaIniziale());
	}
	
	@Test
	public void testEsegui_direzioneNulla() {
		direzione=null;
		vai.setParametro(direzione);
		vai.esegui(partita);
	}
	
	@Test
	public void testComandoVaiPartitaEasy() {
		List<String> cmd=new ArrayList<>();
		cmd.add("vai nord");
		console=new Fixture().testPartitaEasy(cmd);
		assertTrue(console.hasNext());
		assertEquals(MESSAGGIO_BENVENUTO, console.next());
		assertTrue(console.hasNext());
		assertEquals("biblioteca", console.next());
		assertTrue(console.hasNext());
		assertEquals("Hai vinto!", console.next());
	}
	
	@Test
	public void testComandoVaiPartitaMid() {
		List<String> cmd=new ArrayList<>();
		cmd.add("vai nord");
		cmd.add("vai ovest");
		cmd.add("vai nord");
		console=new Fixture().testPartitaMid(cmd);
		assertTrue(console.hasNext());
		assertEquals(MESSAGGIO_BENVENUTO, console.next());
		assertTrue(console.hasNext());
		assertEquals("n10", console.next());
		assertTrue(console.hasNext());
		assertEquals("n9", console.next());
		assertTrue(console.hasNext());
		assertEquals("biblioteca", console.next());
		assertTrue(console.hasNext());
		assertEquals("Hai vinto!", console.next());
	}
}
