package personne;

public class Personne {

	protected String nom;
	protected String prenom;
	protected boolean etudiant = true;

	
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String toString(){
		return "";
	}
	public boolean estEtu(){
		return etudiant;
	}
}
