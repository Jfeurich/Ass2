package Controller;

import Model.Context;
import Model.Pattern;

import java.io.File;
import java.util.ArrayList;

public class PatternBuilder {

	private Pattern pattern;

	public Pattern makePattern(String name){
		Pattern pattern = new Pattern(name);
		return pattern;
	}

	public void setConsequences(String s){
		pattern.setAllConsequences(s);
	}

	public void setProblems(ArrayList<String> problems){
		pattern.setAllProblems(problems);
	}

	public void setAllSolutions(ArrayList<String> solutions){
		pattern.setAllSolutions(solutions);
	}

	public void addDiagram(File f){
		pattern.setDiagram(f);
	}

	public void addContext(Context c){
		pattern.setContext(c);
	}
	public String getPatternName(){
		return pattern.getName();
	}
}
