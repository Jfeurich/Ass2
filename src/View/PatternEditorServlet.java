package View;

/**
 * Created by jayfeurich on 28/01/15.
 */
import Controller.ContextBuilder;
import Controller.ContextBuilderFactory;
import Controller.PatternBuilder;
import Controller.PatternBuilderFactory;
import Model.Context;
import Model.Pattern;
import logic.Disk;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatternEditorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        boolean finished = false;
        String button = req.getParameter("button");
        RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
        String p = req.getParameter("pattern");
        ArrayList<Pattern> patterns = Disk.loadPattern();
        Pattern pattern = null;
        for(Pattern pat: patterns){
            if(pat.getName().equals(p)){
                pattern = pat;
            }
        }

        if(button.equals("save")){
            //als het pattern opgeslagen moet worden dan
            PatternBuilder pb = PatternBuilderFactory.getInstance();
            ContextBuilder cb = ContextBuilderFactory.getInstance();
            pattern = pb.makePattern("");
            Context context = cb.makeContext("description",pb.getPatternName());
            // Haal de waarden op uit de JSP
            String consequences = req.getParameter("consequences");
            File diagram = req.get
            pb.addContext();
            pb.addDiagram();
            pb.setAllSolutions();
            pb.setConsequences();
            pb.setProblems();
            for(Pattern patty : patterns){
                //kijk of object al in de arraylist zit zo ja vervang object
                if(patty.getName().equals(pattern.getName())){
                    patterns.remove(patty);
                    patterns.add(pattern);
                    finished = true;

                }
                //voeg object toe aan de arraylist
                else{
                    patterns.add(pattern);
                    finished = true;
                }
            }
            //Sla de ArrayList weer op
            Disk.savePattern(patterns);
            rd = req.getRequestDispatcher("PatternViewer.jsp");
        }
        else if(button.equals("cancel")){
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }
        rd.forward(req, resp);
    }
}

