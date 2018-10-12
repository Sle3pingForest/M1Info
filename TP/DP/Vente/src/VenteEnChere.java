import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


import model.Composant;
import model.Bidder;
import model.Huisier;
import model.Lieu;
import model.Lot;
import model.Vente;
import view.ViewBidder;
import view.ViewHuisier;


public class VenteEnChere {
	
	public VenteEnChere(Huisier h, Bidder b){
		Vente vente = new Vente(h,b);
		
		ViewHuisier vh = new ViewHuisier(vente);
		ViewBidder vb = new ViewBidder(vente);
		ViewBidder vb2 = new ViewBidder(vente);
		
	}


	public static void main(String[] args) {
		
			Lieu nancy = new Lieu("Nancy");
		
			Composant article = new Composant("Epe", 100, nancy);
			Composant article1 = new Composant("Armure",150, nancy);
			Composant article2 = new Composant("Casque",20, nancy);
			

			Composant article5 = new Composant("PC",1500, nancy);
			
			Lot lots = new Lot();
			lots.ajouterArticle(article);
			lots.ajouterArticle(article1);
			lots.ajouterArticle(article2);
			

			Lot lots2 = new Lot();
			lots2.ajouterArticle(article1);
			lots2.ajouterArticle(article2);
			
			Bidder b = new Bidder("andre");
			Huisier h = new Huisier("nam", article5);
			Huisier h2 = new Huisier("nam", lots2);
			
			new VenteEnChere(h,b);
			
			new VenteEnChere(h2, b);
			
	}
}
