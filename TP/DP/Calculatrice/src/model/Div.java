package model;

public class Div implements Operation {
	private String div;
	
	
	public Div(int a, String ope, int b) {
	}

	public int resultat(OperantGauche a, OperantDroite b) {
		return a.getValeur() / b.getValeur();
	}

	public String getOperation() {
		// TODO Auto-generated method stub
		return null;
	}

}
