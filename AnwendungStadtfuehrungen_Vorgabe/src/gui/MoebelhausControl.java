package gui;

import business.MoebelhausModel;
import business.Moebelstueck;
import gui.Warenuebersicht.WarenuebersichtView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class MoebelhausControl implements Observer {
	
	MoebelhausView view;
	MoebelhausModel model;
		
	public MoebelhausControl(Stage stage) {
		this.view = new MoebelhausView(stage, this);
		this.model = MoebelhausModel.getInstance();
		model.addObserver(this);
	}
	
	
    public void nehmeMoebelstueckAuf(){
    	try{ 
    		model.addMoebelstueck(new Moebelstueck(
        			view.txtName.getText(), 
       	            view.txtWohnraum.getText(),
       	            view.txtStil.getText(),
       	            Float.parseFloat(view.txtPreis.getText()),
        		    view.txtMaterialien.getText().split(";")));
    		view.zeigeInformationsfensterAn("Aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    public void zeigeMoebelstueckAn(){

    				model.notifyObservers();
    			}
    	
    	
    


	public void leseAusDatei(String typ) {

		try {
			switch(typ) {
				case "csv":
					model.leseAusCsvDatei();
					view.zeigeInformationsfensterAn("CSV Gelesen!");
    				model.notifyObservers();
					break;
				case "txt":
					model.leseAusTxtDatei();
					view.zeigeInformationsfensterAn("TXT Gelesen!");
    				model.notifyObservers();
					break;
			}
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


	@Override
	public void update() {
		
    	if(model.getMoebelstuecke() != null){
			for(Moebelstueck m : model.getMoebelstuecke()) {
				view.txtAnzeige.appendText(
		    			m.gibMoebelstueckZurueck(' '));
			}
		
	} else{
		view.zeigeInformationsfensterAn("Bisher wurde keine Moebelstueck aufgenommen!");
	}
	}
}
