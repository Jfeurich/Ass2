package View;
import java.util.ArrayList;

import Model.Category;
import Model.Pattern;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pattern> patterns = new ArrayList<>();
		ArrayList<Category> category = new ArrayList<>();
		Category c1 = new Category("Purpose","Creational");
		Category c2= new Category("Purpose", "Structural");
		Category c3 = new Category("Purpose","Behavioral");
		Category c4 = new Category("By Scope","Class");
		Category c5 = new Category("By Scope","Object");
		category.add(c1);
		category.add(c2);
		category.add(c3);
		category.add(c4);
		category.add(c5);
	//	patterns.add()
		
		
		Pattern p = new Pattern("","");
		patterns.add(p);
		
		EditorFrame EF = new EditorFrame();
		SelectorFrame MF = new SelectorFrame(patterns);
		
		
	
	}

}
