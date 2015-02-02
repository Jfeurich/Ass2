package View;

import Model.Pattern;
import logic.Json;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
@WebServlet
@MultipartConfig
public class PatternImportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("ImportPattern.jsp");
        Json json = new Json();
        String button = req.getParameter("button");
        //Create arrayLists
        ArrayList<Pattern> newpatterns = new ArrayList<Pattern>();
        ArrayList<Pattern> patterns = json.loadPattern();

        if (button.equals("Import Patterns")){
            Part FilePart = req.getPart("file");
            InputStream initialStream = FilePart.getInputStream();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File targetFile = new File("..\\webapps\\Ass2\\WEB-INF\\JsonObjects\\test.json");
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            outStream.flush();
            outStream.close();
            try {
                newpatterns = json.loadPattern(targetFile.getAbsolutePath());
            }
            catch (Exception e) {
                rd = req.getRequestDispatcher("ImportPatternFail.jsp");
                e.printStackTrace();
            }
            if (!newpatterns.isEmpty()) {
                if (!patterns.isEmpty()){
                    try {
                        for (Pattern p : newpatterns) {
                            patterns.add(p);
                        }
                    }
                    catch (Exception e) {
                        rd = req.getRequestDispatcher("ImportPatternFail.jsp");
                        e.printStackTrace();
                    }
                }
                else {
                    throw new FileNotFoundException("Missing file");
                }
                rd = req.getRequestDispatcher("ImportPatternSuccesfull.jsp");
                //json.savePattern(patterns);
            }
            rd.forward(req, resp);
        }
    }
}