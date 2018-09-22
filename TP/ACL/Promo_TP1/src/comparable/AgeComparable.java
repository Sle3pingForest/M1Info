package comparable;

import java.util.Comparator;
import personne.Etudiant;

public class AgeComparable implements Comparator<Etudiant> {

	public int compare(Etudiant e1, Etudiant e2) {
		if(e1.getAge() > e2.getAge()){
			return 1;
		}
		else{
			return -1;
		}
	}

}