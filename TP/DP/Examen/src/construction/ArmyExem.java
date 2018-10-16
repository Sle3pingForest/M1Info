package construction;

import creation.eliminatoire.ArmyElim;
import creation.eliminatoire.Eliminatoire;
import creation.technique.ArmyTech;
import creation.technique.Technique;

public class ArmyExem extends AbstractExamenFactory {
	
	public Technique getTech(){
		Technique t = new ArmyTech();
		return t;
	}
	
	public Eliminatoire getElim(){
		Eliminatoire elim = new ArmyElim();
		return elim;
	}

}
