<%@ page import="Model.Context, Model.Pattern"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.Disk" %>
<%@ page import="Model.ContextCategory" %>

<jsp:include page="Header.jsp" >
    <jsp:param name="titel" value="Accountgegevens wijzigen" />
</jsp:include>

        <%
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
            }

    %>
