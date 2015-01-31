<%@ page import="Model.Context" %>
<%@ page import="Model.ContextCategory" %>
<%@ page import="Model.Pattern" %>
<%@ page import="logic.Disk" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
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
</br></br>
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

        ArrayList<String>alleSubtypes = new ArrayList<String>();
        ArrayList<String>alleCategories = new ArrayList<String>();
            for (Pattern p1 : allePatterns){
               // name = p1.getName();
                Context c1 = p1.getContext();
                alleContext.add(c1);

                for(Context c2 : alleContext){
                    ArrayList<ContextCategory> cc3 = c2.getContextCategory();

                    for (ContextCategory c4 : cc3) {
                        alleCCategories.add(c4);
                        alleCategories.add(c4.getCategoryName());
                        alleSubtypes.add(c4.getDescription());
                    }
                }
            }

        List list = new ArrayList<ContextCategory>(alleCCategories);

        Set<ContextCategory> hashset = new HashSet<ContextCategory>(list);

           HashSet hashAllCat = new HashSet();
            hashAllCat.addAll(alleCCategories);

            alleCCategories.clear();
            alleCCategories.addAll(hashAllCat);

            Set hashset2 = new HashSet(alleCategories);
		    list = new ArrayList(hashset2);

		    Set hashset3 = new HashSet(alleSubtypes);
		    list = new ArrayList(hashset3);

    %>
        <select name = "categorynamelist" size="5">
           <% Iterator iter = hashset2.iterator();
            while (iter.hasNext()) {%>
            <option><%=iter.next()%></option>
          <% }%>
        </select>
    </br> <label>Subtype</label><br/>
        <select name = "subtypelist" size="5">
            <% Iterator iter2 = hashset3.iterator();
                while (iter2.hasNext()) {%>

            <option><%=iter2.next()%></option>
            <% }%>
        </select>
        <input type="submit" name="submitbutton" class="button"  value="Zoek Pattern">

    </form>
</div>

</body>
</html>