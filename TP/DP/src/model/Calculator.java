package model;


import java.util.ArrayList;
import java.util.Observable;

import model.Operation;
import view.*;

public class Calculator extends Observable {

	protected ArrayList<View> views;
	private Operation op;
	private int opeG, opeD;
	
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


}
