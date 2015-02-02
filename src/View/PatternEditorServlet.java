package View;

/**
 * Created by jayfeurich on 28/01/15.
 */

import Controller.ContextBuilder;
import Controller.ContextBuilderFactory;
import Controller.PatternBuilder;
import Controller.PatternBuilderFactory;
import Model.ContextCategory;
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
public class PatternEditorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String button = req.getParameter("button");
        RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
        Json json = new Json();
        ArrayList<Pattern> patterns = json.loadPattern();
        if (patterns == null) {
            patterns = new ArrayList<Pattern>();
        }
        // if button is pressed do action
        if (button.equals("Add new pattern")) {
            // Haal de waarden op uit de servlet en sla ze op in een collection van parts.

            String name = req.getParameter("name");;
            String consequences = req.getParameter("consequences");
            String allProblems = req.getParameter("problems");
            String allSolutions = req.getParameter("solutions");
            String purpose = req.getParameter("mytext");
            String scope = req.getParameter("subcat");

            //save file in pattern

            Part FilePart = req.getPart("file");
            String FileName = FilePart.getSubmittedFileName();
            InputStream initialStream = FilePart.getInputStream();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File targetFile = new File("..\\webapps\\Ass2\\images\\" + FileName);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            outStream.close();

            //Store everything in pattern

            PatternBuilder pb = PatternBuilderFactory.getInstance();
            ContextBuilder cb = ContextBuilderFactory.getInstance();
            pb.makePattern(name);
            cb.makeContext(name);
            ContextCategory cc = new ContextCategory(purpose,scope);
            cb.addContextCategory(cc);
            pb.addContext(cb.getContext());
            pb.addDiagram(targetFile);
            pb.setAllSolutions(allSolutions);
            pb.setProblems(allProblems);
            pb.setConsequences(consequences);

            if (patterns.contains(pb.getPattern())) {
                patterns.remove(patterns.indexOf(pb.getPatternName()));
                patterns.add(pb.getPattern());
            }
            else {
                patterns.add(pb.getPattern());
                json.savePattern(patterns);
            }
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }
        rd.forward(req, resp);
    }
}