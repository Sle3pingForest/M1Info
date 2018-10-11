package model;

import java.util.ArrayList;
import java.util.Observable;

public class Vente extends Observable  {
	
	private Bidder bidder;
	private Huisier huisier;
	private Produit lot;
	
	public ArrayList<String> historiqueEnchere;
	
	
	public Vente(Huisier h, Bidder b){
		this.bidder = b;
		this.huisier = h;
		this.historiqueEnchere = new ArrayList<>();
		this.lot = h.getLot();
	}
	
	public void stop(){
		this.huisier.stop();
		this.lot.setBidder(bidder);
		setChanged();
		notifyObservers();
	}
	
	public void start(){
		this.huisier.start();
		setChanged();
		notifyObservers();
	}
	
	public void augmenterPrice(int d){
		if(this.lot != null && d > this.lot.getLastPrice()){
			this.lot.setLastPrice(d);
		}
		setChanged();
		notifyObservers();
	}
	
	public Produit getLot(){
		return this.lot;
	}
 
	public void ajouterAuHistorique(String s){
		this.historiqueEnchere.add(s);
	}
	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public Huisier getHuisier() {
		return huisier;
	}

	public void setHuisier(Huisier huisier) {
		this.huisier = huisier;
	}

	public ArrayList<String> getHistoriqueEnchere() {
		return historiqueEnchere;
	}

	public void setHistoriqueEnchere(ArrayList<String> historiqueEnchere) {
		this.historiqueEnchere = historiqueEnchere;
	}
	
}
