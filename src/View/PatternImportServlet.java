package View;

import Model.Pattern;
import logic.Json;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;

public class PatternImportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("ImportPattern.jsp");
        Json json = new Json();
        String button = req.getParameter("button");
        //Create arrayLists
        ArrayList<Pattern> newpatterns = new ArrayList<Pattern>();
        ArrayList<Pattern> patterns = json.loadPattern();

        if (button.equals("Import Patterns")) {
            Part FilePart = req.getPart("file");
            String FileName = FilePart.getSubmittedFileName();
            InputStream initialStream = FilePart.getInputStream();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File targetFile = new File("..\\webapps\\Ass2\\WEB-INF\\JsonObjects\\"+FileName);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            outStream.close();
            newpatterns = json.loadPattern(targetFile.getCanonicalPath());
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
        rd.forward(req, resp);
    }
}
