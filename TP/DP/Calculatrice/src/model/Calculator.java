package model;


import java.util.ArrayList;
import java.util.Observable;

import model.Operation;
import operant.Operant;
import operateur.Operateur;

public class Calculator extends Observable {

	private ArrayList<Operation> operations;
	private Operation operation;
	public static boolean DROITE = false;
	public static boolean END = false;
	public static boolean ENCOURS = false;
	public static boolean INTER = false;
	private int resultat ;
	
	public Calculator(){
		this.operation = new Operation();
	}
	public Calculator(Operation operation ){
		this.operation = operation;
	}
	public void calculerInter() {
		this.operation.calculer();
		this.setResultat(this.operation.getResultat());
		this.operation.setGauche(new Operant(this.resultat));
		this.operation.setDroite(new Operant(0));
		Calculator.DROITE = true;
		Calculator.INTER = false;
		setChanged();
		notifyObservers();
		
	}
	
	public void calculer() {
		this.operation.calculer();
		this.resultat = this.operation.getResultat();
		setChanged();
		notifyObservers();
	}

	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}


	public void setResultat(int i) {
		this.resultat = i;
	}
	
	public int getResultat() {
		return resultat;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
		setChanged();
		notifyObservers();
	}


}
