package Controller;

import Model.Pattern;

public class PatternBuilder {
	public Pattern makePattern(String name){
		Pattern p = new Pattern(name);
		return p;
	}

}
