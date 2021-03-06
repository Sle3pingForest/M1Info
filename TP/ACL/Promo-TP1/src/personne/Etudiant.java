package personne;


import java.util.Calendar;


public class Etudiant extends Personne{
	protected int age;

	protected static int NOETU;
	protected int noEt;
	
	private Etudiant(String nom, String prenom, int annee){
		super(nom, prenom);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		this.age = year - annee;
		noEt = NOETU++;
	}
	
	public static Etudiant getInstance(String nom, String prenom, int annee){
		return new Etudiant(nom, prenom, annee);
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String toString(){

		StringBuilder s = new StringBuilder("");
		s.append("\tEtudiant " + this.nom + " " + this.prenom + " (noEt=" + noEt+ ") " + this.age + " ans \n");
		return s.toString();
	}
	
	

	public static void main(String[] args) {
			Personne e1 = new Etudiant("Ly", "nam", 1994);
			System.out.println(e1.toString());
	}
	
}


