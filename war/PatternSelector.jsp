<%@ page import="Model.Context" %>
<%@ page import="Model.ContextCategory" %>
<%@ page import="Model.Pattern" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.Disk" %>
<%@ page import="java.util.HashSet" %>


<jsp:include page="Header.jsp" >
    <jsp:param name="titel" value="Accountgegevens wijzigen" />
</jsp:include>

       <%/*
            Pattern pattern = new Pattern("Patternname2");
            Context context = new Context(pattern.getName());

            ContextCategory cc = new ContextCategory("Scope","Behavioural");
            context.addToContext(cc);
            pattern.setContext(context);


            ArrayList<Context> allContexts = new ArrayList<Context>();
            ArrayList<Pattern> allPatterns = Disk.loadPattern();
            ArrayList<ContextCategory> contextCategoryArray = new ArrayList<ContextCategory>();

            for (Pattern p : allPatterns){
                allContexts.add(p.getContext());
                for(Context c : allContexts){
                    for(ContextCategory ccg : c.getContextCategory()){
                        contextCategoryArray.add(ccg);
                    }
                }
            }*/
       %>

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


        <%
            Pattern p = new Pattern("TestPattern");
            Pattern p2 = new Pattern("Pattern2");
            Context c = new Context(p.getName());
            Context co2 = new Context(p2.getName());
            ContextCategory ccg2 = new ContextCategory("Class","By Scope");
            ContextCategory ccg = new ContextCategory("Behavioural","By purpose");
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
            HashSet hashAllCat = new HashSet();
            hashAllCat.addAll(alleCCategories);
            alleCCategories.clear();
            alleCCategories.addAll(hashAllCat);
        %>


    <select name="sometext2" size="5">
        <%
            for(ContextCategory cc4 : alleCCategories){
        %><option><%=cc4.getCategoryName()%><option><%}%>
    </select></br>
    </br><label>Subtype</label><br/>
    <select name="sometext3" size="5">
        <%
            for(ContextCategory conCat : alleCCategories){
        %><option><%=conCat.getDescription()%></option><%
        }%>

    </select>
    <br/><br/>
    <label>Patterns</label><br/>
    <select name="sometext4" size="5">
        <%
            //for()
        %>
    </select>
    <br/>
    Woohoo3
</div>

</body>
</html>