package model;

import java.util.ArrayList;

public class Article implements Produit {
	private String name;
	private int priceInit;
	private int lastPrice;
	private Bidder bidder;
	private boolean estVendu;
	
	
	public Article(String name, int price){
		this.name = name;
		this.priceInit = price;
		this.bidder = null;
		this.estVendu = false;
		this.lastPrice = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPriceInit() {
		return priceInit;
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


	@Override
	public ArrayList<Produit> getListProduit() {
		// TODO Auto-generated method stub
		return null;
	}


}
