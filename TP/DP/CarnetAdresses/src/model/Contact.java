package model;

public class Contact {
	
	public String nom;
	public String prenom;
	public String mail;
	
	
	public Contact(String nom, String prenom, String mail){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

		
}
