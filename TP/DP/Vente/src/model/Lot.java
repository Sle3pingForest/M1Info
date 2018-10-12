package model;

import java.util.ArrayList;

public class Lot implements Produit {
	
	private ArrayList<Produit> listProduit;//contient elle meme une list de produit
	
	
	
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
	
	public void ajouterArticle(Produit p){
		this.listProduit.add(p);
		for(Produit a: listProduit){
			totalPriceInit += a.getPriceInit();
		}

		reduction();
		this.totalLastPrice = totalPriceInit;
	}
	
	
	public void reduction(){
		if(listProduit.size() == 2){
			setPriceInit(totalPriceInit - totalPriceInit*10/100);
		}
		if(listProduit.size() == 3){
			setPriceInit(totalPriceInit - totalPriceInit*40/100);
		}
		
	}
	
	public String getName() {
		StringBuilder sb = new StringBuilder("");
		for( Produit p : listProduit){
			sb.append(((Composant)p).getName() + " ");
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
		this.totalPriceInit = priceInit;
		
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


	public Produit getProduit() {
		// TODO Auto-generated method stub
		return null;
	}

	public int quantite() {
		return this.listProduit.size();
	}

	public Lieu getLieu() {
		return this.getListProduit().get(0).getLieu();
	}


}
