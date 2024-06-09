package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{
	
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getDescrizione().equals("Qui c'è un buio pesto")) {
			console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			return;
		}
		this.console.mostraMessaggio("Stanza attuale:"+partita.getStanzaCorrente().getDescrizione()+"\n"+partita.getGiocatore());
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			console.mostraMessaggio("Vedi una figura misteriosa nella stanza");
	}
}
