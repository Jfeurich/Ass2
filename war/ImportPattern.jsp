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

<!-- upload script -->
<script>
  if (window.File && window.FileReader && window.FileList && window.Blob) {
    // alert("File API supported.!");
  } else {
    //alert("The File APIs are not fully supported in this browser.");
  }
  function startRead(evt) {
    var file = document.getElementById('file').files[0];
    if (file) {
      if (file.type.match("image.*")) {
        getAsImage(file);
        alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
      }
      else {
        getAsText(file);
        alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
      }
    }
    evt.stopPropagation();
    evt.preventDefault();
  }
  function startReadFromDrag(evt) {
    var file = evt.dataTransfer.files[0];
    if (file) {
      if (file.type.match("image.*")) {
        getAsImage(file);
        alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
      }
      else {
        getAsText(file);
        alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
      }
    }
    // wohoo
    evt.stopPropagation();
    evt.preventDefault();
  }
  function getAsImage(readFile) {
    var reader = new FileReader();
    reader.readAsDataURL(readFile);
    reader.onload = addImg;
  }
  function addImg(imgsrc) {
    var img = document.createElement('img');
    img.setAttribute("src", imgsrc.target.result);
    document.getElementById("op").insertBefore(img);
  }
</script>
<html>
<body>
</br></br></br></br></br></br>
<span style="color: white; ">Hier bestand uploaden</span></br></br>

<form action="PatternImportServlet.do" method="post">
  <div class="patterninfo">
    <!-- file upload -->
    <input type="file" name="file" />
    <!-- einde fileupload -->
    <input type="submit" name="button" value="Import patterns" class="button"></div>
  </div>
</form>

</body>
</html>