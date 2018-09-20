package personne;


import java.util.Calendar;


public class Etudiant extends Personne{
	protected int age;

	protected static int NOETU;
	protected int noEt;
	
	public Etudiant(String nom, String prenom, int annee){
		super(nom, prenom);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		this.age = year - annee;
		noEt = NOETU++;
	}
	
	public String toString(){

		StringBuilder s = new StringBuilder("");
		s.append("Etudiant " + this.prenom + " " + this.nom + " (noEt=" + noEt+ ") " + this.age + " ans");
		return s.toString();
	}
	

	public static void main(String[] args) {
			Personne e1 = new Etudiant("Ly", "nam", 1994);
			System.out.println(e1.toString());
	}
	
}


