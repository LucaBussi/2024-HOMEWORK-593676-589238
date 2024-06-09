package it.uniroma3.diadia.personaggi;

import java.util.List;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	private static final String MESSAGGIO_PERMALOSO="Questa è la punizione per avermi ignorata!";
	private static final String MESSAGGIO_GRAZIE="Sei stato carino, quindi non ti trasformerò in una rana per oggi.";
	private static final String MESSAGGIO_MALVAGIO="Sei proprio ingenuo, ahahahahahahah";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	public String agisci(Partita partita) {
		String msg;
		List<Stanza> app=partita.getStanzaCorrente().getStanzeOrdinatePerNumeroAttrezzi();
		if(!this.haSalutato()) {
			partita.setStanzaCorrente(app.get(app.size()-1));
			msg=MESSAGGIO_PERMALOSO;
		} else {
			partita.setStanzaCorrente(app.get(0));
			msg=MESSAGGIO_GRAZIE;
		}
		return msg;
	}

	@Override
	public String reagisciRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_MALVAGIO;
	}
}
