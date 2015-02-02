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
    ArrayList<Pattern> geselecteerdePatterns = new ArrayList<Pattern>();

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
                    geselecteerdePatterns.add(p99);
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
        </div></br>
        <form action="PatternSelectorp3.jsp" method="GET" >
            <div class="Pattern">
                <%for(Pattern p : geselecteerdePatterns){%>
                    <tr><%=p.getName()%></tr></br>
                    <tr><%=p.getAllProblems()%></tr></br>
                    <tr><%=p.getAllConsequences()%></tr></br>
                    <span class="file"><img src="<%=p.getDiagram()%>"></span>
                    <input type="hidden" name="pattern" value="<%=p.getName()%>">
                    <div class="select"><div class="text">Choose <input type="submit" name="button" value="<%=p.getName()%>"></div></div>
            <%}%>
            </div>
            </br></br>
        </form>
    </body>
</html>
