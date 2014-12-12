package Model;
import java.awt.Image;
import java.awt.List;
import java.util.ArrayList;

public class Pattern {
	private String name, solution;
	ArrayList<Consequence> allConsequences = new ArrayList<Consequence>();
	ArrayList<Context> context = new ArrayList<Context>();
	ArrayList<Problem> allProblems = new ArrayList<Problem>();
	private Image diagram; //
	
	private String problem;
	
	public Pattern(String nm, String sol){
		name =nm;
		solution = sol;
	}

	public Pattern(String prob, Image img, String sol, String consequence){
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
	
	/// code toegevoegd
	public Image getDiagram(){
		return diagram;
	}
	
	public void setDiagram(Image dia){
		this.diagram = dia;
	}
	
	public String getProblem(){
		return problem;
	}
	
	public String toString(){
		String s = "Pattern:" + getProblem() ;
		return s;
	}
	
	////
}
