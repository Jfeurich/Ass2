package logic;
import Model.Pattern;

import java.io.*;
import java.util.ArrayList;

public abstract class Disk implements FileInterface{
    @Override
	public void savePattern(ArrayList<Pattern> p){
	    try {
			FileOutputStream fos = new FileOutputStream("C:\\apache-tomcat-7.0.39\\apache-tomcat-7.0.39\\webapps\\Ass2\\WEB-INF\\JsonObjects");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
	      	oos.writeObject(p);
	      	oos.close();
	    }  
	    catch(IOException ex){
	      ex.printStackTrace();
	    }
	}
    @Override
    public ArrayList<Pattern> loadPattern(){
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	
		try {
		FileInputStream fis = new FileInputStream("C:\\apache-tomcat-7.0.39\\apache-tomcat-7.0.39\\webapps\\Ass2\\WEB-INF\\JsonObjects");

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
