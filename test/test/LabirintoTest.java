package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	private Labirinto labirinto;
	private Stanza stanza;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("stanza1")
				.addStanzaVincente("stanza2")
				.addAdiacenza("stanza1", "stanza2", "nord")
				.getLabirinto();
		this.stanza =new Stanza("stanza");
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals(this.labirinto.getStanzaIniziale().getNome(),"stanza1");
	}

	@Test
	public void testSetStanzaIniziale() {
		assertNotEquals(stanza, labirinto.getStanzaIniziale());
		this.labirinto.setStanzaIniziale(stanza);
		assertEquals(stanza, this.labirinto.getStanzaIniziale());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(this.labirinto.getStanzaVincente().getNome(),"stanza2");
	}

}

