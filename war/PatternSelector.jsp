<%@ page import="Model.Context" %>
<%@ page import="Model.ContextCategory" %>
<%@ page import="Model.Pattern" %>
<%@ page import="java.util.*" %>
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

<%
    ArrayList<Pattern> allePatterns = Json.loadPattern();
    if(allePatterns == null){
        allePatterns = new ArrayList<Pattern>();
    }
    ArrayList<Context> alleContext = new ArrayList<Context>();
    ArrayList<ContextCategory> alleCCategories = new ArrayList<ContextCategory>();
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
<body>
</br></br>
<h1>Pattern Selector</h1>
<div class="patterninfo">

    <label>Purpose</label><br/>
    <form action="PatternSelectorp2.jsp" method="GET" >
        <select name = "categorynamelist" size="5">
           <% Iterator iter = hashset2.iterator();
            while (iter.hasNext()) {%>
            <option><%=iter.next()%></option>
          <% }%>
        </select></br>
        <label>Scope</label></br>
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