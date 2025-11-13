package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProduct extends ReaderProduct {


	BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
  			ein = new BufferedReader(new FileReader("Moebelstueck.csv"));
  			String[] zeile = ein.readLine().split(";");

  			return zeile;
  		
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}



