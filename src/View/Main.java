	package View;
import java.util.ArrayList;
import java.util.Iterator;
import logic.Disk;
import Model.Pattern;
import Controller.PatternRepository;

public class Main {
	public static void main(String[] args) {
		ArrayList<Pattern> patterns = Disk.loadPattern();
		EditorFrame EF = new EditorFrame(patterns);
		//SelectorFrame MF = new SelectorFrame(patterns);
		
		PatternRepository patternRepository = new PatternRepository();
		 for(Controller.Iterator iter = patternRepository.getIterator(); iter.hasNext();){
	         String name = (String)iter.next();
	         System.out.println("Pattern : " + name);
	      } 	
	
	}

}
