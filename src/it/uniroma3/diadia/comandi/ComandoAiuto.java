package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "interagisci", "saluta", "regala"};
	
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.console.mostraMessaggio(elencoComandi[i]+" ");
	}
}
