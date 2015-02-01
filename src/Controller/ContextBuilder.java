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
    public void makeContext(String name){
        Context context = new Context(name);
        this.context = context;
    }
    public Context getContext(){
        return this.context;
    }
    public void setContext(Context c){
        this.context = c;
    }
    public void setName (String name){
        context.setName(name);
    }
    public void setContextCategory(ArrayList<ContextCategory> ccArrayList) {
        context.getContextCategory();
    }
    public void addContextCategory(ContextCategory cc){context.addToContext(cc);}
}
