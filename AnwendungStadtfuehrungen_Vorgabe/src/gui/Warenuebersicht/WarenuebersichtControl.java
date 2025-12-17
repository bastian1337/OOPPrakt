package gui.Warenuebersicht;
import business.MoebelhausModel;
import javafx.stage.Stage;


public class WarenuebersichtControl {	
	private WarenuebersichtView
 		warenuebersichtView;
	private MoebelhausModel moebelModel;
	public WarenuebersichtControl(Stage primaryStage){
 		this.moebelModel = MoebelhausModel.getInstance(); 		
		this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			moebelModel);
	}
}


