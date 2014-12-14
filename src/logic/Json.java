package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class Json {
	public static void savePattern(ArrayList<Pattern> p,String filename){
	String fn;
	Gson gson = new Gson();
	JsonElement element = gson.toJsonTree(p, new TypeToken<ArrayList<Pattern>>() {}.getType());
	JsonArray jsonArray = element.getAsJsonArray();
	String json = gson.toJson(jsonArray);
	try {
		//write converted json data to a file named "file.json"
		if(filename != null){
			fn = "JsonObjects/objects.json";
		}
		else{
			fn = "JsonObjects/" + filename + ".json";
		}
		FileWriter writer = new FileWriter(fn);
		writer.write(json);
		writer.close();
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
}

public static ArrayList<Pattern> loadPattern(){
	ArrayList<Pattern> patterns = new ArrayList<>();
	
	Gson gson = new Gson();
	JsonElement element = gson.toJsonTree(patterns, new TypeToken<ArrayList<Pattern>>() {}.getType());
	try {
		BufferedReader br = new BufferedReader(new FileReader("JsonObjects/objects.json"));
		JsonParser jsonParser = new JsonParser();
		String json = gson.toJson(br);
		JsonArray ja = (JsonArray) jsonParser.parse(json);
		//j
		//convert the json string back to object

		//Pattern obj = gson.fromJson(br, Pattern.class);
		//patterns.add(obj);
	} catch (IOException e) {
		e.printStackTrace();
	}
		return patterns;		
	}
}	
