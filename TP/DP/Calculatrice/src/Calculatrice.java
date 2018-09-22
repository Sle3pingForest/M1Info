import javax.swing.JFrame;

import view.View;

import model.Calculator;


public class Calculatrice  {
	
	public Calculatrice(){
		Calculator cal = new Calculator();
		View v = new View();
		v.view(cal);
		
	}
	public static void main(String[] args) {
			new Calculatrice();
	}
}
