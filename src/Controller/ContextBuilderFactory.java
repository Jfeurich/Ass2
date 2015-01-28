package Controller;

/**
 * Created by Elvira on 28-1-2015.
 */

import Model.Context;

public class ContextBuilderFactory {
    private static ContextBuilder instance = new ContextBuilder();

    private ContextBuilderFactory(){};

    public static ContextBuilder getInstance(){ return instance;}
}
