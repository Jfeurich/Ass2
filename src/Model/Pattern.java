package Model;
import java.awt.Image;
import java.awt.List;
import java.util.ArrayList;

public class Pattern {
	private String name, solution;
	private String consequence;
	private ArrayList<Context> context = new ArrayList<Context>();
	private String problem;
	private String diagram; //
	
	public Pattern(String nm, String sol){
		name =nm;
		solution = sol;
	}

	public Pattern(String problem, String diagram, String solution, String consequence){
		problem = this.problem;
		diagram = this.diagram;
		solution = this.solution;
		consequence = this.consequence;
	}
	
	public String getSolution() {
		return solution;
	}
	
	public String getConsequence(){
		return consequence;
	}
	
	public void setConsequence(String s){
		this.consequence = s;
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
	
	public void setProblem(String s){
		this.problem = s;
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
}
