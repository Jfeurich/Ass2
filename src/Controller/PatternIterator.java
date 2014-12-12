package Controller;
public class PatternIterator implements Iterator{
	int index;
	public String patterns[] ={ "Facade","Iterator","Strategy"};
	//private ArrayList<Pattern> patterns = new ArrayList<Pattern>();


	public boolean hasNext(){
		if(index < patterns.length){
		return true;
		}
		return false;
	}

	public Object next(){
		if(this.hasNext()){
			return patterns[index++];
		}
		return null;
	}

}