package matiere;

import java.util.HashSet;
import java.util.Set;

import personne.Enseignant;

public class Matiere {
	
	protected String nom;
	protected String lieu; 
	protected Set<Enseignant> ensList;
	
	private Matiere(String nom, String lieu){
		this.nom = nom.toUpperCase();
		this.lieu = lieu;
		this.ensList = new HashSet<Enseignant>();
	}
	
	public static Matiere getInstance(String nom, String lieu){
		return new Matiere(nom, lieu);
	}
	
	public void ajouterEnseignant(Enseignant ens){
			this.ensList.add(ens);
	}
	
	
	public String afficheEnseigant() {
		StringBuilder sb = new StringBuilder("");
		StringBuilder sEnsInter = new StringBuilder("\nLes Intervenants en " + this.nom +":\n");
		StringBuilder sEnsUniv = new StringBuilder("\nLes Universitaires en "+ this.nom +":\n");
		for(Enseignant ens: ensList) {
			if(ens.getType().equals(Enseignant.INTERVENANT)){
				sEnsInter.append("\t"+ens.toString() +"\n");
			}
			else{
				sEnsUniv.append("\t"+ens.toString()+"\n");
			}
		}
		sb.append("\n");
		return sb.toString() + sEnsInter.toString() + sEnsUniv.toString();
		
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public Set<Enseignant> getEnsList(){
		return this.ensList;
	}
	
	public static void main(String[] args) {
				
	}
}
