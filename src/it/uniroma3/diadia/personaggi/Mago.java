package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private boolean ricevutoRegalo;
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Non dubito della tua dote, ma le mie tasche ora son vuote.";
	private static final String MESSAGGIO_REGALO= "Un regalo molto apprezzato, il suo peso è ora dimezzato!";
	private static final String MESSAGGIO_NONMODIFICATO="Sono alquanto desolato, ma il mio potere è limitato";
	
	
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
		this.ricevutoRegalo=false;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String reagisciRegalo(Attrezzo attrezzo, Partita partita) {
		String msg=null;
		if(this.ricevutoRegalo==false) {
			Attrezzo modificato=new Attrezzo(this.regalo, this.pesoRegalo/2);
			partita.getStanzaCorrente().addAttrezzo(modificato);
			this.regalo=null;
			this.pesoRegalo=0;
			this.ricevutoRegalo=true;
			msg=MESSAGGIO_REGALO;
		}
		else {
			msg=MESSAGGIO_NONMODIFICATO;
		}
		return msg;
	}


}