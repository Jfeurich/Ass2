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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static logic.Json.loadPattern;
import static logic.Json.savePattern;
@WebServlet
@MultipartConfig
public class PatternEditorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
            String button = req.getParameter("button");
            RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
            ArrayList<Pattern> patterns = loadPattern();
            if (patterns == null) {
                patterns = new ArrayList<Pattern>();
            }
            // if button is pressed do action
            if (button.equals("Add new pattern")) {
                // Haal de waarden op uit de servlet en sla ze op in een collection van parts.

                String name = req.getParameter("name");;
                String consequences = req.getParameter("conseqences");
                String allProblems = req.getParameter("problems");
                String allSolutions = req.getParameter("solutions");
                String purpose = req.getParameter("mytext");
                String scope = req.getParameter("subcat");

                //save file in pattern

//                Part FilePart = req.getPart("file");
//                InputStream imageInputStream = FilePart.getInputStream();
//                int i = imageInputStream.available();
//                byte[]b = new byte[i];
//                imageInputStream.read(b);
//                String FileName = FilePart.getSubmittedFileName();
//                FileOutputStream fos = new FileOutputStream(FileName);
//                fos.write(b);
//                imageInputStream.close();
                //File file = new File(FileName);

                //Store everything in pattern
                //todo uitzoeken waarom builder niet werkt
                PatternBuilder pb = PatternBuilderFactory.getInstance();
                ContextBuilder cb = ContextBuilderFactory.getInstance();
                pb.makePattern(name);
                cb.makeContext(name);
                ContextCategory cc = new ContextCategory(purpose,scope);
                cb.addContextCategory(cc);
                pb.addContext(cb.getContext());
                //pb.addDiagram(file);
                pb.setAllSolutions(allSolutions);
                pb.setProblems(allProblems);
                pb.setConsequences(consequences);

                // TODO: find out why the file stays empty
//                for (Pattern p : patterns) {
//                    if (p.getName().equals(pb.getPattern().getName())) {
//                        patterns.remove(p);
//                        patterns.add(pb.getPattern());
//                        savePattern(patterns);
//                    } else {
//                        patterns.add(pb.getPattern());
//                        savePattern(patterns);
//                    }
//                }
                patterns.add(pb.getPattern());
                savePattern(patterns);
                rd = req.getRequestDispatcher("PatternSelector.jsp");
            } else if (button.equals("Import patterns")) {
                rd = req.getRequestDispatcher("ImportPattern.jsp");
            } else if (button.equals("Export patterns")) {
                rd = req.getRequestDispatcher("PatternSelector.jsp");
            }
            rd.forward(req, resp);
    }
}