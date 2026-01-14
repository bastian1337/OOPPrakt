package business.Dekoration;

public class Dekoration {
	
	private String name;
	private String form;
	private int kosten;
	
	public Dekoration(String name, String form, int kosten) {
		super();
		this.name = name;
		this.form = form;
		this.kosten = kosten;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public int getKosten() {
		return kosten;
	}
	public void setKosten(int kosten) {
		this.kosten = kosten;
	}
	
	public String gibDekorationZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getName() + trenner
  			+ this.getForm() + trenner
  		    + this.getKosten() + trenner + "\n";
  		}
	

}
