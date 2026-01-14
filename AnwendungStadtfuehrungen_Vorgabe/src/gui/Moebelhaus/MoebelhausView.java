package gui.Moebelhaus;

import business.Moebelstueck.Moebelstueck;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class MoebelhausView {
	
	MoebelhausControl control;
	
    //---Anfang Attribute der grafischen Oberflaeche---
     Pane pane     					= new  Pane();
     Label lblEingabe    	 		= new Label("Eingabe");
     Label lblAnzeige   	 	    	= new Label("Anzeige");
     Label lblName 					= new Label("Name:");
     Label lblWohnraum   		 	= new Label("Wohnraum:");
     Label lblStil  	 				= new Label("Stil:");
     Label lblPreis   				= new Label("Preis:");
     Label lblMaterialien  			= new Label("Materialien:");
     public TextField txtName 	 			= new TextField();
     TextField txtWohnraum			= new TextField();
     TextField txtStil				= new TextField();
     TextField txtPreis				= new TextField();
     TextField txtMaterialien	 	= new TextField();
     TextArea txtAnzeige  			= new TextArea();
     Button btnEingabe 		 		= new Button("Eingabe");
     Button btnAnzeige 		 		= new Button("Anzeige");
     MenuBar mnbrMenuLeiste  		= new MenuBar();
     Menu mnDatei             		= new Menu("Datei");
     MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
     MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
     MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Moebelstueck
    
    public MoebelhausView(Stage primaryStage, MoebelhausControl moebelhausControl){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung eines Moebelstuecks");
    	primaryStage.show();
    	
    	this.control = moebelhausControl;
    	
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblWohnraum.setLayoutX(20);
    	lblWohnraum.setLayoutY(130);
    	lblStil.setLayoutX(20);
    	lblStil.setLayoutY(170);
    	lblPreis.setLayoutX(20);
    	lblPreis.setLayoutY(210);
    	lblMaterialien.setLayoutX(20);
    	lblMaterialien.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblWohnraum, lblStil,
       		lblPreis, lblMaterialien);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtWohnraum.setLayoutX(170);
    	txtWohnraum.setLayoutY(130);
    	txtWohnraum.setPrefWidth(200);
    	txtStil.setLayoutX(170);
    	txtStil.setLayoutY(170);
    	txtStil.setPrefWidth(200);
      	txtPreis.setLayoutX(170);
    	txtPreis.setLayoutY(210);
    	txtPreis.setPrefWidth(200);
    	txtMaterialien.setLayoutX(170);
    	txtMaterialien.setLayoutY(250);
    	txtMaterialien.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtWohnraum, txtStil,
     		txtPreis, txtMaterialien);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    control.nehmeMoebelstueckAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            control.zeigeMoebelstueckAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	public void handle(ActionEvent e) {
	       	 	control.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	control.leseAusDatei("txt");
		    }
    	});
//	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				control.schreibeMoebelstueckeInCsvDatei();
//			}	
//	    });
//	    mnItmTxtImport.setOnAction(e -> {
//	    	control.leseAusDatei("Txt");
//	    });
	    
	    mnItmCsvExport.setOnAction(e -> {
	    	control.schreibeMoebelstueckeInCsvDatei();
	    });;
    }
   
   public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
   public void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }
	

}
