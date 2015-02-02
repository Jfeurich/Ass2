<jsp:include page="Header.jsp" >
    <jsp:param name="titel" value="Accountgegevens wijzigen" />
</jsp:include>
<%@ page import="logic.Json" %>

<html>
<head>
    <title></title>
</head>
<link rel="stylesheet" href="stylesheet.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
<%@ page session="true" language="java" %>


<html>
<head>
    <title></title>
</head>
<body>
<br> <br> <br> <br> <br> <br>
<span style="color: white; ">Try to add an actual Json Array.</br> Ik weet dat deze foutmelding er nog in zit,
dit komt doordat er een mismatch is het type van het json-object in de applicatie en het type dat ingeladen wordt</br> e.g.:
    de array in de database is nog niet geïnitialiseerd, of juist wel.</br>
Dit was te verhelpen met een extra parser, maar dit zou veel tijd kosten.</span>
</body>
</html>
