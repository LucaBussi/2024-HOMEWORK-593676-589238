package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Il comando inserito non è valido");
	}
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}
}
