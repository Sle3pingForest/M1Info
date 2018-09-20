package matiere;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import personne.Enseignant;

public class Matiere {
	
	protected String nom;
	protected String lieu; // a implementer
	protected Enseignant ens;
	protected Set<Enseignant> ensList;
	
	public Matiere(String nom){
		this.nom = nom.toUpperCase();
		this.ensList = new HashSet<Enseignant>();
	}
	
	public void ajouterEnseignant(Enseignant ens){
			this.ensList.add(ens);
	}
	
	
	public String afficheEnseigant() {
		StringBuilder sb = new StringBuilder("");
		for(Enseignant ens: ensList) {
			sb.append(ens.toString());
			sb.append("\n");
		}
		return sb.toString();
		
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public Set<Enseignant> getEnsList(){
		return this.ensList;
	}
	
	public static void main(String[] args) {
		
		Matiere info = new Matiere("info");
		
		Enseignant ens1 = new Enseignant("Univesitaires", "BRUCE", "LY",230, info);
		Enseignant ens2 = new Enseignant("Univesitaires", "Nam", "Ly",30, info);
		System.out.println(info.afficheEnseigant());
		

			
}
}
