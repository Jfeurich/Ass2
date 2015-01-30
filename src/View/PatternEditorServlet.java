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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static logic.Json.loadPattern;
import static logic.Json.savePattern;

public class PatternEditorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String button = req.getParameter("button");
        RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
        ArrayList<Pattern> patterns = loadPattern();
        // TODO uitvinden waarom dit niet werkt!
        if(button.equals("Add new pattern")){
            // Get the patterns from the JSP
            String name = req.getParameter("name");
            String consequences = req.getParameter("consequences");
            String allProblems = req.getParameter("problems");
            String allSolutions = req.getParameter("solutions");
            int totalTextfields = Integer.parseInt(req.getParameter("totalTextfields"));
            // Start saving the patterns
            PatternBuilder pb = PatternBuilderFactory.getInstance();
            ContextBuilder cb = ContextBuilderFactory.getInstance();
            pb.makePattern(name);
            cb.makeContext(name);
            // TODO UITVINDEN HOE WE DEZE DINGEN KUNNEN DOEN IN DE JSP
            String fileName = req.getParameter("fileName");
            File file = new File(req.getServletContext().getAttribute("file")+File.separator+fileName);
            if(!file.exists()){
                throw new ServletException("File doesn't exist on server.");
            }
            //System.out.println("File location on server::"+file.getAbsolutePath());
            ServletContext ctx = getServletContext();
            InputStream fis = new FileInputStream(file);
            String mimeType = ctx.getMimeType(file.getAbsolutePath());
            resp.setContentType(mimeType != null? mimeType:"application/octet-stream");
            resp.setContentLength((int) file.length());
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            ServletOutputStream os = resp.getOutputStream();
            byte[] bufferData = new byte[1024];
            int read=0;
            while((read = fis.read(bufferData))!= -1){
                os.write(bufferData, 0, read);
            }
            os.flush();
            os.close();
            fis.close();

            // save context categories in context
            for (int i = 0;i<totalTextfields;i++ ){
                String desc = req.getParameter("mytext"+Integer.toString(i));
                String catnam = req.getParameter("subcat"+Integer.toString(i));
                ContextCategory cc = new ContextCategory(desc,catnam);
                cb.addContextCategory(cc);
            }
            pb.addContext(cb.getContext());
            pb.addDiagram(file);
            pb.setAllSolutions(allSolutions);
            pb.setConsequences(consequences);
            pb.setProblems(allProblems);
            for(Pattern p : patterns){
                if(p.getName().equals(pb.getPattern().getName())){
                    patterns.remove(p);
                    patterns.add(pb.getPattern());
                }
                else{
                    patterns.add(pb.getPattern());
                }
            }
            //Sla de ArrayList weer op
            savePattern(patterns);
            rd = req.getRequestDispatcher("PatternEditorSave.jsp");
        }
        else if(button.equals("cancel")){
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }else if(button.equals("Import patterns")){
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }
        else if(button.equals("Export patterns")){
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }
        rd.forward(req, resp);
    }
}