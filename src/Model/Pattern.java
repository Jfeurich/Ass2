package Model;

import java.util.ArrayList;

public class Pattern {
	private String name, solution;
	ArrayList<Consequence> allConsequences = new ArrayList<Consequence>();


	public Pattern(String nm, String sol){
		name = nm;
		solution = sol;
	}

	/*public Consequence getConsequence(){
		
	}*/
	public void addConsequence( Consequence  c){
		allConsequences.add(c);
	}
}
