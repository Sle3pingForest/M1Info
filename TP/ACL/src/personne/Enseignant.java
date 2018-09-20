package personne;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.utils.NSInfo;

import matiere.Matiere;

public class Enseignant extends Personne {
	
	protected String type;
	//protected List<Matiere> matieres;
	protected Matiere matiere;
	protected int nombreHeure;
	protected int salaire;
	final static int SALAIRE_MENSUEL = 2000;
	final static int SALAIRE_PAR_H = 30;
	public final static String UNIV = "Universitaire";
	public final static String INTERVENANT = "Intervenants";
	final static int HEUREWORK = 200;
	final static int IDEMMITE = 15/100;
	
	
	
	public Enseignant(String type, String nom, String prenom, int nbHeure, Matiere matiere){
		super(nom, prenom);
		this.type = type;
		this.nombreHeure = nbHeure;
		this.etudiant = false;
		this.matiere = matiere;
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

		matiere.ajouterEnseignant(this);
	}
	
	public int getSalaire(){
		return this.salaire;
	}
	
	public Matiere getMatiere() {
		return this.matiere;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder("");
		s.append(this.prenom + " " + this.nom +  " en " + this.matiere.getNom() +", salaire = " + this.salaire);
		return s.toString(); 
	}
	
	public static void main(String[] args) {
		
		/*Enseignant ens1 = new Enseignant("Universitaire", "LY", "Nam", 250, info);
		System.out.println(ens1.getMatiere().getNom());
		System.out.println(ens1.toString());*/
		
		
	}

}
