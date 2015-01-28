package Controller;

public class PatternBuilderFactory {
    private static PatternBuilderFactory instance = new PatternBuilderFactory();
    private PatternBuilderFactory(){};
    public static PatternBuilderFactory getInstance(){
        return instance;
    }
}

