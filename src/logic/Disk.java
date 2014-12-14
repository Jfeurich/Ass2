package logic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Model.Pattern;
import com.google.gson.Gson;

public class Disk {
	
	public static void savePattern(ArrayList<Pattern> p){
		Gson gson = new Gson();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(p);
		try {
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("/Pattern_selector/JsonObjects/objects.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Pattern> loadPattern(){
		ArrayList<Pattern> patterns = new ArrayList<>();
		Gson gson = new Gson();
		 
		try {
	 
			BufferedReader br = new BufferedReader(new FileReader("/Pattern_selector/JsonObjects/objects.json"));
	 
			//convert the json string back to object
			Pattern obj = gson.fromJson(br, Pattern.class);
	 
			patterns.add(obj);
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return patterns;		
	}

}
