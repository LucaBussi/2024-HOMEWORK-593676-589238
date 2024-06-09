package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	
	public void esegui(Partita partita) {
		if(this.parametro==null) {
			this.console.mostraMessaggio("Quale attrezzo vuoi prendere?");
			this.parametro=this.console.leggiRiga();
		}
		if(partita.getStanzaCorrente().hasAttrezzo(parametro)) {
			Attrezzo a=new Attrezzo(parametro, partita.getStanzaCorrente().getAttrezzo(parametro).getPeso());
			partita.getStanzaCorrente().removeAttrezzo(a);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.console.mostraMessaggio("Hai raccolto "+a+"!");
		}
		else {
			this.console.mostraMessaggio("L'attrezzo che cerchi non si trova nella stanza attuale.");
		}	
	}
}
