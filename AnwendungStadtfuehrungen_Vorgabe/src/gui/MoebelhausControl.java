package gui;

import business.MoebelhausModel;
import business.Moebelstueck;
import javafx.stage.Stage;

public class MoebelhausControl {
	
	MoebelhausView view;
	MoebelhausModel model;
	
	public MoebelhausControl(Stage stage) {
		this.view = new MoebelhausView(stage, this);
		this.model = new MoebelhausModel();
	}
	
	
    public void nehmeMoebelstueckAuf(){
    	try{ 
    		model.setMoebelstueck(new Moebelstueck(
        			view.txtName.getText(), 
       	            view.txtWohnraum.getText(),
       	            view.txtStil.getText(),
       	            Float.parseFloat(view.txtPreis.getText()),
        		    view.txtMaterialien.getText().split(";")));
    		
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    public void zeigeMoebelstueckAn(){
    	if(model.getMoebelstueck() != null){
    		view.txtAnzeige.setText(
    			model.getMoebelstueck().gibMoebelstueckZurueck(' '));
    	}
    	else{
    		view.zeigeInformationsfensterAn("Bisher wurde keine Moebelstueck aufgenommen!");
    	}
    }


	public void leseAusDatei(String string) {

		try {
			model.leseAusDatei(string);
			view.zeigeInformationsfensterAn("Gelesen!");
		} catch (Exception e) {
			view.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
		}
	}


	public void schreibeMoebelstueckeInCsvDatei() {
		try {
			model.schreibeMoebelstueckeInCsvDatei();
			view.zeigeInformationsfensterAn("Geschrieben!");
		} catch (Exception e) {
			view.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
		}
	} 

}
