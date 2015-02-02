package Model;

/**
 * Created by jayfeurich on 28/01/15.
 */
public class ContextCategory {
    private String description;
    private String categoryName;

    public ContextCategory(String des, String catName){
        this.description = des;
        this.categoryName = catName;
    }
    /*de naamgeving van deze klasse komt uit een tijd dat een contextcategorie of scope of purpose of iets anders kon zijn dat
    * vrij te definieren was in het systeem. Helaas bleek de implementatie van een variabele hoeveelheid van contextcategorieen
    * in het systeem niet praktisch vanwege technische problemen.*/

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
