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
            Part FilePart = null;
            String FileName = null;
            try {
                FilePart = req.getPart("file");
                FileName = FilePart.getSubmittedFileName();
                System.out.println(FileName);
            } catch (Exception e) {
                System.out.println("wut");
                e.printStackTrace();
            }
            InputStream initialStream = FilePart.getInputStream();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File targetFile = new File("..\\webapps\\Ass2\\WEB-INF\\JsonObjects\\" + FileName);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            outStream.close();
            System.out.println(targetFile.getCanonicalPath());
            newpatterns = json.loadPattern(targetFile.getCanonicalPath());
            if (!newpatterns.isEmpty()) {
                rd = req.getRequestDispatcher("ImportPatternSuccesfull.jsp");
            } else {
                throw new FileNotFoundException("Missing file");
            }
        }
        else{
            rd = req.getRequestDispatcher("PatternEditor.jsp");
        }

        for(Pattern p : newpatterns){
            patterns.add(p);
        }
        rd.forward(req, resp);
    }
}
