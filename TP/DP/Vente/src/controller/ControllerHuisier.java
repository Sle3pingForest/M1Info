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
		if(!this.vente.getLot().isEstVendu()){
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
	            	for(String s : this.vente.getHistoriqueEnchere()){
		                writer.write(s + "\n");
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
