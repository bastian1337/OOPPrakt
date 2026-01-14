package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Moebelstueck.Moebelstueck;

public class ConcreteTxtReaderProduct extends ReaderProduct {

	BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
  			ein = new BufferedReader(new FileReader("Moebelstueck.txt"));
  			String[] zeile = ein.readLine().split(";");
//  			this.moebelstueck = new Moebelstueck(zeile[0], 
//  				zeile[1], 
//  				zeile[2], 
//  				Float.parseFloat(zeile[3]), 
//  				zeile[4].split("_"));
//  				ein.close();
  			return zeile;
  		
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}
