package promo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import personne.Enseignant;
import personne.Etudiant;
import personne.Personne;

import matiere.Matiere;


public class Promo {
	
	private String nom;
	private String annee;
	private Set<Personne> personnes;
	private Set<Matiere> matieres;
	
	
	public Promo( String nom, String annee, Set<Personne> personnes,Set<Matiere> matieres ){
		this.nom = nom;
		this.annee = annee;
		this.personnes = personnes;
		this.matieres = matieres;
	}
	
	public String Affiche(){
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");

		StringBuilder sEns = new StringBuilder("\nLes Intervenants : \n");
		for(Personne p : personnes){
			if(p.estEtu()){
				sEtu.append(p.toString());
				sEtu.append("\n");
			}
			else{
				sEns.append(p.toString());
				sEns.append("\n");
			}
		}	
		return sEtu.toString() + sEns.toString();
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder("Promo ");
		s.append(this.nom + " " + this.annee);
		s.append(Affiche());
		return s.toString();
	}
	

	public static void main(String[] args) {
		Matiere info = new Matiere("info");
		Matiere math = new Matiere("Math");
		
		Set<Matiere> matieres =  new HashSet<Matiere>();
		matieres.add(info);
		matieres.add(math);
		
		Personne e1 = new Etudiant("Ly", "nam", 1994);
		Personne e2 = new Etudiant("Giang", "Andre", 1994);
		Personne e3 = new Etudiant("Losson", "Brice", 1994);
		Personne e4 = new Enseignant("Universitaire","Lee", "Bruce", 250, info);
		
		Set<Personne> personnes = new HashSet<Personne>();
		personnes.add(e1);
		personnes.add(e2);
		personnes.add(e3);
		personnes.add(e4);
		
		Promo promo = new Promo("Master 1", "2018-2019", personnes, matieres);
		System.out.println(promo.toString());
	}
}
