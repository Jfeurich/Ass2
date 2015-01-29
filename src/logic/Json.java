package logic;

import Model.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Json  {
	public static void savePattern(ArrayList<Pattern> p){
	Gson gson = new Gson();
	JsonElement element = gson.toJsonTree(p, new TypeToken<ArrayList<Pattern>>() {}.getType());
	JsonArray jsonArray = element.getAsJsonArray();
	String json = gson.toJson(jsonArray);
	try {
		//write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter("JsonObjects/jsonobjects.json");
		writer.write(json);
		writer.close();
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
}

	public static ArrayList<Pattern> loadPattern(){
	    ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	    Gson gson = new Gson();
	    JsonParser jsonParser = new JsonParser();
	    try {
	        BufferedReader br = new BufferedReader(new FileReader("JsonObjects/jsonobjects.json"));
	        JsonElement jsonElement = jsonParser.parse(br);

	        //Create generic type
	        Type type = new TypeToken<ArrayList<Pattern>>() {}.getType();
	        return gson.fromJson(jsonElement, type);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return patterns;        
	}
}	
