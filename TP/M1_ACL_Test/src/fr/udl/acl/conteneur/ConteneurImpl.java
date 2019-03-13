/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.udl.acl.conteneur;


/**
 * Implementation incorrecte (et inneficace) du conteneur
 * @author urso
 */
public class ConteneurImpl implements Conteneur {

    private Object data[];
    private int taille;

    public ConteneurImpl(int capacite) {
        data = new Object[capacite];
        taille = 0;
    }

    public void ajouter(Object o) throws ErreurConteneur {
    	if(o == null){
            throw new ErreurConteneur("ajout un elem null");
    	}
        if (taille > data.length) {
            throw new ErreurConteneur("ajout dans conteneur plein");
        }
    	if(contient(o)){
            throw new ErreurConteneur("ajout d object " + o + " déjà présent");
    	}   
    	
	   for (int i = 0; i < taille; ++i) {
           if (data[i] == o) {
        	   throw new ErreurConteneur("ajout d element" + o + " déjà présent");
           }
       }
        data[taille] = o;
        taille++;
    }

    public void retirer(Object o) throws ErreurConteneur {
        int p = -1;
        for (int i = 0; (p < 0) && (i <= taille); ++i) {
            if (data[i] == o) {
                p = i;                
            }
        }
        if (p < 0) {
            throw new ErreurConteneur("retire " + o + " non présent");
        }
        for (int i = taille; i > p; --i) {
            data[i] = data[i + 1];
        }
        taille--;
    }

    public void redimensionner(int nouv) throws ErreurConteneur {
        if (nouv < data.length) {
            throw new ErreurConteneur("redimensionner taille trop petite");
        }
        Object d2[] = new Object[nouv];
        for (int i = 0; i < taille - 1; i++) {
            d2[i] = data[i];
        }
        data = d2;
    }

    public boolean contient(Object o) {
        for (int i = 0; i < taille; ++i) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean estVide() {
        return taille == 0;
    }

    public int taille() {
        return taille;
    }

    public int capacite() {
        return data.length;
    }
}
