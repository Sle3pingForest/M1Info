package comparable;

import java.util.Comparator;

import personne.Personne;

public class NomComparable implements Comparator<Personne> {

	@Override
	public int compare(Personne m1, Personne m2) {
		return m1.toString().compareTo(m2.toString());
	}


}