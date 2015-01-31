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
<%@ page import="java.io.File" %>
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
    Pattern p = new Pattern("Builder Pattern");
    p.setAllProblems("An application needs to create the elements of a complex aggregate. ");
    Pattern p2 = new Pattern("Adapter Pattern");
    p2.setAllProblems("You want to use an existing class, and its interface does not match the interface you need.;" +
            "You want to use an object in an environment that expects an interface that is different from the object's interface.");

    p.setAllConsequences("The pattern lets you vary a product's internal representation.;The pattern gives you finer control over the construction process.;The pattern isolates code for construction and representation.");
    p2.setAllConsequences("The pattern allows for preexisting objects to fit into new class structures without being limited by their interfaces. ");

    p.setAllSolutions("Builder pattern builds a complex object using simple objects and using a step by step approach. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.\n" +
            "</br>" +
            "A Builder class builds the final object step by step. This builder is independent of other objects.");
    p2.setAllSolutions("Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.\n" +
            "</br></br> " +
            "This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.</br> A real life example could be a case of " +
            "card reader which acts as an adapter between memory card and a laptop.</br>  You plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.</br> ");

    // file test
    File file = new File("\\images\\rodepanda.png");
    File file2 = new File("\\images\\puppies.png");
    p.setDiagram(file);
    p2.setDiagram(file2);


    Context c = new Context(p.getName());
    Context co2 = new Context(p2.getName());
    ContextCategory ccg2 = new ContextCategory("Structural", "By Purpose");
    ContextCategory ccg = new ContextCategory("Object", "By Scope");
    c.addToContext(ccg);
    co2.addToContext(ccg2);
    p.setContext(c);
    p2.setContext(co2);

    ArrayList<Pattern> allePatterns = new ArrayList<Pattern>();
    // ArrayList<Pattern> allePatterns = Disk.loadPattern();
    ArrayList<Context> alleContext = new ArrayList<Context>();
    ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();
    allePatterns.add(p);
    allePatterns.add(p2);

    String baseURL = null;
    String solution = null;
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
