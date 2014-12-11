package logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import Model.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Disk {
<<<<<<< HEAD
	public void savePattern(ArrayList<Pattern> p){
=======
	private String problem;
	private String solution;
	private String consequence;
	
	public Disk(String prob, String sol, String cons){
		problem= prob;
		solution = sol;
		consequence = cons;
	}
	
	public void write() throws IOException{
		File file = new File("Output2.json");
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")){		
		Gson gson = new GsonBuilder().create();
		gson.toJson("Nieuwe Pattern", writer);
		gson.toJson(problem, writer);
		gson.toJson(solution, writer);
		gson.toJson(consequence,writer);
		System.out.println("Json bestand aangemaakt");
		}
	}
	
	public Pattern savePattern(){
>>>>>>> FETCH_HEAD
		 
		ArrayList<Pattern> obj = p;
		Gson gson = new Gson();
	 
		// convert java object to JSON format,
		// and returned as JSON formatted string
		
		String json = gson.toJson(obj);
	 
		try {
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("/Users/jayfeurich/allepatterns.json");
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		System.out.println(json);
		return obj;
	}

	public ArrayList<Pattern> loadPattern(File f){
		ArrayList<Pattern> patterns = new ArrayList<>();
		Gson gson = new Gson();
		 
		try {
	 
			BufferedReader br = new BufferedReader(new FileReader(f));
	 
			//convert the json string back to object
			Pattern obj = gson.fromJson(br, Pattern.class);
	 
			patterns.add(obj);
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return patterns;		
	}

}
