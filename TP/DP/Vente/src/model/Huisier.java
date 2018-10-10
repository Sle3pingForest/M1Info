package model;

import java.util.ArrayList;

public class Huisier {
	
	private String name;
	private ArrayList<Article> listeArticles;
	private Article articleEnCours;
	
	public Huisier(){
		this.name = "Vendeur";
		this.listeArticles = new ArrayList<Article>();
	}
	
	public Huisier(String name, Article article){
		this.name = name;
		this.listeArticles = new ArrayList<Article>();
		this.articleEnCours = article;
		this.listeArticles.add(articleEnCours);
	}
	
	public void start(){
		if(!this.articleEnCours.isEstVendu()){
			this.articleEnCours.setEstVendu(true);
		}
		
	}
	
	public void stop(){
		if(this.articleEnCours.isEstVendu()){
			this.articleEnCours.setEstVendu(false);
		}
	}
	
	public void changerPrix(int i){
	}
	
	public Article getArticleEnVendre(){
		return this.articleEnCours;
	}
	
	public void ajouterArticlePourVendre(Article a){
		this.listeArticles.add(a);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
