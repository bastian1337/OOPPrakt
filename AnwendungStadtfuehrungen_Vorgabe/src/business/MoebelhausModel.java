package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import factory.ConcreteCsvReaderCreator;
import factory.ConcreteTxtReaderCreator;
import factory.ReaderCreator;
import factory.ReaderProduct;

public class MoebelhausModel {
	
    private Moebelstueck moebelstueck;

	public Moebelstueck getMoebelstueck() {
		return moebelstueck;
	}

	public void setMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstueck = moebelstueck;
	}
    
		


	public void schreibeMoebelstueckeInCsvDatei()  throws IOException {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
			aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
			aus.close();
	}
	
	public void leseAusTxtDatei() throws IOException {
		ReaderCreator rc = new ConcreteTxtReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] inhalt = rp.leseAusDatei();
		this.moebelstueck = new Moebelstueck(inhalt[0], 
				inhalt[1], 
				inhalt[2], 
				Float.parseFloat(inhalt[3]), 
				inhalt[4].split("_"));
		rp.schliesseDatei();
	}
	
	public void leseAusCsvDatei() throws IOException {
		ReaderCreator rc = new ConcreteCsvReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] inhalt = rp.leseAusDatei();
		this.moebelstueck = new Moebelstueck(inhalt[0], 
				inhalt[1], 
				inhalt[2], 
				Float.parseFloat(inhalt[3]), 
				inhalt[4].split("_"));
		rp.schliesseDatei();
	}
}
