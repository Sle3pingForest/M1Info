package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;

import model.Journal;
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
			if(Integer.valueOf(this.text.getText()) > this.vente.getProduit().getLastPrice()){
				this.vente.augmenterPrice(Integer.valueOf(this.text.getText()));
				s = infoLogger + ": Auction "+ this.vente.getHuisier().getName() +" for " + this.vente.getProduit().getName()+ "- Bid= "+ this.vente.getProduit().getLastPrice();
			}
			else{
				s = infoLogger + ": Auction "+ this.vente.getHuisier().getName() +" for " + this.vente.getProduit().getName()+ "- Bid= "+ this.text.getText();
			}
			Journal.getInstance().ajouterAujournal(s);
		}
	}

}
