package construction;

import creation.eliminatoire.Eliminatoire;
import creation.technique.Technique;


public abstract class Examen {
	
	protected String nomExamen;
	protected String nomResponsable;
	abstract Technique getTech();
	abstract Eliminatoire getElim();
	
	public String getDesc() {
		return "";
	}
	

}
