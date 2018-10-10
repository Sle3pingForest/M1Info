package model;

import java.util.ArrayList;
import java.util.Observable;

public class Vente extends Observable  {
	
	private Bidder bidder;
	private Huisier huisier;
	private Article article;
	
	public ArrayList<Integer> historiqueEnchere;
	
	
	public Vente(Huisier h, Bidder b){
		this.bidder = b;
		this.huisier = h;
		this.article = h.getArticleEnVendre();
		this.historiqueEnchere = new ArrayList<>();
		this.historiqueEnchere.add(this.article.getPriceInit());
	}
	
	public void stop(){
		this.huisier.stop();
		this.article.setBidder(bidder);
		setChanged();
		notifyObservers();
	}
	
	public void start(){
		this.huisier.start();
		setChanged();
		notifyObservers();
	}
	
	public void augmenterPrice(int i){
		if(this.article != null && i > this.article.getLastPrice()){
			this.article.setLastPrice(i);
		}
		setChanged();
		notifyObservers();
	}
	
	public Article getArticle(){
		return this.article;
	}
 
	public void ajouterAuHistorique(int i){
		this.historiqueEnchere.add(i);
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

	public ArrayList<Integer> getHistoriqueEnchere() {
		return historiqueEnchere;
	}

	public void setHistoriqueEnchere(ArrayList<Integer> historiqueEnchere) {
		this.historiqueEnchere = historiqueEnchere;
	}
	
}
