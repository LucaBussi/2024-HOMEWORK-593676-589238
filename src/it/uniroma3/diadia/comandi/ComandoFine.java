package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{
	
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Grazie di aver giocato!");
	}
}
