package comparable;

import java.util.Comparator;
import matiere.Matiere;

public class MatiereComparable implements Comparator<Matiere> {

	
	public int compare(Matiere m1, Matiere m2) {
		return m1.getNom().compareTo(m2.getNom());
	}


}