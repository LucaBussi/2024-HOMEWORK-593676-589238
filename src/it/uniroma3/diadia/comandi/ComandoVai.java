package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		Direzione dir=Direzione.valueOf(parametro);
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.parametro==null) {
			this.console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		if(stanzaCorrente==stanzaCorrente.getStanzaAdiacente(dir)) {
			this.console.mostraMessaggio("Questa direzione è bloccata, ti serve una chiave");
		}
		else {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(dir);
			if(prossimaStanza==null) {
				this.console.mostraMessaggio("Direzione inesistente");
				return;
			}
			partita.setStanzaCorrente(prossimaStanza);
			this.console.mostraMessaggio(partita.getStanzaCorrente().getNome());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
	}
}
