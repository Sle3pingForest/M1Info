package model;

import java.util.ArrayList;

public class Lot implements Produit {
	
	private ArrayList<Produit> listProduit;
	private int totalLastPrice = 0;
	private int totalPriceInit = 0;
	private Bidder bidder;
	private boolean estVendu;

	public Lot(){
		listProduit = new ArrayList<Produit>();
		this.totalLastPrice = 0;
		this.totalPriceInit = 0;
		this.bidder = null;
	}
	
	public void ajouterAticle( Produit p){
		this.listProduit.add(p);
		for(Produit a: listProduit){
			totalPriceInit += a.getPriceInit();
		}
		this.totalLastPrice = totalPriceInit;
	}
	
	public String getName() {
		StringBuilder sb = new StringBuilder("");
		for( Produit p : listProduit){
			sb.append(((Article)p).getName() + " ");
		}
		return sb.toString();
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public int getPriceInit() {
		return this.totalPriceInit;
	}

	public void setPriceInit(int priceInit) {
		// TODO Auto-generated method stub
		
	}

	public int getLastPrice() {
		return totalLastPrice;
	}

	public void setLastPrice(int totalLastPrice) {
		this.totalLastPrice = totalLastPrice;
		
	}

	public Bidder getBidder() {
		return this.bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
		
	}
	
	public boolean isEstVendu() {
		return this.estVendu;
	}

	public void setEstVendu(boolean estVendu) {
		this.estVendu = estVendu;
		
	}
	
	public ArrayList<Produit> getListProduit(){
		return this.listProduit;
	}


}
