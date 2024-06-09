package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private Direzione direzioneBloccata;
	private String chiave;
	
	public StanzaBloccata(String nome, String chiave, Direzione direzioneBloccata) {
		super(nome);
		this.chiave=chiave;
		this.direzioneBloccata=direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
		if(dir.equals(direzioneBloccata)&&!super.hasAttrezzo(chiave)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		return super.getDescrizione()+" Direzione bloccata: "+this.direzioneBloccata+"; ti serve "+this.chiave;
	}
}
