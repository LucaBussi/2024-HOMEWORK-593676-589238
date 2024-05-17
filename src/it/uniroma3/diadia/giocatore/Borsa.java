package it.uniroma3.diadia.giocatore;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo))
			return this.attrezzi.get(nomeAttrezzo);
		return null;
	}
	
	public int getPeso() {
		int peso = 0;
		Set<String> attrezzi=this.attrezzi.keySet();
		for (String s : attrezzi)
			peso += this.attrezzi.get(s).getPeso();

		return peso;
	}
	
	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo))
			return this.attrezzi.remove(nomeAttrezzo);
		return null;
	}
	
	public String getAttrezzi(int i) {
		return attrezzi.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		final List<Attrezzo> ordinata = new ArrayList<Attrezzo>(this.attrezzi.values());
		final ComparatoreAttrezziPerPeso comp=new ComparatoreAttrezziPerPeso();
		Collections.sort(ordinata, comp);
		
		return ordinata;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatoreAttrezziPerNome cmp=new ComparatoreAttrezziPerNome();
		final SortedSet<Attrezzo> ordinata=new TreeSet<Attrezzo>(cmp);
		ordinata.addAll(this.attrezzi.values());
		
		return ordinata;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> peso2attrezzi=new HashMap<Integer, Set<Attrezzo>>();
		Set<String> attrezzi=this.attrezzi.keySet();
		for(String s: attrezzi) {
			if(!peso2attrezzi.containsKey(this.attrezzi.get(s).getPeso())) {
				Set<Attrezzo> nuovoSet=new HashSet<Attrezzo>();
				nuovoSet.add(this.attrezzi.get(s));
				peso2attrezzi.put(this.attrezzi.get(s).getPeso(), nuovoSet);
			}
			else {
				Set<Attrezzo> stessoPeso=peso2attrezzi.get(this.attrezzi.get(s).getPeso());
				stessoPeso.add(this.attrezzi.get(s));
			}
		}
		return peso2attrezzi;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezziPerPeso cmp=new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> ordinata=new TreeSet<Attrezzo>(cmp);
		ordinata.addAll(this.attrezzi.values());
		return ordinata;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.size(); i++)
				s.append(attrezzi.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}

