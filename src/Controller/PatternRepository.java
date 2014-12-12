package Controller;
import java.util.ArrayList;

import Model.Pattern;

public class PatternRepository implements Container {
	   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

	   @Override
	   public Iterator getIterator() {
	      return new PatternIterator();
	   }

	   private class PatternIterator implements Iterator {

	      int index;

	      @Override
	      public boolean hasNext() {
	         if(index < names.length){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	         if(this.hasNext()){
	            return names[index++];
	         }
	         return null;
	      }		
	   }
	}