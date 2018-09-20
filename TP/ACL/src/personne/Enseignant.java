package personne;


import java.util.HashSet;
import java.util.Set;

import matiere.Matiere;

public class Enseignant extends Personne {
	
	protected String type;
	protected Set<Matiere> matieres;
	protected int nombreHeure;
	protected int salaire;
	final static int SALAIRE_MENSUEL = 2000;
	final static int SALAIRE_PAR_H = 30;
	public final static String UNIV = "Universitaire";
	public final static String INTERVENANT = "Intervenants";
	final static int HEUREWORK = 200;
	final static int IDEMMITE = 15/100;
	
	
	
	private Enseignant(String type, String nom, String prenom, int nbHeure, Matiere matiere){
		super(nom, prenom);
		this.type = type;
		this.nombreHeure = nbHeure;
		this.etudiant = false;
		this.matieres = new HashSet<Matiere>() ;
		this.matieres.add(matiere);
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
	
	public static Enseignant getInstance(String type, String nom, String prenom, int nbHeure, Matiere matiere){
		return new Enseignant(type, nom, prenom, nbHeure, matiere);
	}
	
	public int getSalaire(){
		return this.salaire;
	}
	
	public String getMatiere() {
		StringBuilder sb = new StringBuilder("");
		for(Matiere mat: matieres){
			sb.append(mat.getNom()+", ");
		}
		return sb.toString();
	}
	
	public String getType() {
		return this.type;
	}
	
	
	public String toString(){
		StringBuilder s = new StringBuilder("");
		s.append(this.prenom + " " + this.nom +  " en " + getMatiere() +"salaire = " + this.salaire);
		return s.toString(); 
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
