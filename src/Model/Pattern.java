package Model;
import java.awt.List;
import java.util.ArrayList;

public class Pattern {
	private String name, solution;
	ArrayList<Consequence> allConsequences = new ArrayList<Consequence>();
	ArrayList<Context> context = new ArrayList<Context>();
	ArrayList<Problem> allProblems = new ArrayList<Problem>();
	
	public Pattern(String nm, String sol){
		name = nm;
		solution = sol;
	}

	public Consequence getConsequence(){
		return null;
		
	}
	public void addConsequence( Consequence  c){
		allConsequences.add(c);
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
