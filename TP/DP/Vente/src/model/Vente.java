package model;

import java.util.Observable;

public class Vente extends Observable  {
	
	private Bidder bidder;
	private Huisier huisier;
	private Article article;
	
	
	public Vente(Huisier h, Bidder b){
		this.bidder = b;
		this.huisier = h;
		System.out.println(h.getArticleEnVendre());
		this.article = h.getArticleEnVendre();
	}
	
	public void stop(){
		this.huisier.stop();
		this.article.setBidder(bidder);
		setChanged();
		notifyObservers();
	}
	
	public void start(){
		this.huisier.start();
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
 
}
