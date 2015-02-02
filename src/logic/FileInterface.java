package logic;

import Model.Pattern;
import java.util.ArrayList;

/**
 * Created by jayfeurich on 02/02/15.
 */
public interface FileInterface {
    public void savePattern(ArrayList<Pattern> p);
    public ArrayList<Pattern> loadPattern();
}
