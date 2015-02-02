package View;

import Model.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static logic.Json.loadPattern;

public class PatternImportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("button");
        RequestDispatcher rd = req.getRequestDispatcher("ImportPattern.jsp");
        ArrayList<Pattern> patterns = new ArrayList<Pattern>();
        if (button.equals("Import Patterns")) {
            String fileName = req.getParameter("file");
            patterns = loadPattern(fileName);
            if (!patterns.isEmpty()) {
                rd = req.getRequestDispatcher("ImportPatternSuccesfull.jsp");
            } else {
                throw new FileNotFoundException("Missing file");
                // woohoo
            }
        }
    }
}