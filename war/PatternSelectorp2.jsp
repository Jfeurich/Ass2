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
<%@ page import="logic.Json" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="Header.jsp" >
    <jsp:param name="titel" value="Accountgegevens wijzigen" />
</jsp:include>


<html>
    <head>
        <title></title>
    </head>
<%

    ArrayList<Pattern> allePatterns = Json.loadPattern();
    ArrayList<Context> alleContext = new ArrayList<Context>();
    ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();

    String name = null;
    String problem = null;
    String consequences = null;
    String filename=null;
    Pattern p = null;
    for (Pattern p99 : allePatterns) {
        for (ContextCategory cc : p99.getContext().getContextCategory()) {
            // get the selected value from the selectlists.
            String categorySelected = request.getParameter("categorynamelist");
            String subtypeSelected = request.getParameter("subtypelist");
            // if selected value from categorynamelist equals the name in the pattern
            if (cc.getCategoryName().equals(categorySelected)) {
                // if selected value from subtypelist equals the name in the pattern
                if (subtypeSelected.equals(cc.getDescription())) {
                    // then put the pattername as a option in the patterns-selectlist
                    p = p99;
                    problem = p99.getAllProblems();
                    name = p99.getName();
                    problem = problem.replaceAll("(;)", "<br /><li>");

                    consequences = p99.getAllConsequences();
                    consequences = consequences.replaceAll("(;)", "<br/><li>");

                    File file = p99.getDiagram();
                    String url = request.getRequestURL().toString();
                    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
                    filename = baseURL + "/images/" + file.getName();
                }
            }
        }
    }

%>
    <body>
    </br></br></br>
        <div class="patterninfo">
        <div class="labelinfo">
            <span class="note">
            You have chosen the category:<b><%=request.getParameter("categorynamelist")%></b><br>
            and the subtype:<b><%=request.getParameter("subtypelist")%></b><br>
            </span>
        </div>
        <form action="PatternSelectorp3.jsp" method="GET" >
            </div></br>

            <div class="Pattern">
            <!-- <select name="sometext4" size="5">-->


            <div class="pattername"><%=name%></div>
            <span class="title">Problems:</span></br>
            <span class="problem"><ul><li><%=problem%></li></ul></span>
            <span class="title">Consequences:</span></br>
            <span class="consequences"><ul><li><%=consequences%></li></ul></span>
            </br>Image pattern:</br>
            <span class="file"><img src="<%=filename%>"></span>
            </br>
            <input type="hidden" name="pattern" value="<%=p.getName()%>">
            </div>
            <div class="select"><div class="text">Choose <input type="submit" name="button" value="<%=p.getName()%>"></div>

            </div>

            </div>
            </br></br>
        </form>
    </body>
</html>
