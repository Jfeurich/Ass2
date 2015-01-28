package Controller;

import Model.Pattern;

public class PatternBuilder {
	public Pattern makePattern(String prob, String img, String sol, String consequence){
		Pattern p = new Pattern(prob,sol,consequence);
		return p;
	}

}
