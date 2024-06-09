package test;


import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.borsa=new Borsa();
		this.attrezzo=new Attrezzo("attrezzo", 5);
	}
	
	@Test
	public void testAddAttrezzo() {
		assertFalse(borsa.hasAttrezzo("attrezzo"));
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, borsa.getPesoMax());
	}

	@Test
	public void testGetAttrezzo_assente() {
		assertNull(borsa.getAttrezzo("assente"));
	}
	
	@Test
	public void testGetAttrezzo_presente() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, borsa.getAttrezzo("attrezzo"));
	}

	@Test
	public void testGetPeso_BorsaVuota() {
		assertEquals(0, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaNonVuota() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(5, borsa.getPeso());
	}
	
	@Test
	public void testGetNumeroAttrezzi_BorsaVuota() {
		assertEquals(0, borsa.getNumeroAttrezzi());
	}
	
	@Test
	public void testGetNumeroAttrezzi_BorsaNonVuota() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(1, borsa.getNumeroAttrezzi());
	}

	@Test
	public void testIsEmpty_Vuota() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testIsEmpty_NonVuota() {
		borsa.addAttrezzo(attrezzo);
		assertFalse(borsa.isEmpty());
	}

	@Test
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
		assertEquals(attrezzo, borsa.removeAttrezzo("attrezzo"));
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo a=new Attrezzo("a", 2);
		Attrezzo b=new Attrezzo("b", 1);
		assertTrue(this.borsa.addAttrezzo(b));
		assertTrue(this.borsa.addAttrezzo(a));
		List<Attrezzo> s=this.borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it=s.iterator();
		assertSame(b, it.next());
		assertSame(a, it.next());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo a=new Attrezzo("a", 2);
		Attrezzo b=new Attrezzo("b", 1);
		assertTrue(this.borsa.addAttrezzo(b));
		assertTrue(this.borsa.addAttrezzo(a));
		Set<Attrezzo> s=this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it=s.iterator();
		assertSame(a, it.next());
		assertSame(b, it.next());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo a1=new Attrezzo("a1", 2);
		Attrezzo a2=new Attrezzo("a2", 2);
		Attrezzo b=new Attrezzo("b", 1);
		assertTrue(this.borsa.addAttrezzo(a1));
		assertTrue(this.borsa.addAttrezzo(b));
		assertTrue(this.borsa.addAttrezzo(b));
		assertTrue(this.borsa.addAttrezzo(a2));
		
		Map<Integer, Set<Attrezzo>> m=this.borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Integer> it=m.keySet().iterator();
		assertEquals((Integer)b.getPeso(), it.next());
		assertEquals(1, m.get((Integer)b.getPeso()).size());
		assertEquals((Integer)a1.getPeso(), it.next());
		assertEquals(2, m.get((Integer)a1.getPeso()).size());
	}
	
	@Test
	public void getSortedSetOrdinatoPerPeso_2Attrezzo_PesoUguale_NomeDiverso() {
		Attrezzo attrezzoCopia=new Attrezzo("copia", this.attrezzo.getPeso());
        assertTrue(this.borsa.addAttrezzo(attrezzo));
        assertTrue(this.borsa.addAttrezzo(attrezzoCopia));
        Set<Attrezzo> InsiemeOrdinato=this.borsa.getSortedSetOrdinatoPerPeso();
        Iterator<Attrezzo> i = InsiemeOrdinato.iterator();
        assertTrue(i.hasNext());
        assertEquals(i.next(),attrezzo);
        assertTrue(i.hasNext());
        assertEquals(i.next(),attrezzoCopia);
        assertFalse(i.hasNext());
    }

}
