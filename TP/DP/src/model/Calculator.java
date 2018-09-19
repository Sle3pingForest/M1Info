package model;


import java.util.ArrayList;
import java.util.Observable;

import model.Operation;
import view.*;

public class Calculator extends Observable {

	private Operation op;
	private int opeG , opeD ;
	public static boolean DROITE = false;
	public static boolean RESULTAT = false;
	protected int resultat ;
	
	public Calculator(int d, int g){
		this.opeD = d;
		this.opeG = g;
		this.setChanged();
		this.notifyObservers();
	}
	
	private int calculer(){
		return this.op.resultat(this.opeG, this.opeD);
	}
	
	public void setResultat(){
		this.resultat = calculer();
		this.opeG = this.resultat;
		this.opeD = 0;
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public void setOperation(Operation op){
		this.op = op;
		this.setChanged();
		this.notifyObservers();
	}

	
	public int getOpD() {
		return this.opeD;
	}
	
	public int getOpG() {
		return this.opeG;
	}
	
	public void setOpG(int a) {
		this.opeG = a;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setOpD(int b) {
		this.opeD = b;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getResultat(){
		return this.resultat;
	}

	public static void main(String[] args) {
		Calculator cal =  new Calculator(0,15);
		Addition add = new Addition();
		cal.setOperation(add);
		System.out.println(cal.calculer());
	}

}
