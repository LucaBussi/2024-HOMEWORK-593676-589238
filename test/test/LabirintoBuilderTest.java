package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	private LabirintoBuilder labirinto;
	
	@Test
	public void testGetLabirinto() {
		labirinto=new LabirintoBuilder()
				.addStanza("stanza");
		assertNotNull(labirinto.getLabirinto());
	}
	
	@Test
	public void testAggiorna() {
		labirinto=new LabirintoBuilder()
				.addStanza("stanza1");
		assertEquals("stanza1", labirinto.getUltimaStanzaAggiunta().getNome());
		labirinto=labirinto.addStanza("stanza2");
		assertEquals("stanza2", labirinto.getUltimaStanzaAggiunta().getNome());
	}
	
	@Test
	public void testAddStanzaIniziale() {
		assertNull(labirinto);
		labirinto=new LabirintoBuilder()
				.addStanzaIniziale("inizio");
		assertEquals("inizio", labirinto.getMappa().get("inizio").getNome());
	}
	
	@Test
	public void testAddStanzaVincente() {
		assertNull(labirinto);
		labirinto=new LabirintoBuilder()
				.addStanzaVincente("fine");
		assertEquals("fine", labirinto.getMappa().get("fine").getNome());
	}
	
	@Test
	public void testAddStanza() {
		assertNull(labirinto);
		labirinto=new LabirintoBuilder()
				.addStanza("stanza");
		assertEquals("stanza", labirinto.getMappa().get("stanza").getNome());
	}
	
	@Test
	public void testAddAttrezzo() {
		assertNull(labirinto);
		Attrezzo a = new Attrezzo("attrezzo", 1);
		labirinto = new LabirintoBuilder()
				.addStanza("stanza")
				.addAttrezzo("attrezzo", 1);
		assertNotNull(labirinto);
		assertNotNull(labirinto.getMappa());
		Attrezzo b = labirinto.getMappa().get("stanza").getAttrezzo("attrezzo");
		assertNotNull(b);
		assertEquals(a, b);
	}
}
