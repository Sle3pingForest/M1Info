package model;


import java.util.ArrayList;
import java.util.Observable;

import model.Operation;
import view.*;

public class Calculator extends Observable {

	private Operation op;
	private OperantGauche og;
	private OperantDroite od;
	protected int resultat ;
	protected int resultatInter ;
	public static boolean END_OPERATION = false;
	public static boolean DROITE = false;
	
	public Calculator(){
		this.og = new OperantGauche(0);
		this.od = new OperantDroite(0);
		this.resultat = 0;
		this.resultatInter = 0;
	}
	
	private int calculer(){
		System.out.println(this.og.getValeur() + this.op.getOperation() + this.od.getValeur());
		return this.op.resultat(this.og, this.od);
	}
	
	public void setResultat(int digit){
		if(digit != View.EQUAL) {
			resultatInter = calculer();
			setOpG(resultatInter);
			setOpD(0);
			DROITE = true;
		}
		else {
			this.resultat = calculer();
			this.setOpD(0);
			this.setOpG(0);
			END_OPERATION = true;
			DROITE = false;
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public void setOperation(Operation op){
		this.op = op;
		this.setChanged();
		this.notifyObservers();
	}

	
	public OperantDroite getOpD() {
		return this.od;
	}
	
	public OperantGauche getOpG() {
		return this.og;
	}
	
	public void setOpG(int a) {
		this.og = new OperantGauche(a);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setOpD(int b) {
		this.od = new OperantDroite(b);
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getResultat(){
		return this.resultat;
	}
	
	public int getResultatInter() {
		return this.resultatInter;
	}
	
	public String operation() {
		return this.op.getOperation();
	}

}
