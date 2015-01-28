package Controller;
import Model.Context;

import java.util.ArrayList;

/**
 * Created by jayfeurich on 28/01/15.
 */
public class ContextBuilder {
    private Context context;
    private ArrayList<Context> contextArray = new ArrayList<Context>();
    public Context makeContext(String desc,String name){
        Context contextS= new Context(desc,name);
        return context;
    }

    public void setDescription(String des){ context.setDescription(des);}
    public void setName (String name){context.setName(name);}
    public void setContext(ArrayList<Context> context) { this.contextArray = context; }

}
