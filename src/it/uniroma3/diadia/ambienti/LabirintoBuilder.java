package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> mappa;
	
	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
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
	
	public LabirintoBuilder addStanzaBloccata(String n, String dir, String key) {
		Stanza s=new StanzaBloccata(n, key, dir);
		this.aggiorna(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String n) {
		Stanza s=new StanzaMagica(n);
		this.aggiorna(s);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String s1, String s2, String dir) {
		this.mappa.get(s1).impostaStanzaAdiacente(dir, this.mappa.get(s2));
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String n, int p) {
		Attrezzo a=new Attrezzo(n, p);
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public Map<String, Stanza> getMappa(){
		return this.mappa;
	}
	
	public Stanza getUltimaStanzaAggiunta() {
		return this.ultimaStanzaAggiunta;
	}
}
