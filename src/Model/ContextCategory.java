package Model;

/**
 * Created by jayfeurich on 28/01/15.
 */
public class ContextCategory {
    private String description;
    private String categoryName;
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String des){ this.description = des;}
}