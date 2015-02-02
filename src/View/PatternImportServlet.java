package View;

import Model.Pattern;
import logic.Json;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PatternImportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Json json = new Json();
        String button = req.getParameter("button");
        RequestDispatcher rd = req.getRequestDispatcher("ImportPattern.jsp");
        ArrayList<Pattern> newpatterns = new ArrayList<Pattern>();
        ArrayList<Pattern> patterns = json.loadPattern();
        if (button.equals("Import Patterns")) {
            String fileName = req.getParameter("file");
            newpatterns = json.loadPattern(fileName);
            if (!newpatterns.isEmpty()) {
                rd = req.getRequestDispatcher("ImportPatternSuccesfull.jsp");
            } else {
                throw new FileNotFoundException("Missing file");
                // woohoo
            }
        }
        for(Pattern p : newpatterns){
            patterns.add(p);
        }
        rd = req.getRequestDispatcher("ImportPatternSuccesfull.jsp");
        rd.forward(req, resp);
    }
}
