package model;

import java.util.HashSet;
import java.util.Set;


public class Carnet {
	
	protected String nom;
	
	protected Set<Contact> ensembleContact;
	
	public Carnet (String nom){
		this.nom = nom;
		this.ensembleContact = new HashSet<Contact>() ;
		
	}
	
	public void ajouterContact(Contact c){
		this.ensembleContact.add(c);
	}
	
	public void supprimerContact(Contact c){
		for(Contact contact : ensembleContact){
			if(c.nom.equals(contact)){
				this.ensembleContact.remove(contact);
			}
		}
	}

}
