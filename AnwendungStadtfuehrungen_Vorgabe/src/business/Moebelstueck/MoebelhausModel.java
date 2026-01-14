package business.Moebelstueck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import factory.ConcreteCsvReaderCreator;
import factory.ConcreteTxtReaderCreator;
import factory.ReaderCreator;
import factory.ReaderProduct;
import ownUtil.Observable;
import ownUtil.Observer;

public class MoebelhausModel implements Observable {
	
    private ArrayList<Moebelstueck> moebelstuecke = new ArrayList<>();
    private static MoebelhausModel instance;
    
    private ArrayList<Observer> observers = new ArrayList<>();

	public ArrayList<Moebelstueck> getMoebelstuecke() {
		return moebelstuecke;
	}

	public void addMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstuecke.add(moebelstueck);
		notifyObservers();
	}
	
	private MoebelhausModel() {}
	
	public static MoebelhausModel getInstance() {
		if(instance==null) {
			instance = new MoebelhausModel();
		}
		
		return instance;
	}
    
		


	public void schreibeMoebelstueckeInCsvDatei()  throws IOException {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
			for(Moebelstueck m : moebelstuecke) {
				aus.write(m.gibMoebelstueckZurueck(';'));
			}
			aus.close();
	}
	
	public void leseAusTxtDatei() throws IOException {
		ReaderCreator rc = new ConcreteTxtReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] inhalt = rp.leseAusDatei();
		this.moebelstuecke.add(new Moebelstueck(inhalt[0], 
				inhalt[1], 
				inhalt[2], 
				Float.parseFloat(inhalt[3]), 
				inhalt[4].split("_")));
		rp.schliesseDatei();
		notifyObservers();
	}
	
	public void leseAusCsvDatei() throws IOException {
		ReaderCreator rc = new ConcreteCsvReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] inhalt = rp.leseAusDatei();
		this.moebelstuecke.add(new Moebelstueck(inhalt[0], 
				inhalt[1], 
				inhalt[2], 
				Float.parseFloat(inhalt[3]), 
				inhalt[4].split("_")));
		rp.schliesseDatei();
		notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o : observers) {
			o.update();
		}
	}
}
