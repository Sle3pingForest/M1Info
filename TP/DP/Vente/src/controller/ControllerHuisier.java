package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import model.Vente;

public class ControllerHuisier implements ActionListener {

	private Vente vente;
	
	public ControllerHuisier(Vente vente){
		this.vente = vente;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!this.vente.getArticle().isEstVendu()){
			this.vente.start();
		}
		else{
			this.vente.stop();
			final File fichier =new File("logger.txt"); 
	        try {
	        	if(!fichier.exists()){
	                fichier .createNewFile();
	        	}
        		FileWriter writer = new FileWriter(fichier, true);
	            try {
	            	for(Integer i : this.vente.getHistoriqueEnchere()){
		                writer.write("Auction "+ this.vente.getHuisier().getName() +" for " + this.vente.getArticle().getName()+ " Bid= "+ i +"\n");
	            	}
	            } finally {
	                writer.close();
	            }
	        	
	            
	        } catch (Exception e1) {
	            System.out.println("Impossible de creer le fichier");
	        }
		}
		
	}

}
