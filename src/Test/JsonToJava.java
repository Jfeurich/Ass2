package Test;

import java.io.File;
import java.io.InvalidObjectException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonToJava {
	public JsonToJava(){
	}
	
	public void toJava() throws IOException{
		File file = new File("C:/Users/Elvira/Documents/Output.json");
		try (Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/Output.json"), "UTF-8")){
			Gson gson = new GsonBuilder().create();
			TestPattern p = gson.fromJson(reader, TestPattern.class);
			System.out.println(p);
		}
	}
}
