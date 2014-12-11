package Model;
import java.util.ArrayList;

public class Pattern {
	private String name, solution, description;
	ArrayList<Consequence> allConsequences = new ArrayList<Consequence>();
	ArrayList<Context> context = new ArrayList<Context>();
	ArrayList<Problem> allProblems = new ArrayList<Problem>();
	public Pattern() {
	}
	public Pattern(String nm,String sol){
		this.name = nm;
		this.solution = sol;
	}
	public Pattern(String nm, String sol,String desc){
		this.name = nm;
		this.solution = sol;
		this.description = desc;
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
