package View;

/**
 * Created by jayfeurich on 28/01/15.
 */
import Controller.ContextBuilder;
import Controller.ContextBuilderFactory;
import Controller.PatternBuilder;
import Controller.PatternBuilderFactory;
import Model.Context;
import Model.ContextCategory;
import Model.Pattern;
import logic.Disk;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatternEditorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        if(button.equals("Add new pattern")){
            // Get the patterns from the JSP
            String consequences = req.getParameter("consequences");
            String name = req.getParameter("name");
            String allProblems = req.getParameter("problems");
            String allSolutions = req.getParameter("solutions");
            int totalTextfields = Integer.parseInt(req.getParameter("totalTextfields"));
            // Start saving the patterns
            PatternBuilder pb = PatternBuilderFactory.getInstance();
            ContextBuilder cb = ContextBuilderFactory.getInstance();
            pattern = pb.makePattern(name);
            Context context = cb.makeContext("description",pb.getPatternName());
            // Save image as file
            String fileName = req.getParameter("fileName");
            File file = new File(req.getServletContext().getAttribute("file")+File.separator+fileName);
            if(!file.exists()){
                throw new ServletException("File doesn't exists on server.");
            }
            System.out.println("File location on server::"+file.getAbsolutePath());
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
            pb.addContext(context);
            pb.addDiagram(file);
            pb.setAllSolutions(allSolutions);
            pb.setConsequences(consequences);
            pb.setProblems(allProblems);
            for(Pattern patty : patterns){

                if(patty.getName().equals(pattern.getName())){
                    patterns.remove(patty);
                    patterns.add(pattern);
                    finished = true;

                }
                else{
                    patterns.add(pattern);
                    finished = true;
                }
            }
            //Sla de ArrayList weer op
            Disk.savePattern(patterns);
            rd = req.getRequestDispatcher("PatternEditorSave.jsp");
        }
        else if(button.equals("cancel")){
            rd = req.getRequestDispatcher("PatternSelector.jsp");
        }
        rd.forward(req, resp);
    }
}