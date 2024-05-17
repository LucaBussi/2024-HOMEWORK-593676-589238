package test;

import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class Fixture {
	public IOSimulator testPartitaEasy(List<String> comandi) {
		IOSimulator io=new IOSimulator(comandi);
		Labirinto lab=new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("spada", 3)
				.addStanzaVincente("biblioteca")
				.addAdiacenza("atrio", "biblioteca", "nord")
				.getLabirinto();
		DiaDia gioco=new DiaDia(io, lab);
		gioco.gioca();
		return io;
	}
	
	public IOSimulator testPartitaMid(List<String> comandi) {
		IOSimulator io=new IOSimulator(comandi);
		Labirinto lab=new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addStanzaVincente("biblioteca")
				.addStanza("n10")
				.addAttrezzo("mazza", 4)
				.addStanza("n11")
				.addStanza("n9")
				.addAttrezzo("teschio", 2)
				.addAdiacenza("atrio", "n10", "nord")
				.addAdiacenza("n10", "atrio", "sud")
				.addAdiacenza("n10", "n11", "est")
				.addAdiacenza("n11", "n10",  "ovest")
				.addAdiacenza("n10", "n9", "ovest")
				.addAdiacenza("n9", "n10", "est")
				.addAdiacenza("n9", "biblioteca", "nord")
				.getLabirinto();
		DiaDia gioco=new DiaDia(io, lab);
		gioco.gioca();
		return io;
	}
	
	public IOSimulator testPartitaHard(List<String> comandi) {
		IOSimulator io=new IOSimulator(comandi);
		Labirinto lab=new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("chiave", 1)
				.addStanzaVincente("biblioteca")
				.addStanzaBloccata("n10", "est", "chiave")
				.addAttrezzo("mazza", 4)
				.addStanza("n11")
				.addAttrezzo("torcia", 1)
				.addStanzaBuia("n9", "torcia")
				.addAttrezzo("teschio", 2)
				.addAdiacenza("atrio", "n10", "nord")
				.addAdiacenza("n10", "atrio", "sud")
				.addAdiacenza("n10", "n11", "est")
				.addAdiacenza("n11", "n10",  "ovest")
				.addAdiacenza("n10", "n9", "ovest")
				.addAdiacenza("n9", "n10", "est")
				.addAdiacenza("n9", "biblioteca", "nord")
				.getLabirinto();
		DiaDia gioco=new DiaDia(io, lab);
		gioco.gioca();
		return io;
	}
}
