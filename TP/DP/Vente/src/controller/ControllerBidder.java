package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;

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
			Date infoLogger = Calendar.getInstance().getTime();
			String s = "";
			if(Integer.valueOf(this.text.getText()) > this.vente.getLot().getLastPrice()){
				this.vente.augmenterPrice(Integer.valueOf(this.text.getText()));
				s = infoLogger + ": Auction "+ this.vente.getHuisier().getName() +" for " + this.vente.getLot().getName()+ "- Bid= "+ this.vente.getLot().getLastPrice();
			}
			else{
				s = infoLogger + ": Auction "+ this.vente.getHuisier().getName() +" for " + this.vente.getLot().getName()+ "- Bid= "+ this.text.getText();
			}
			this.vente.ajouterAuHistorique(s);
		}
	}

}
