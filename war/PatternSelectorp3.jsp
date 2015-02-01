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
<body>
</br></br></br>
<div class="patterninfo">
  <div class="labelinfo">
        <span class="note center">
            You have chosen the Pattern:<b><%=request.getParameter("button")%></b><br>
        </span>
  </div>
  <%
      String pname = request.getParameter("button");
      ArrayList<Pattern> allePatterns = Json.loadPattern();
      ArrayList<Context> alleContext = new ArrayList<Context>();
      ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();
      String baseURL = null;
      String solution = null;
      File file = null;
      for (Pattern p99 : allePatterns) {
          for (ContextCategory cc : p99.getContext().getContextCategory()) {
              if (pname.equals(p99.getName())) {
                  // then put the pattername as a option in the patterns-selectlist
                  String problem = p99.getAllProblems();
                  String name = p99.getName();
                  problem = problem.replaceAll("(;)", "<br /><li>");

                  String consequences = p99.getAllConsequences();
                  consequences = consequences.replaceAll("(;)", "<br/><li>");

                  file = p99.getDiagram();
                  String url = request.getRequestURL().toString();
                  solution = p99.getAllSolutions();
                  baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
              }
          }
      }

  %>
  </div>
  <div class="choosenpattern">
    <div class="choosentitle"><%=pname%></div>
    <div class="solutiontext"><%=solution%></div>
    <div class="choosendiagram"><div class="choosentitle">Diagram:</div><img src="<%=baseURL + "/images/" + file.getName()%>"></div>

  </div>
</br></br>

</body>
</html>
