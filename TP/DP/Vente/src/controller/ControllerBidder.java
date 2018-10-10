package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JTextField;

import model.Vente;

public class ControllerBidder implements ActionListener {
	
	private Vente vente; 
	private JTextField text;
	
	public ControllerBidder(Vente vente, JTextField text){
		this.vente = vente;
		this.text = text;
	}

	public void actionPerformed(ActionEvent e) {
		if(!this.text.getText().equals("")){
			this.vente.augmenterPrice(Integer.valueOf(this.text.getText()));
			this.vente.ajouterAuHistorique(this.vente.getArticle().getLastPrice());
		}
	}

}
