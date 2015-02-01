package Controller;

import Model.Context;
import Model.Pattern;

import java.io.File;

public class PatternBuilder {

	private Pattern pattern;

	public void makePattern(String name){
		Pattern pattern = new Pattern(name);
		this.pattern = pattern;
	}

	public void setPattern(Pattern p){
		this.pattern = p;
	}

	public Pattern getPattern(){
		return this.pattern;
	}

	public void setConsequences(String s){
		pattern.setAllConsequences(s);
	}

	public void setProblems(String problems){
		pattern.setAllProblems(problems);
	}

	public void setAllSolutions(String solutions){
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
