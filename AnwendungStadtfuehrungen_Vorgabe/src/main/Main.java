package main;

import gui.MoebelhausControl;
import gui.Warenuebersicht.WarenuebersichtControl;
import gui.Warenuebersicht.WarenuebersichtView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	// Schrank, Kueche, modern, 449, HolzKunststoff
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelhausControl(primaryStage);
		
		Stage s = new Stage();
		new WarenuebersichtControl(s);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
