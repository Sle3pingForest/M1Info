package promo;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import comparable.AgeComparable;
import comparable.MatiereComparable;
import comparable.NomComparable;
import personne.Enseignant;
import personne.Etudiant;
import personne.Personne;
import matiere.Matiere;


public class Promo {
	
	private String nom;
	private String annee;
	private Set<Etudiant> etudiants;
	private Set<Matiere> matieres;
	private Set<Personne> personnes;
	
	private Promo( String nom, String annee, Set<Etudiant> etudiants,Set<Matiere> matieres ){
		this.nom = nom;
		this.annee = annee;
		this.etudiants = etudiants;
		this.matieres = matieres;
		this.personnes = new TreeSet<Personne>(new NomComparable() );
		this.personnes.addAll(etudiants);
		for(Matiere mat : this.matieres) {
			this.personnes.addAll(mat.getEnsList());
		}
	}
	
	public static Promo getInstance( String nom, String annee, Set<Etudiant> etudiants,Set<Matiere> matieres ) {
		return new Promo( nom,  annee,  etudiants, matieres );
	}
	
	public String afficheEtudiant(){
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");

		for(Etudiant p : etudiants){	
			sEtu.append(p.toString());
			sEtu.append("\n");
		}	
		return sEtu.toString();
		
	}
	
	public String afficheEnseignant(String m) {
		StringBuilder sb = new StringBuilder("Matiere: " + m.toUpperCase() +"\n");
		for(Matiere mat: matieres) {
			if(mat.getNom().equals(m.toUpperCase())) {
				sb.append(mat.afficheEnseigant());
			}
		}
		return sb.toString();
	}

	public String affichePromo(){
		StringBuilder promo = new StringBuilder("\nPromo: " + this.nom + " " + this.annee+  "\n");
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");
		StringBuilder sEns = new StringBuilder("\nLes Enseignants : \n");
		for (Personne pers : personnes) {
			if(pers.estEtu()) {
				sEtu.append(((Etudiant)pers).toString());
			}
			else {
				sEns.append(((Enseignant)pers).toString());
			}
		}
		sEns.append("\n");
		sEtu.append("\n");
		return promo.toString() + sEtu.toString() + sEns.toString();
	}

	
	public String toString(){
		StringBuilder s = new StringBuilder("Promo");
		s.append(this.nom + " " + this.annee +"\n");
		s.append(afficheEtudiant());
		for(Matiere mat: matieres) {
			s.append(mat.afficheEnseigant());
		}
		return s.toString();
	}
	

	public static void main(String[] args) {
		Matiere info = Matiere.getInstance("info","fst");
		Matiere math = Matiere.getInstance("math","iut");
		Matiere bdd = Matiere.getInstance("bdd","iut");
		
		Set<Matiere> matieres =  new TreeSet<Matiere>(new MatiereComparable());
		matieres.add(info);
		matieres.add(math);
		matieres.add(bdd);
		

		Etudiant e1 =  Etudiant.getInstance("Ly", "nam", 1994);
		Etudiant e2 = Etudiant.getInstance("Ly", "bruce", 1994);
		Etudiant e3 = Etudiant.getInstance("Losson", "Brice", 1984);
		Enseignant e4 = Enseignant.getInstance("Universitaire","li", "jet", 250, info);
		Enseignant e5 = Enseignant.getInstance("Universitaire","chan", "jacki", 250, math);
		Enseignant e6 = Enseignant.getInstance("Intervenants","Lee", "Bruce", 300, info);
		Enseignant e7 = Enseignant.getInstance("Universitaire","Lee", "Bruce", 300, math);
		Enseignant e8 = Enseignant.getInstance("Universitaire","darius", "noxus", 250, bdd);
		
		Set<Etudiant> etudiants = new TreeSet<Etudiant>(new NomComparable());
		etudiants.add(e1);
		etudiants.add(e2);
		etudiants.add(e3);

		
		Promo promo = Promo.getInstance("Master 1", "2018-2019", etudiants, matieres);
		//System.out.println(promo.afficheEtudiant()); 
		//System.out.println(promo.afficheEnseignant("math"));
		//System.out.println(promo.afficheEnseignant("bdd"));
		System.out.println(promo.affichePromo());
	}
}
