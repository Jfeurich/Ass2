package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;

public class Pattern implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2262846250404779815L;
	private String name;
	private String allConsequences;
	private Context context;
	private ArrayList<String> allProblems;
	private ArrayList<String> allSolutions;
	private File diagram;
	
	public Pattern(String nm){
		name =nm;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public File getDiagram(){
		return diagram;
	}
	
	public void setDiagram(File dia){
		this.diagram = dia;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public String getAllConsequences() {
		return allConsequences;
	}

	public void setAllConsequences(String allConsequences) {
		this.allConsequences = allConsequences;
	}

	public ArrayList<String> getAllProblems() {
		return allProblems;
	}

	public void setAllProblems(ArrayList<String> allProblems) {
		this.allProblems = allProblems;
	}
	public ArrayList<String> getAllSolutions() {
		return allSolutions;
	}

	public void setAllSolutions(ArrayList<String> allProblems) {
		this.allSolutions = allSolutions;
	}
}
