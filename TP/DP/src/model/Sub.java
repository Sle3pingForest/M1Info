package model;

public class Sub implements Operation {
	private String sub;
	
	public Sub() {
		this.sub ="-";
	}

	public int resultat(int a, int b){
		return a - b;
	}

}
