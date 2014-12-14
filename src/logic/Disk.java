package logic;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.Pattern;

public class Disk {
	public static void savePattern(ArrayList<Pattern> p){
	    try (
	      FileOutputStream fos = new FileOutputStream("JsonObjects/objects.json");
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	    ){
	      oos.writeObject(p);
	      oos.close();
	    }  
	    catch(IOException ex){
	      ex.printStackTrace();
	    }
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Pattern> loadPattern(){
		ArrayList<Pattern> patterns = new ArrayList<>();
	
		try {
		FileInputStream fis = new FileInputStream("JsonObjects/objects.json");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			patterns =(ArrayList<Pattern>) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return patterns;
	}
}
