package matiere;

public class Matiere {
	
	protected String nom;
	protected String lieu; // a implementer
	
	public Matiere( String nom){
		this.nom = nom;
	}
	
	public String toString(){
		return this.nom;
	}
}
