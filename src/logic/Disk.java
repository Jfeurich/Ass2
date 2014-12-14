package logic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class Disk {
	public static void savePattern(ArrayList<Pattern> p,String filename){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(p, new TypeToken<ArrayList<Pattern>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String json = gson.toJson(jsonArray);
		try {
			//write converted json data to a file named "file.json"
			if(filename != null){
				FileWriter writer = new FileWriter("JsonObjects/" + filename + ".json");
				writer.write(json);
				writer.close();
			}
			else{
				FileWriter writer = new FileWriter("JsonObjects/objects.json");
				writer.write(json);
				writer.close();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Pattern> loadPattern(){
		ArrayList<Pattern> patterns = new ArrayList<>();
		Gson gson = new Gson();
		 
		try {
			BufferedReader br = new BufferedReader(new FileReader("JsonObjects/objects.json"));
			//convert the json string back to object
			Pattern obj = gson.fromJson(br, Pattern.class);
			patterns.add(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return patterns;		
	}
}
