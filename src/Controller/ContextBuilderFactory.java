package Controller;

/**
 * Created by Elvira on 28-1-2015.
 */

import Model.Context;

public class ContextBuilderFactory {
    private static ContextBuilderFactory instance = new ContextBuilderFactory();

    private ContextBuilderFactory(){};

    public static ContextBuilderFactory getInstance(){ return instance;}
}
