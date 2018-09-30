package model;


import java.util.ArrayList;
import java.util.Observable;

import model.Operation;
import operant.Operant;

public class Calculator extends Observable {

	private ArrayList<Operation> operations;
	private Operation operation;
	public static boolean DROITE = false;
	public static boolean END = false;
	public static boolean INTER = false;
	public static boolean HISTORIQUE = false;
	private int resultat ;
	
	public Calculator(){
		this.operations = new ArrayList<Operation>();
		this.operation = new Operation();
		this.operations.add(operation);
	}
	public Calculator(Operation operation ){
		this.operations = new ArrayList<Operation>();
		this.operation = operation;
		this.operations.add(operation);
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
		Calculator.END = true;
		setChanged();
		notifyObservers();
		Calculator.DROITE = false;
		Calculator.INTER = false;
	}

	public void afficheHistorique() {
		Calculator.HISTORIQUE = !Calculator.HISTORIQUE;
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

	public void setOperation(Operation op) {
		this.operation = op;
		System.out.println(op.getGauche().getValeur());
		System.out.println(op.getDroite().getValeur());
		setChanged();
		notifyObservers();
	}


}
