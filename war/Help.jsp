<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2-2-2015
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="Header.jsp" >
  <jsp:param name="titel" value="Help" />
</jsp:include>
<%@ page import="logic.Json" %>

<html>
<head>
  <title></title>
</head>
<link rel="stylesheet" href="stylesheet.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div style="height:40px;"></div>
  <div class="helpbox">
    <div class="helptitle">How can I make my own pattern?</div>
    <div class="helptext">
      You can make your own pattern by going to the <a href="PatternEditor.jsp">Pattern Editor</a> page.<br/>
      <ul>
          <li>Fill in a name for your pattern.</li>
          <li>After that you'll have to fill in the problems field. Separate each problem with a semi-colon ;.</li>
          <li>Fill in the Consequences, separated by a semi-colon ;.</li>
          <li>Fill in a textual description of the solution in the solutionfield.</li>
          <li>Fill in a purpose and scope categoryname. </li>
          <li>Choose a image file from your computer and click on "Add new Pattern" when all the fields are filled in.</li>
      </ul>
    </div>
  </div>

  <div class="helpbox">
    <div class="helptitle">How can I export the patterns?</div>
    <div class="helptext">
      You can export your patterns by going to the <a href="PatternEditor.jsp">Pattern Editor</a> page and click on the "Export Patterns" button in the bottom-right of the screen.<br/>
    </div>
  </div>

<div class="helpbox">
  <div class="helptitle">How can I import the patterns?</div>
  <div class="helptext">
    You can export your patterns by going to the <a href="PatternEditor.jsp">Pattern Editor</a> page and click on the "Import Patterns" button in the bottom-left of the screen.
    You will be redirected to a page where you can choose the fill you want to import.
  </div>
</div>
</body>
</html>
