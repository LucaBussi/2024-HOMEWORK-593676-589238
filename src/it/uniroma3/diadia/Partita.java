package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Giocatore giocatore;
	private Labirinto labirinto;
	private boolean finita;	
	private Stanza stanzaCorrente;
	
	public Partita(){
		giocatore=new Giocatore();
		labirinto=new Labirinto();
		this.finita = false;
		this.stanzaCorrente=this.labirinto.getStanzaIniziale();
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza s) {
		this.stanzaCorrente=s;
	}
	
	public boolean giocatoreIsVivo() {
		return this.getGiocatore().getCfu()!=0;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente == this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
}