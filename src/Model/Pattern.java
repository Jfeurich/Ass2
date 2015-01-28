package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;

public class Pattern implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2262846250404779815L;
	private String name, solution;
	private String allConsequences;
	private ArrayList<Context> context = new ArrayList<Context>();
	private ArrayList<String> allProblems;
	private File diagram; 
	
	private String problem;
	
	public Pattern(String nm, String sol){
		name =nm;
		solution = sol;
	}

	public Pattern(String prob, String sol, String consequence){
		problem = prob;
		solution = sol;
		allConsequences = consequence;

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

	public String getAllConsequences() {
		return allConsequences;
	}

	public void setAllConsequences(String allConsequences) {
		this.allConsequences = allConsequences;
	}

	public String getAllProblems() {
		return allProblems;
	}

	public void setAllProblems(String allProblems) {
		this.allProblems = allProblems;
	}
	
	////
}
