package View;

/**
 * Created by jayfeurich on 28/01/15.
 */
import Controller.ContextBuilder;
import Controller.PatternBuilder;
import Model.Context;
import Model.Pattern;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatternEditorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String button = req.getParameter("button");
        RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
        if(button.equals("save")){
            PatternBuilder pb = new PatternBuilder();
            ContextBuilder cb = new ContextBuilder();

            Pattern pattern = pb.makePattern("");
            Context context = cb.makeContext("description",pb.getPatternName());
            pb.addContext();
            pb.addDiagram();
            pb.setAllSolutions();
            pb.setConsequences();
            pb.setProblems();

        }
        else if(button.equals("cancel")){
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }
        rd.forward(req, resp);
    }
}

