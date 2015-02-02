<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.IOException" %>
<jsp:include page="Header.jsp" >
    <jsp:param name="titel" value="Json Bestand ophalen" />
</jsp:include>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <link rel="stylesheet" href="stylesheet.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <%@ page session="true" language="java" %>
        <%
            File file = new File("..\\webapps\\Ass2\\WEB-INF\\JsonObjects\\jsonobjects.json");
            FileInputStream fileIn = new FileInputStream(file);
            ServletOutputStream servletOutputStream = response.getOutputStream();

            byte[] outputByte = new byte[4096];
            //copy binary contect to output stream
            while(fileIn.read(outputByte, 0, 4096) != -1)
            {
                servletOutputStream.write(outputByte, 0, 4096);
            }
            fileIn.close();
            servletOutputStream.flush();
            servletOutputStream.close();
        %>
    </body>
</html>