package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	protected Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =	new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	/**
	public void creaStanze() {

		
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave", 0);
		Attrezzo diamante = new Attrezzo("diamante", 1);
    	
		
		Stanza atrio = new StanzaBloccata("Atrio", "chiave", "sud");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaBuia("Aula N10", "lanterna");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        
		aulaN11.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(chiave);
		aulaN10.addAttrezzo(diamante);

		
        stanzaIniziale = atrio;  
		stanzaVincente = biblioteca;
    }
	*/
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public void setStanzaVincente(Stanza s) {
		this.stanzaVincente=s;
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public void setStanzaIniziale(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	

	public static class LabirintoBuilder {
		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> mappa;
		
		public LabirintoBuilder(String lab) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto=new Labirinto(lab);
			this.mappa=new HashMap<String, Stanza>();
		}
		
		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		
		public void aggiorna(Stanza s) {
			this.ultimaStanzaAggiunta=s;
			this.mappa.put(s.getNome(), s);
		}
		
		public LabirintoBuilder addStanzaIniziale(String n) {
			Stanza s=new Stanza(n);
			this.labirinto.setStanzaIniziale(s);
			this.aggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String n) {
			Stanza s=new Stanza(n);
			this.labirinto.setStanzaVincente(s);
			this.aggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addStanza(String n) {
			Stanza s=new Stanza(n);
			this.aggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String n, String l) {
			Stanza s=new StanzaBuia(n, l);
			this.aggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String n, Direzione dir, String key) {
			Stanza s=new StanzaBloccata(n, key, dir);
			this.aggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String n) {
			Stanza s=new StanzaMagica(n);
			this.aggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String s1, String s2, Direzione dir) {
			this.mappa.get(s1).impostaStanzaAdiacente(dir, this.mappa.get(s2));
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String n, int p) {
			Attrezzo a=new Attrezzo(n, p);
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentazione, String nomeAttrezzo, int pesoAttrezzo) {
			if(this.ultimaStanzaAggiunta!=null)
			this.ultimaStanzaAggiunta.setPersonaggio(new Mago(nome, presentazione, new Attrezzo(nomeAttrezzo, pesoAttrezzo)));
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String presentazione) {
			if(this.ultimaStanzaAggiunta!=null)
			this.ultimaStanzaAggiunta.setPersonaggio(new Strega(nome, presentazione));
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String presentazione, String ciboPreferito, String nomeAttrezzo, int pesoAttrezzo) {
			if(this.ultimaStanzaAggiunta!=null)
			this.ultimaStanzaAggiunta.setPersonaggio(new Cane(nome, presentazione));
			return this;
		}
		
		public Map<String, Stanza> getMappa(){
			return this.mappa;
		}
		
		public Stanza getUltimaStanzaAggiunta() {
			return this.ultimaStanzaAggiunta;
		}
		
	}

}
