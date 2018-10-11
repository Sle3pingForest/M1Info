package model;


public class Huisier {
	
	private String name;
	private Lot lot;
	

	public Huisier(String name, Lot lot){
		this.name = name;
		this.lot = lot;
	}
	
	public Huisier(String name, Produit a){
		this.name = name;
		this.lot = new Lot();
		this.lot.ajouterAticle(a);
	}
	
	public void start(){
		if(!this.lot.isEstVendu()){
			this.lot.setEstVendu(true);
		}
		
	}
	
	public void stop(){
		if(this.lot.isEstVendu()){
			this.lot.setEstVendu(false);
		}
	}
	
	public void changerPrix(int i){
	}
	
	public Produit getLot(){
		return this.lot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
