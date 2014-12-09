package Controller;
import java.util.ArrayList;

import Model.Pattern;

public class PatternRepository implements Container {
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();

	public Iterator getIterator(){
		return new PatternIterator();
	}

}