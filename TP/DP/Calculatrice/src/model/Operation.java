package model;

import java.util.Observable;

import operant.Operant;
import operateur.Operateur;
import operateur.OperateurMoins;
import operateur.OperateurPlus;

public class Operation {
	protected Operateur op ;
	protected Operant gauche;
	protected Operant droite;
	protected int resultat;
	
	public Operation() {
		this.gauche =  new Operant(0);
		this.droite = new Operant(0);
	}
	
	public Operation(Operant g , Operateur op, Operant d) {
		this.op = op;
		this.gauche = g;
		this.droite = d;
	}

	public Operateur getOp() {
		return op;
	}
	
	public void calculer() {
		if(this.op instanceof OperateurPlus) {
			this.resultat = this.gauche.getValeur()  + this.droite.getValeur();
		}
		if(this.op instanceof OperateurMoins) {

			this.resultat = this.gauche.getValeur() - this.droite.getValeur();
		}
	}

	public void setOp(Operateur op) {
		this.op = op;
	}

	public Operant getGauche() {
		return gauche;
	}

	public void setGauche(Operant gauche) {
		this.gauche = gauche;
	}

	public Operant getDroite() {
		return droite;
	}

	public void setDroite(Operant droite) {
		this.droite = droite;
	}
	
	public int getResultat() {
		return this.resultat;
	}
	
}
