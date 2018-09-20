package promo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
	
	public String affichePromo(){
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");
		StringBuilder sEnsInter = new StringBuilder("\nLes Intervenants : \n");
		StringBuilder sEnsUniv = new StringBuilder("\nLes Universitaires : \n");
		for(Personne p : personnes){
			if(p.estEtu()){
				sEtu.append(p.toString());
				sEtu.append("\n");
			}
			else{
				if(((Enseignant)p).getType().equals(Enseignant.INTERVENANT)) {
					sEnsInter.append(p.toString());
					sEnsInter.append("\n");
				}
				else {
					sEnsUniv.append(p.toString());
					sEnsUniv.append("\n");
				}
			}
		}	
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
		s.append(affichePromo());
		return s.toString();
	}
	

	public static void main(String[] args) {
		Matiere info = new Matiere("info");
		Matiere math = new Matiere("math");
		
		Set<Matiere> matieres =  new HashSet<Matiere>();
		matieres.add(info);
		matieres.add(math);
		
		Personne e1 = new Etudiant("Ly", "nam", 1994);
		Personne e2 = new Etudiant("Giang", "Andre", 1994);
		Personne e3 = new Etudiant("Losson", "Brice", 1994);
		Personne e4 = new Enseignant("Intervenants","Lee", "Bruce", 250, info);
		Personne e5 = new Enseignant("Universitaire","LY", "Nam", 200, math);
		
		Set<Personne> personnes = new HashSet<Personne>();
		personnes.add(e1);
		personnes.add(e2);
		personnes.add(e3);
		personnes.add(e4);
		personnes.add(e5);
		
		Promo promo = new Promo("Master 1", "2018-2019", personnes, matieres);
		//System.out.println(promo.toString()); //afficher les promos
		//System.out.println(promo.afficheEnseignant("Math"));
		//System.out.println(promo.afficheEnseignant("bdd"));
		//System.out.println(info.afficheEnseigant());
	}
}
