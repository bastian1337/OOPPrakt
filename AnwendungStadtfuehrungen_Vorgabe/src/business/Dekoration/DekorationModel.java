package business.Dekoration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DekorationModel {
	
	private ArrayList<Dekoration> dekorationen = new ArrayList<Dekoration>();
	private static DekorationModel instanz = null;
	
	public static DekorationModel getInstance() {
		if(instanz==null) {
			instanz = new DekorationModel();
		}
		
		return instanz;
	}
	
	private DekorationModel() {}
	
	public void leseDekorationAusCsvDatei() throws IOException {
		BufferedReader ein = new BufferedReader(new FileReader("Dekoration.csv"));
		String zeile;
		
		while((zeile = ein.readLine()) != null) {
			String[] line = zeile.split(";");
			this.fuegeDekorationZu(new Dekoration(line[0], line[1], Integer.parseInt(line[2])));
		}
		
		ein.close();
	}
	
	public void fuegeDekorationZu(Dekoration deko) {
		this.dekorationen.add(deko);
	}
	
	public ArrayList<Dekoration> getDekorationen() {
		return this.dekorationen;
	}
}
