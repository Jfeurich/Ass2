package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Context implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3517773272687672543L;
	private String Patternname;
	private String description;
	private ArrayList<Context> context = new ArrayList<Context>();

	public Context( String desc){
		description = desc;
	}
	
	public Context(String desc,String name){
		name = this.Patternname;
		desc = this.description;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String des){ this.description = des;}
	
	public String getName() {
		return Patternname;
	}

	public void setName(String name) {
		this.Patternname = name;
	}

	public ArrayList<Context> getContext() {
		return context;
	}

	public void setContext(ArrayList<Context> context) {
		this.context = context;
	}

	public void addToContext(Context c){
		context.add(c);
	}
}