package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Context implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -3517773272687672543L;
	private String patternname;

	private ArrayList<ContextCategory> context = new ArrayList<ContextCategory>();

	public Context(String patternname) {
		patternname = this.patternname;
	}


	public String getName() {
		return patternname;
	}

	public void setName(String name) {
		this.patternname = name;
	}

	public ArrayList<ContextCategory> getContextCategory() {
		return context;
	}

	public void setContext(ArrayList<ContextCategory> context) {
		this.context = context;
	}

	public void addToContext(ContextCategory c) {
		context.add(c);
	}
}

