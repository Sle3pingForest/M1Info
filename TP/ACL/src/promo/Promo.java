package promo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import comparable.AgeComparable;
import java.util.SortedSet;

import personne.Enseignant;
import personne.Etudiant;
import personne.Personne;

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

	public String affichePromo(){
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");
		StringBuilder sEnsInter = new StringBuilder("\nLes Intervenants : \n");
		StringBuilder sEnsUniv = new StringBuilder("\nLes Universitaires : \n");

		return sEtu.toString() + sEnsInter.toString() + sEnsUniv.toString();
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
	
	public String toString(){
		StringBuilder s = new StringBuilder("Promo ");
		s.append(this.nom + " " + this.annee);
		s.append(AfficheEtudiant());
		return s.toString();
	}
	

	public static void main(String[] args) {
		Matiere info = new Matiere("info");
		Matiere math = new Matiere("math");
		
		Set<Matiere> matieres =  new HashSet<Matiere>();
		matieres.add(info);
		matieres.add(math);
		

		Etudiant e1 =  Etudiant.getInstance("Ly", "nam", 1994);
		Etudiant e2 = Etudiant.getInstance("Ly", "bruce", 1994);
		Etudiant e3 = Etudiant.getInstance("Losson", "Brice", 1984);
		Personne e4 = new Enseignant("Universitaire","Lee", "Bruce", 250, info);
		
		Set<Etudiant> personnes = new TreeSet<Etudiant>(new AgeComparable());
		personnes.add(e1);
		personnes.add(e2);
		personnes.add(e3);

		//personnes.add(e4);
		
		Promo promo = new Promo("Master 1", "2018-2019", personnes, matieres);
		System.out.println(promo.toString()); //afficher les promos
		//System.out.println(promo.afficheEnseignant("Math"));
		//System.out.println(promo.afficheEnseignant("bdd"));
		//System.out.println(info.afficheEnseigant());
	}
}
