package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoRegala extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		if(this.parametro==null) {
			this.console.mostraMessaggio("Scegli un oggetto da regalare");
			for(int i=0; i<partita.getGiocatore().getBorsa().getNumeroAttrezzi(); i++) {
				this.console.mostraMessaggio(partita.getGiocatore().getBorsa().getAttrezzi(i));
			}
			this.parametro=this.console.leggiRiga();
		}
		if(partita.getGiocatore().getBorsa().hasAttrezzo(this.parametro)) {
			this.console.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro), partita));
		}
		else {
			this.console.mostraMessaggio("Non possiedi "+parametro);
		}
	}
}
