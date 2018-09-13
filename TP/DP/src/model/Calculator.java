package model;


import java.util.ArrayList;
import java.util.Observable;

import model.Operation;
import view.*;

public class Calculator extends Observable {

	protected ArrayList<View> views;
	private Operation op;
	private int opeG = 0, opeD = 0;
	
	public Calculator(int d, int g){
		this.opeD = d;
		this.opeG = g;
	}
	
	public int calculer(){
		return this.op.resultat(this.opeG, this.opeD);
	}
	
	public void setOperation(Operation op){
		this.op = op;
	}

	public void majVue(){
		for(View v : views){
			//v.maj();
		}
	}
	
	public void ajouterVue(View v){
		views.add(v);
	}
	
	public int getOpD() {
		return this.opeD;
	}
	
	public int getOpG() {
		return this.opeG;
	}
	
	public void setOpG(int a) {
		this.opeG = a;
	}
	
	public void setOpD(int b) {
		this.opeD = b;
	}

	public static void main(String[] args) {
		Calculator cal =  new Calculator(5,5);
		Addition add = new Addition(cal.getOpG(), cal.getOpD());
		cal.setOperation(add);
		System.out.println(add.resultat(cal.getOpG(), cal.getOpD()));
	}

}
