<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 30-1-2015
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Model.Context" %>
<%@ page import="Model.ContextCategory" %>
<%@ page import="Model.Pattern" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.Disk" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="Header.jsp" >
  <jsp:param name="titel" value="Accountgegevens wijzigen" />
</jsp:include>


<html>
<head>
    <title></title>
</head>
<body>
</br></br></br>
<div class="patterninfo">
    <div class="labelinfo">
        <span class="note">
            You have chosen the category:<b><%= request.getParameter("categorynamelist") %></b><br>
            and the subtype:<b><%= request.getParameter("subtypelist") %></b><br>
        </span>
    </div>
    <%

        Pattern p = new Pattern("Builder Pattern");
        p.setAllProblems("An application needs to create the elements of a complex aggregate. ");
        Pattern p2 = new Pattern("Adapter Pattern");
        p2.setAllProblems("You want to use an existing class, and its interface does not match the interface you need.;" +
                "You want to use an object in an environment that expects an interface that is different from the object's interface.");

        p.setAllConsequences("The pattern lets you vary a product's internal representation.;The pattern gives you finer control over the construction process.;The pattern isolates code for construction and representation.;");
        p2.setAllConsequences("The pattern allows for preexisting objects to fit into new class structures without being limited by their interfaces ");

        // file test
        File file = new File("\\images\\rodepanda.png");

        p.setDiagram(file);



        Context c = new Context(p.getName());
        Context co2 = new Context(p2.getName());
        ContextCategory ccg2 = new ContextCategory("Structural","By Purpose");
        ContextCategory ccg = new ContextCategory("Object","By Scope");
        c.addToContext(ccg);
        co2.addToContext(ccg2);
        p.setContext(c);
        p2.setContext(co2);

        ArrayList<Pattern> allePatterns = new ArrayList<Pattern>();
        // ArrayList<Pattern> allePatterns = Disk.loadPattern();
        ArrayList<Context> alleContext = new ArrayList<Context>();
        ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();
        allePatterns.add(p);
        allePatterns.add(p2);%>
    </div></br>

    <div class="Pattern">
       <!-- <select name="sometext4" size="5">-->
         <%
             for(Pattern p99 :allePatterns){

                for(ContextCategory cc : p99.getContext().getContextCategory()){
                // get the selected value from the selectlists.
                String categorySelected = request.getParameter("categorynamelist");
                String subtypeSelected = request.getParameter("subtypelist");

                // if selected value from categorynamelist equals the name in the pattern
                if (cc.getCategoryName().equals(categorySelected)) {
                    // if selected value from subtypelist equals the name in the pattern
                    if (subtypeSelected.equals(cc.getDescription())) {
                    // then put the pattername as a option in the patterns-selectlist
                        String problem = p99.getAllProblems();
                        String name = p99.getName();
                        problem = problem.replaceAll("(;)", "<br /><li>");

                        String consequences = p99.getAllConsequences();
                        consequences = consequences.replaceAll("(;)","<br/><li>");

                        file = p99.getDiagram();
                        String url = request.getRequestURL().toString();
                        String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
                        String filename = baseURL + "/images/" +file.getName();

                     %>

                    <div class="pattername"><%=name%></div>
                    <span class="title">Problems:</span></br>
                    <span class="problem"><ul><li><%=problem%></li></ul></span>
                    <span class="title">Consequences:</span></br>
                    <span class="consequences"><ul><li><%=consequences%></li></ul></span>
                    </br>
        Image pattern:</br>
                    <span class="file"><img src="<%=filename%>"></span>
                    </br>
        Image :</br>
        <img src="c:/Users/Elvira/Desktop/websiteuitleg/images/groot/rodepanda2.png">
                    </div>
                    <div class="select">
                        <input type="submit" name="<%=p99.getName()%>" value="Select this Pattern">
                    </div>
                  <%  }
                }

            }
            }
            %>
       <!-- </select>-->

        </div>
  </body>
</html>
