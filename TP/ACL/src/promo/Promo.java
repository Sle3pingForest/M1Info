package promo;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import comparable.AgeComparable;
import java.util.SortedSet;

import personne.Enseignant;
import personne.Etudiant;

import matiere.Matiere;


public class Promo {
	
	private String nom;
	private String annee;
	private Set<Etudiant> personnes;
	private Set<Matiere> matieres;
	
	
	public Promo( String nom, String annee, Set<Etudiant> personnes,Set<Matiere> matieres ){
		this.nom = nom;
		this.annee = annee;
		this.personnes = personnes;
		this.matieres = matieres;
	}
	
	public String AfficheEtudiant(){
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");

		for(Etudiant p : personnes){	
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
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");
		return sEtu.toString();
	}
	

	
	public String toString(){
		StringBuilder s = new StringBuilder("Promo ");
		s.append(this.nom + " " + this.annee +"\n");
		s.append(AfficheEtudiant());
		for(Matiere mat: matieres) {
			s.append(mat.afficheEnseigant());
		}
		return s.toString();
	}
	

	public static void main(String[] args) {
		Matiere info = Matiere.getInstance("info");
		Matiere math = Matiere.getInstance("math");
		
		Set<Matiere> matieres =  new HashSet<Matiere>();
		matieres.add(info);
		matieres.add(math);
		

		Etudiant e1 =  Etudiant.getInstance("Ly", "nam", 1994);
		Etudiant e2 = Etudiant.getInstance("Ly", "bruce", 1994);
		Etudiant e3 = Etudiant.getInstance("Losson", "Brice", 1984);
		Enseignant e4 = Enseignant.getInstance("Universitaire","li", "jet", 250, info);
		Enseignant e5 = Enseignant.getInstance("Universitaire","chan", "jacki", 250, math);
		Enseignant e6 = Enseignant.getInstance("Intervenants","Lee", "Bruce", 300, info);
		Enseignant e7 = Enseignant.getInstance("Universitaire","Lee", "Bruce", 300, math);
		
		Set<Etudiant> etudiants = new TreeSet<Etudiant>(new AgeComparable());
		etudiants.add(e1);
		etudiants.add(e2);
		etudiants.add(e3);

		
		Promo promo = new Promo("Master 1", "2018-2019", etudiants, matieres);
		System.out.println(promo.toString()); //afficher les promos
		//System.out.println(promo.afficheEnseignant("math"));
		//System.out.println(promo.afficheEnseignant("bdd"));
		//System.out.println(info.afficheEnseigant());
	}
}
