package Model;

public class Category implements Context{
	private String name;
	private String description;
	private Category category;

	public Category( String desc){
		description = desc;
	}
	
	public Category(String desc,String name){
		name = this.name;
		desc = this.description;
	}

	public String getDescription(){
		return description;
	}


	public void addCategory(Category c){

	}
	/*public Category getCategory(){
		return Category;
	}*/

	public Context getContext() {
		return category;
	}

	public void setContext(Category context) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}