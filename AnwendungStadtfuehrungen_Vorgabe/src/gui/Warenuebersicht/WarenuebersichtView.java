package gui.Warenuebersicht;
   
import business.Dekoration.Dekoration;
import business.Dekoration.DekorationModel;
import business.Moebelstueck.MoebelhausModel;
import business.Moebelstueck.Moebelstueck;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WarenuebersichtView implements Observer {
	
private WarenuebersichtControl warenuebersichtControl;
private MoebelhausModel moebelModel;	
private DekorationModel dekoModel;


    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeMoebel  = new Label("Anzeige M�belst�cke");
    	
    	private Label lblAnzeigeDeko = new Label("Anzeige Dekoration");

    	
    	public TextArea txtAnzeigeMoebel  = new TextArea();
    	
    	public TextArea txtAnzeigeDeko  = new TextArea();
    	
    	private Button btnAnzeigeMoebel = new Button("Anzeige");
    	
    	private Button btnAnzeigeDeko = new Button("Anzeige Deko");
    	
    	private MenuBar menuBar = new MenuBar();
    	private Menu menuDatei = new Menu("Datei");
    	private MenuItem itemImport = new MenuItem("csv-Import Deko");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public WarenuebersichtView(
 		WarenuebersichtControl 
 		warenuebersichtControl, 
   	 	Stage primaryStage, 
 		MoebelhausModel moebelModel,
 		DekorationModel dekoModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige der Warenuebersicht");
    		primaryStage.show();
    		this.warenuebersichtControl 
 			= warenuebersichtControl;
 		this.moebelModel = moebelModel;
 		this.dekoModel = dekoModel;
 		this.initKomponenten();
		this.initListener();
		this.moebelModel.addObserver(this);
    	}

 	private void initKomponenten(){
 		menuDatei.getItems().add(itemImport);
 	    menuBar.getMenus().add(menuDatei);

 	    menuBar.setLayoutX(0);
 	    menuBar.setLayoutY(0);
 	    menuBar.setPrefWidth(560); 

 	    initKomponentenDeko();
 	    initKomponentenMoebel();
 	    
 	    pane.getChildren().add(menuBar);
 	   	pane.getChildren().addAll(lblAnzeigeMoebel, lblAnzeigeDeko);           
 	   	pane.getChildren().addAll(txtAnzeigeMoebel, txtAnzeigeDeko);           
 	   	pane.getChildren().addAll(btnAnzeigeMoebel, btnAnzeigeDeko);           

    }
 	
 	private void initKomponentenMoebel() {
		// Label
		Font font = new Font("Arial", 20);
   	lblAnzeigeMoebel.setLayoutX(310);
		lblAnzeigeMoebel.setLayoutY(40);
		lblAnzeigeMoebel.setFont(font);
		lblAnzeigeMoebel.setStyle("-fx-font-weight: bold;"); 
//Textbereich	
    	txtAnzeigeMoebel.setEditable(false);
 		txtAnzeigeMoebel.setLayoutX(310);
		txtAnzeigeMoebel.setLayoutY(90);
 		txtAnzeigeMoebel.setPrefWidth(220);
		txtAnzeigeMoebel.setPrefHeight(185);
    	// Button
      	btnAnzeigeMoebel.setLayoutX(310);
    	btnAnzeigeMoebel.setLayoutY(290);
 	}
 	
 	private void initKomponentenDeko() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeDeko.setLayoutX(20);
		lblAnzeigeDeko.setLayoutY(40);
		lblAnzeigeDeko.setFont(font);
		lblAnzeigeDeko.setStyle("-fx-font-weight: bold;"); 
		//Textbereich	
    	txtAnzeigeDeko.setEditable(false);
 		txtAnzeigeDeko.setLayoutX(10);
		txtAnzeigeDeko.setLayoutY(90);
 		txtAnzeigeDeko.setPrefWidth(220);
		txtAnzeigeDeko.setPrefHeight(185);
    	// Button
      	btnAnzeigeDeko.setLayoutX(20);
    	btnAnzeigeDeko.setLayoutY(290);
 	}
   
   private void initListener() {
//	    btnAnzeigeMoebel.setOnAction(
// 			new EventHandler<ActionEvent>() {
//	    		@Override
//	        	public void handle(ActionEvent e) {
//	            	zeigeMoebelAn();
//	        	} 
//   	    });
	    btnAnzeigeMoebel.setOnAction(e -> zeigeMoebelAn());
	    btnAnzeigeDeko.setOnAction(e -> zeigeDekoAn());
	    
	    
	    itemImport.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	            warenuebersichtControl.leseDekorationAusCsvDatei();
	            zeigeDekoAn();
	        }
	    });

    }
   
    public void zeigeMoebelAn(){
    		if(moebelModel.getMoebelstuecke() != null){
    			for(Moebelstueck m : moebelModel.getMoebelstuecke()) {
    				txtAnzeigeMoebel.appendText(
    	    				m
    	 				.gibMoebelstueckZurueck(' '));
    			}
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Moebelst�ck aufgenommen!");
    		}
    }
    
    public void zeigeDekoAn(){
//    	warenuebersichtControl.leseDekorationAusCsvDatei();
		if(dekoModel.getDekorationen() != null){
			txtAnzeigeDeko.clear();
			for(Dekoration d : dekoModel.getDekorationen()) {
				txtAnzeigeDeko.appendText(
	    				d
	 				.gibDekorationZurueck(' '));
			}
		}
		else{
			zeigeInformationsfensterAn(
				"Bisher wurde kein Moebelst�ck aufgenommen!");
		}
}
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(moebelModel.getMoebelstuecke() != null){
			txtAnzeigeMoebel.clear();
			for(Moebelstueck m : moebelModel.getMoebelstuecke()) {

				txtAnzeigeMoebel.appendText(
		    			m.gibMoebelstueckZurueck(' '));
			}
		
	} else{
		zeigeInformationsfensterAn("Bisher wurde keine Moebelstueck aufgenommen!");
	}

	}	
	
	   

    
}
