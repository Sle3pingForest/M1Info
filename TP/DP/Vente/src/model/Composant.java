package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Composant implements Produit {
	
	
	private String name;
	private int priceInit;
	private int lastPrice;
	private Bidder bidder;
	private boolean estVendu;
	private Lieu lieu;
	
	
	public Composant(String name, int price, Lieu lieu){
		this.name = name;
		this.priceInit = price;
		reduction();
		this.bidder = null;
		this.estVendu = false;
		this.lastPrice = priceInit;
		this.lieu = lieu;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPriceInit() {
		return this.priceInit;
	}

	
	public void setPriceInit(int priceInit) {
		this.priceInit = priceInit;
	}


	public int getLastPrice() {
		return lastPrice;
	}


	public void setLastPrice(int lastPrice) {
		this.lastPrice = lastPrice;
	}


	public Bidder getBidder() {
		return bidder;
	}


	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
	
	public boolean isEstVendu() {
		return estVendu;
	}


	public void setEstVendu(boolean estVendu) {
		this.estVendu = estVendu;
	}


	public ArrayList<Produit> getListProduit() {
		ArrayList<Produit> list = new ArrayList<Produit>();
		list.add(this);
		return list ;
	}

	public void reduction(){
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			setPriceInit(priceInit - priceInit*10/100);
		}
	}


	public void ajouterArticle(Produit a) {
		
	}


	public Produit getProduit() {
		return this;
	}


	public int quantite() {
		return 1;
	}


	public Lieu getLieu() {
		return this.lieu;
	}


}
