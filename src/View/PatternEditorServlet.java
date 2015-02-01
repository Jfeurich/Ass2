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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static logic.Json.loadPattern;
import static logic.Json.savePattern;

public class PatternEditorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
            String button = req.getParameter("button");
            System.out.println(button +"loldongs");
            RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
            ArrayList<Pattern> patterns = loadPattern();
            if (patterns == null) {
                patterns = new ArrayList<Pattern>();
            }
            // TODO uitvinden waarom dit niet werkt!
            if (button.equals("Add new pattern")) {
                // Get the patterns from the JSP

                String name = req.getParameter("name");
                String consequences = req.getParameter("consequences");
                String allProblems = req.getParameter("problems");
                String allSolutions = req.getParameter("solutions");
                int totalTextfields = Integer.parseInt(req.getParameter("totalTextfields"));

                // Try to load a file into this pattern
                // TODO UITVINDEN HOE WE DEZE DINGEN KUNNEN DOEN IN DE JSP
//            String fileName = req.getParameter("fileName");
//            File file = new File(req.getServletContext().getAttribute("file")+File.separator+fileName);
//            if(!file.exists()){
//                throw new ServletException("File doesn't exist on server.");
//            }
                //System.out.println("File location on server::"+file.getAbsolutePath());
//            ServletContext ctx = getServletContext();
//            InputStream fis = new FileInputStream(file);
//            String mimeType = ctx.getMimeType(file.getAbsolutePath());
//            resp.setContentType(mimeType != null? mimeType:"application/octet-stream");
//            resp.setContentLength((int) file.length());
//            resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//            ServletOutputStream os = resp.getOutputStream();
//            byte[] bufferData = new byte[1024];
//            int read=0;
//            while((read = fis.read(bufferData))!= -1){
//                os.write(bufferData, 0, read);
//            }
//            os.flush();
//            os.close();
//            fis.close();

                //Store stuff in pattern
                PatternBuilder pb = PatternBuilderFactory.getInstance();
                ContextBuilder cb = ContextBuilderFactory.getInstance();
                Pattern p = new Pattern(name);
                Context c = cb.makeContext(name);
                for (int i = 0; i < totalTextfields; i++) {
                    String desc = req.getParameter("mytext" + Integer.toString(i));
                    String catName = req.getParameter("subcat" + Integer.toString(i));
                    ContextCategory cc = new ContextCategory(desc, catName);
                    c.addToContext(cc);
                }
                p.setContext(c);
//            pb.addDiagram(file);
                p.setAllSolutions(allSolutions);
                p.setAllConsequences(consequences);
                p.setAllProblems(allProblems);
                for (Pattern p1 : patterns) {
                    if (p1.getName().equals(p.getName())) {
                        patterns.remove(p1);
                        patterns.add(p);
                    } else {
                        patterns.add(p);
                    }
                }
                //Sla de ArrayList weer op
                savePattern(patterns);
                rd = req.getRequestDispatcher("PatternEditorSave.jsp");
            } else if (button.equals("Import patterns")) {
                rd = req.getRequestDispatcher("PatternSelector.jsp");
            } else if (button.equals("Export patterns")) {
                rd = req.getRequestDispatcher("PatternSelector.jsp");
            }
            rd.forward(req, resp);
    }
}