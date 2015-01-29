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
    public Context getContext(){
        return this.context;
    }
    public void setContext(Context c){
        this.context = c;
    }
    public void setName (String name){
        context.setName(name);
    }
    public void setContextCategory(ArrayList<ContextCategory> context) {
        this.contextArray = context;
    }
    public void addContextCategory(ContextCategory cc){context.addToContext(cc);}
}
