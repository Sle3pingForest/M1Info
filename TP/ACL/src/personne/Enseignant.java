package personne;

import java.util.ArrayList;
import java.util.List;


import matiere.Matiere;

public class Enseignant extends Personne {
	
	protected String type;
	protected List<Matiere> matieres;
	protected Matiere matiere;
	protected int nombreHeure;
	protected int salaire;
	final static int SALAIRE_MENSUEL = 2000;
	final static int SALAIRE_PAR_H = 30;
	final static String UNIV = "Universitaire";
	final static String INTERVENANT = "Intervenants";
	final static int HEUREWORK = 200;
	final static int IDEMMITE = 15/100;
	
	
	
	public Enseignant(String type, String nom, String prenom, int nbHeure, Matiere matiere){
		super(nom, prenom);
		this.type = type;
		this.matiere = matiere;
		this.nombreHeure = nbHeure;
		this.etudiant = false;
		System.out.println("azarataztatazte");
		if(this.type.equals("UNIV")){
			if(this.nombreHeure > HEUREWORK){
				this.salaire = SALAIRE_MENSUEL + IDEMMITE*(this.nombreHeure - HEUREWORK)*SALAIRE_PAR_H;
			}
			else{
				this.salaire = SALAIRE_PAR_H * this.nombreHeure;
			}
		}
		else{
			this.salaire = 2*SALAIRE_PAR_H * this.nombreHeure;
		}
	}
	
	public int getSalaire(){
		return this.salaire;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder("");
		s.append(this.prenom + " " + this.nom + " en " + this.matiere.toString() + ", salaire = " + this.salaire);
		return s.toString(); 
	}

}
