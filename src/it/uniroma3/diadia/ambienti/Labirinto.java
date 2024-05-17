package it.uniroma3.diadia.ambienti;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
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
}
