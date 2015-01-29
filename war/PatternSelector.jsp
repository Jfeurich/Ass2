

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
<div class="patterninfo"></div>
</body>
</html>