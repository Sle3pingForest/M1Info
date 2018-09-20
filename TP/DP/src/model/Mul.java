package model;

public class Mul implements Operation {
	
	private String mul;
	
	public Mul(int a, String ope, int b) {
		if(ope == "*"){
			this.mul ="*";
		}
	}

	public int resultat(OperantGauche a, OperantDroite b) {
		return a.getValeur() * b.getValeur();
	}

	public String getOperation() {
		// TODO Auto-generated method stub
		return null;
	}
}
