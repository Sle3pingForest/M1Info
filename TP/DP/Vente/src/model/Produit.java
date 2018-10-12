package model;


public interface Produit {

	public String getName() ;

	public void setName(String name);

	public int getPriceInit() ;

	public void setPriceInit(int priceInit);

	public int getLastPrice() ;

	public void setLastPrice(int lastPrice) ;

	public Bidder getBidder() ;

	public void setBidder(Bidder bidder);
	
	public boolean isEstVendu();

	public void setEstVendu(boolean estVendu);
	
	public Produit getProduit();
	
	public void ajouterArticle(Produit a);
	
	public void reduction();
	
	public int quantite();
	
	public Lieu getLieu();

}
