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
            RequestDispatcher rd = req.getRequestDispatcher("PatternEditor.jsp");
            ArrayList<Pattern> patterns = loadPattern();
            if (patterns == null) {
                patterns = new ArrayList<Pattern>();
            }
            // TODO uitvinden waarom dit niet werkt!
            if (button.equals("Add new pattern")) {
                String name = req.getParameter("name");
                String consequences = req.getParameter("consequences");
                String allProblems = req.getParameter("problems");
                String allSolutions = req.getParameter("solutions");
                int totalTextfields = Integer.
                        parseInt(req.getParameter("totalTextfields"));
                System.out.println(totalTextfields);
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
                pb.makePattern(name);
                cb.makeContext(name);
                for (int i = 0; i < totalTextfields; i++) {
                    String purpose = req.getParameter("mytext");
                    String scope = req.getParameter("subcat");
                    ContextCategory cc = new ContextCategory(purpose,scope);
                    System.out.println(purpose);
                    System.out.println(scope);
                    cb.addContextCategory(cc);
                }
                pb.addContext(cb.getContext());
//            pb.addDiagram(file);
                pb.setAllSolutions(allSolutions);
                pb.setProblems(allProblems);
                pb.setConsequences(consequences);
                // TODO: uitvinden waarom deze code ervoor zorgt dat Jsonobjects leeg blijft
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
                rd = req.getRequestDispatcher("PatternSelector.jsp");
            } else if (button.equals("Export patterns")) {
                rd = req.getRequestDispatcher("PatternSelector.jsp");
            }
            rd.forward(req, resp);
    }
}