package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Configuratore;

public class Giocatore {
	static final private int CFU_INIZIALI = Configuratore.getCFU();
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu=CFU_INIZIALI;
		borsa=new Borsa();
	}
	
	public void setCfu(int cfu) {
		this.cfu=cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public String toString() {
		StringBuilder risultato=new StringBuilder();
		risultato.append("\nCFU attuali:"+this.cfu);
		risultato.append("\nStrumenti posseduti:\n");
		for(int i=0; i<this.getBorsa().getNumeroAttrezzi(); i++) {
			risultato.append(this.getBorsa().getAttrezzi(i)+"\n");
		}
		return risultato.toString();
	}
}
