package Model;

public class Context{
	private String name;
	private String description;
	private Context context;

	public Context( String desc){
		description = desc;
	}
	
	public Context(String desc,String name){
		name = this.name;
		desc = this.description;
	}

	public String getDescription(){
		return description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
}