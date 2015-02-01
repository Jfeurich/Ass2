<%@ page import="Model.Context" %>
<%@ page import="Model.ContextCategory" %>
<%@ page import="Model.Pattern" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.Disk" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="logic.Json" %>

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


    <label>Purpose</label><br/>
    <form action="PatternSelectorp2.jsp" method="GET" >

    <%
        ArrayList<Pattern> allePatterns = Json.loadPattern();
        ArrayList<Context> alleContext = new ArrayList<Context>();
        ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();
        if(allePatterns != null){

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
        }
        else{
            allePatterns = new ArrayList<Pattern>();
        }

    %>


    <select name="categorynamelist" size="5" >
        <%
            for(ContextCategory cc4 : alleCCategories){
        %><option><%=cc4.getCategoryName()%><option><%}%>
    </select></br>
    </br><label>Scope</label><br/>
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