package model;

import java.util.Observable;

public class Vente extends Observable  {
	
	private Bidder bidder;
	private Huisier huisier;
	
	
	
	public Vente(Huisier h, Bidder b){
		this.bidder = b;
		this.huisier = h;
	}
	
	public void stop(){
		this.huisier.stop();
		this.huisier.getLot().setBidder(bidder);
		setChanged();
		notifyObservers();
	}
	
	public void start(){
		this.huisier.start();
		setChanged();
		notifyObservers();
	}
	
	public void augmenterPrice(int d){
		if(this.huisier.getLot() != null && d > this.huisier.getLot().getLastPrice()){
			this.huisier.getLot().setLastPrice(d);
		}
		setChanged();
		notifyObservers();
	}
	
	public Produit getProduit(){
		return this.huisier.getLot();
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


	
}
