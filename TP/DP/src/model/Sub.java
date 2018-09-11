package model;

public class Sub implements Operation {
	private String sub;
	
	public Sub(int a, String ope, int b) {
		if(ope == "-"){
			this.sub ="-";
		}
	}

	public int resultat(int a, int b){
		return a - b;
	}

}
