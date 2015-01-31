<%@ page import="Model.Context" %>
<%@ page import="Model.ContextCategory" %>
<%@ page import="Model.Pattern" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.*" %>

<jsp:include page="Header.jsp" >
  <jsp:param name="titel" value="Accountgegevens wijzigen" />
</jsp:include>


<html>
<head>
  <title></title>
</head>
<link rel="stylesheet" href="stylesheet.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>


<body>
<br><br>
<h1>Pattern Selector</h1>
<div class="patterninfo">


  <label>Category</label><br/>
  <form action="PatternSelectorp2.jsp" method="GET" >

    <%

      Pattern p = new Pattern("Builder Pattern");
      p.setAllProblems("An application needs to create the elements of a complex aggregate.; ");
      Pattern p2 = new Pattern("Adapter Pattern");
      p2.setAllProblems("You want to use an existing class, and its interface does not match the interface you need.;" +
              "You want to use an object in an environment that expects an interface that is different from the object's interface.");

      p.setAllConsequences("The pattern lets you vary a product's internal representation.;The pattern gives you finer control over the construction process.;The pattern isolates code for construction and representation.");
      p2.setAllConsequences("The pattern allows for preexisting objects to fit into new class structures without being limited by their interfaces.");

      // file test
      File file = new File("\\images\\rodepanda.png");
      File file2 = new File("\\images\\puppies.png");
      p.setDiagram(file);
      p2.setDiagram(file2);



      Context c = new Context(p.getName());
      Context co2 = new Context(p2.getName());


      ContextCategory ccg = new ContextCategory("Object","By Scope");
      ContextCategory ccg_2 = new ContextCategory("Structural","By Purpose"); // nieuwe category
      ContextCategory ccg2 = new ContextCategory("Structural","By Purpose");

      c.addToContext(ccg);
      c.addToContext(ccg_2);
      co2.addToContext(ccg2);
      p.setContext(c);
      p2.setContext(co2);

      ArrayList<Pattern> allePatterns = new ArrayList<Pattern>();
      // ArrayList<Pattern> allePatterns = Disk.loadPattern();
      ArrayList<Context> alleContext = new ArrayList<Context>();
      ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();
      allePatterns.add(p);
      allePatterns.add(p2);

      for (Pattern p1 : allePatterns){
        // name = p1.getName();
        Context c1 = p1.getContext();
        alleContext.add(c1);

        for(Context c2 : alleContext){
          ArrayList<ContextCategory> cc3 = c2.getContextCategory();

          for (ContextCategory c4 : cc3) {
            alleCCategories.add(c4);
          }
        }
      }

      List list = new ArrayList<ContextCategory>(alleCCategories);

      Set<ContextCategory> hashset = new HashSet<ContextCategory>(list);
      // list = new ArrayList<ContextCategory>(hashset);
      System.out.println(list.toString());


      HashSet hashAllCat = new HashSet();
      hashAllCat.addAll(alleCCategories);


      alleCCategories.clear();
      alleCCategories.addAll(hashAllCat);




    %>


    <select name="categorynamelist" size="5" >
      <%
        for(ContextCategory cc4 :alleCCategories){
      %><option><%=cc4.getCategoryName()%><option><%}%>
    </select></br>
    </br><label>Subtype</label><br/>
    <select name="subtypelist" size="5">
      <%
        for(ContextCategory conCat : alleCCategories){
      %><option><%=conCat.getDescription()%></option><%
      }%>

    </select>
    <br/><br/>
    <input type="submit" name="submitbutton" class="button" >

  </form>

  <br/>

</div>

</body>
</html>