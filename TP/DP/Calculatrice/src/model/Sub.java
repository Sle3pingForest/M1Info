package model;

public class Sub implements Operation {
	private String sub;
	
	public Sub() {
		this.sub ="-";
	}
	
	public int resultat(OperantGauche a, OperantDroite b) {
		return a.getValeur() - b.getValeur();
	}

	public String getOperation() {
		// TODO Auto-generated method stub
		return sub;
	}
}
