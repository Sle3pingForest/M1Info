package construction;

import creation.eliminatoire.Eliminatoire;
import creation.technique.Technique;

public  abstract class AbstractExamenFactory extends Examen {
	
	abstract Technique getTech();
	abstract Eliminatoire getElim();

}
