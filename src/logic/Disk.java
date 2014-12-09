package logic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Model.Pattern;

import com.google.gson.Gson;

public class Disk {
	public void savePattern(){
		 
		Pattern obj = new Pattern(null, null);
		Gson gson = new Gson();
	 
		// convert java object to JSON format,
		// and returned as JSON formatted string
		
		String json = gson.toJson(obj);
	 
		try {
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("/Users/jayfeurich/" + obj.getName() + ".json");
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		System.out.println(json);
	}
	public void loadPattern(){
		Gson gson = new Gson();
		 
		try {
	 
			BufferedReader br = new BufferedReader(
				new FileReader("/Users/jayfeurich/filename.json"));
	 
			//convert the json string back to object
			Pattern obj = gson.fromJson(br, Pattern.class);
	 
			System.out.println(obj);
	 
		} catch (IOException e) {
			e.printStackTrace();
		}

				
		
	}

}
