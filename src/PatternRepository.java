import java.util.ArrayList;

public class PatternRepository implements Container {
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();

	public Iterator getIterator(){
		return new PatternIterator();
	}

}