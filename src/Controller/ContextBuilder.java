package Controller;
import Model.Context;
import Model.ContextCategory;

import java.util.ArrayList;

/**
 * Created by jayfeurich on 28/01/15.
 */
public class ContextBuilder {
    private Context context;
    private ArrayList<ContextCategory> contextArray = new ArrayList<ContextCategory>();
    public Context makeContext(String desc,String name){
        Context contextS= new Context(name);
        return context;
    }

    public void setName (String name){context.setName(name);}
    public void setContextCategory(ArrayList<ContextCategory> context) { this.contextArray = context; }

}
