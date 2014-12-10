package Test;

import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
public class GsonTest {

	public GsonTest(){
		
	}
	
		public void write() throws IOException{
			File file = new File("C:/Users/Elvira/Documents/Output.json");
			try (
					
					Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")){		
			Gson gson = new GsonBuilder().create();
			gson.toJson("Facade Pattern", writer);
			gson.toJson("Behavioural", writer);
			System.out.println("Json bestand aangemaakt");
		}
	}
}
