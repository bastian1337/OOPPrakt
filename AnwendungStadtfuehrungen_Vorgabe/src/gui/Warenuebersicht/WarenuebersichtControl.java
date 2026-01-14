package gui.Warenuebersicht;
import java.io.IOException;

import business.Dekoration.DekorationModel;
import business.Moebelstueck.MoebelhausModel;
import javafx.stage.Stage;


public class WarenuebersichtControl {	
	private WarenuebersichtView warenuebersichtView;
	private MoebelhausModel moebelModel;
	private DekorationModel dekoModel;
	
	
	public WarenuebersichtControl(Stage primaryStage){
 		this.moebelModel = MoebelhausModel.getInstance(); 
		this.dekoModel = DekorationModel.getInstance();
		this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			moebelModel, dekoModel);
	}
	
	public void leseDekorationAusCsvDatei() {
		try {
			this.dekoModel.leseDekorationAusCsvDatei();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


