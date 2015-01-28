package Controller;

public class PatternBuilderFactory {
    private static PatternBuilder instance = new PatternBuilder();
    private PatternBuilderFactory(){};
    public static PatternBuilder getInstance(){
        return instance;
    }
}

