package model;

public class Addition implements Operation {
	private String add ;
	
	public Addition() {
		this.add = "+";
	}
	

	public int resultat(OperantGauche a, OperantDroite b) {
		return a.getValeur() + b.getValeur();
	}
	
	public String getOperation() {
		return this.add;
	}

}
