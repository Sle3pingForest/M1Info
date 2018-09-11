package model;

public class Mul implements Operation {
	
	private String mul;
	
	public Mul(int a, String ope, int b) {
		if(ope == "*"){
			this.mul ="*";
		}
	}

	public int resultat(int a, int b){
		return a * b;
	}
}
