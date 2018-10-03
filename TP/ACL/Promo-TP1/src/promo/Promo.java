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
	private Set<Enseignant> enseignants;
	
	private Promo( String nom, String annee, Set<Etudiant> etudiants,Set<Matiere> matieres ){
		this.nom = nom;
		this.annee = annee;
		this.etudiants = etudiants;
		this.matieres = matieres;
		this.enseignants = new TreeSet<Enseignant>(new NomComparable());
		for( Matiere mat : matieres){
			this.enseignants.addAll(mat.getEnsList());
		}
	}
	
	public static Promo getInstance( String nom, String annee, Set<Etudiant> etudiants,Set<Matiere> matieres ) {
		return new Promo( nom,  annee,  etudiants, matieres );
	}
	
	
	/*public void ajouterEtudiant(Etudiant etu){
		if(etu == null){
			try{
				System.err.println("vous venez d'ajouter une fantome");
			}
			catch(Exception error){
			}
		}
		else{
			this.etudiants.add(etu);
		}
	}*/
	
	public void ajouterPersonnes(Personne p){
		if(p == null){
			try{
				System.err.println("vous venez d'ajouter une fantome");
			}
			catch(Exception error){
			}
		}
		else{
			if(p.estEtu()){
				this.etudiants.add((Etudiant)p);
			}
			else{
				this.enseignants.add((Enseignant)p);
			}
		}
		
	}
	
	public String afficheEtudiantNom(String type){
		StringBuilder sEtu = new StringBuilder( "Promo " + this.nom + " " + this.annee+  "\nLes Etudiants : \n");
		if(type.equals("AGE")){
			Set<Etudiant> etudiantsAge = new TreeSet<Etudiant>(new AgeComparable());
			for(Etudiant p : etudiants){	
				etudiantsAge.add(p);
			}	
			for(Etudiant p : etudiantsAge){	
				sEtu.append(p.toString());
				sEtu.append("\n");
			}
		}
		else{
			Set<Etudiant> etudiantsNom = new TreeSet<Etudiant>(new NomComparable());
			for(Etudiant p : etudiants){	
				etudiantsNom.add(p);
			}
			for(Etudiant p : etudiantsNom){	
				sEtu.append(p.toString());
				sEtu.append("\n");
			}
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
	

	public String afficheMatiere() {
		StringBuilder sb = new StringBuilder();
		for(Matiere mat: matieres) {
			sb.append(mat.getNom() +" se deroule en " + mat.getLieu() + "\n");
		}
		return sb.toString();
	}

	public String affichePromo(){
		StringBuilder promo = new StringBuilder("\nPromo: " + this.nom + " " + this.annee+  "\n");
		StringBuilder sEtu = new StringBuilder("\nLes Etudiants : \n");
		StringBuilder sEns = new StringBuilder("\nLes Enseignants : \n");
		for (Enseignant pers : enseignants) {
			sEns.append(pers.toString());
		}
		for(Etudiant ens : etudiants){
			sEtu.append(ens.toString());
		}
		sEns.append("\n");
		sEtu.append("\n");
		return promo.toString() + sEtu.toString() + sEns.toString();
	}

	
	public String toString(){
		StringBuilder s = new StringBuilder("Promo");
		s.append(this.nom + " " + this.annee +"\n");
		//s.append(afficheEtudiant(""));
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
		
		
		Set<Etudiant> etudiants = new HashSet<Etudiant>();
		etudiants.add(e1);
		etudiants.add(e2);
		etudiants.add(e3);
		

		
		Promo promo = Promo.getInstance("Master 1", "2018-2019", etudiants, matieres);
		promo.ajouterPersonnes(e1);
		promo.ajouterPersonnes(e2);
		promo.ajouterPersonnes(e3);
		promo.ajouterPersonnes(e4);
		promo.ajouterPersonnes(e5);
		promo.ajouterPersonnes(e6);
		promo.ajouterPersonnes(e7);
		promo.ajouterPersonnes(e8);
		promo.ajouterPersonnes(null);
		System.out.println(promo.afficheEtudiant("Age"));  
		//System.out.println(promo.afficheEnseignant("mobile"));
		//System.out.println(promo.afficheEnseignant("bdd"));
		//System.out.println(promo.affichePromo());
		//System.out.println(promo.afficheMatiere());
		//System.out.println(promo.afficheEtudiant()); 
	}

}
