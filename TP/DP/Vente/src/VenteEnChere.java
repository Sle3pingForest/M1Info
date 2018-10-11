import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


import model.Article;
import model.Bidder;
import model.Huisier;
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
		
		/*JPanel principal = new JPanel();
		principal.add(vb);*/
        
        /*// second windows
        JFrame frame = new JFrame();
		this.setPreferredSize(new Dimension(900, 600)) ;
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ViewSciencetifique v2 = new ViewSciencetifique(cal);

		JPanel second = new JPanel();
		second.add(v2,BorderLayout.EAST);

		frame.add(second);
        frame.pack();
        frame.setVisible(true);*/
		
	}


	public static void main(String[] args) {

			Article article = new Article("Epe", 100);
			Article article1 = new Article("Armure", 80);
			Article article2 = new Article("Casque", 50);
			
			Lot lots = new Lot();
			lots.ajouterAticle(article);
			lots.ajouterAticle(article1);
			lots.ajouterAticle(article2);
			
			Bidder b = new Bidder("andre");
			Huisier h = new Huisier("nam", article1);
			
			new VenteEnChere(h,b);
			
	}
}
