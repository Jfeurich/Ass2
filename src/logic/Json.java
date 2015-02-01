package logic;

import Model.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Json  {
	public static void savePattern(ArrayList<Pattern> p){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(p, new TypeToken<ArrayList<Pattern>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String json = gson.toJson(jsonArray);
		File JsonFile = new File("/JsonObjects/jsonobjects.json");
		String jsonFilePath = JsonFile.getAbsolutePath();
		if(!JsonFile.exists()) {
			try {
				JsonFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter(jsonFilePath);
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
		File JsonFile = new File("/JsonObjects/jsonobjects.json");
		String jsonFilePath = JsonFile.getAbsolutePath();
		if(!JsonFile.exists()) {
			try {
				JsonFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(jsonFilePath));
			JsonElement jsonElement = jsonParser.parse(br);

			//Create generic type
			Type type = new TypeToken<ArrayList<Pattern>>() {}.getType();
			return gson.fromJson(jsonElement, type);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return patterns;
	}

	// import patterns
	public static ArrayList<Pattern> loadPattern(String filepath){

		String ext = FilenameUtils.getExtension(""+filepath);
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		// if fileextension = .json
		if(ext.contains(".json")) {
			File JsonFile = new File("" + filepath);
			String jsonFilePath = JsonFile.getAbsolutePath();
			if (!JsonFile.exists()) {
				try {
					JsonFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(jsonFilePath));
				JsonElement jsonElement = jsonParser.parse(br);

				//Create generic type
				Type type = new TypeToken<ArrayList<Pattern>>() {
				}.getType();
				return gson.fromJson(jsonElement, type);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return patterns;

	}
}