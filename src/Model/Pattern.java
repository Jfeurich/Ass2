package Model;
import java.awt.Image;
import java.awt.List;
import java.util.ArrayList;

public class Pattern {
	private String name, solution;
	private ArrayList<Consequence> allConsequences = new ArrayList<Consequence>();
	private ArrayList<Context> context = new ArrayList<Context>();
	private ArrayList<Problem> allProblems = new ArrayList<Problem>();
	private String diagram; //
	
	private String problem;
	
	public Pattern(String nm, String sol){
		name =nm;
		solution = sol;
	}

	public Pattern(String prob, String img, String sol, String consequence){
		problem = prob;
		solution = sol;
		diagram = img;
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
	
	public String getDiagram(){
		return diagram;
	}
	
	public void setDiagram(String dia){
		this.diagram = dia;
	}
	
	public String getProblem(){
		return problem;
	}
	
	public String toString(){
		String s = "Pattern:" + getProblem() ;
		return s;
	}

	public ArrayList<Context> getContext() {
		return context;
	}

	public void setContext(ArrayList<Context> context) {
		this.context = context;
	}

	public ArrayList<Problem> getAllProblems() {
		return allProblems;
	}

	public void setAllProblems(ArrayList<Problem> allProblems) {
		this.allProblems = allProblems;
	}
	
	////
}
