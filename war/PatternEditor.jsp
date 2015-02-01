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
<!-- einde inladen upload script -->
<body>
</br>
</br>
    <h1>Pattern Editor</h1>

<form action="PatternEditorServlet.do" method="post">
    <% %>
    <div class="patterninfo">
            <label>Pattern name</label></br>
        <div class="labelinfo">
            <input type="text" name="name">
        </div>
            <label>Problems</label></br>
        <div class="labelinfo">
            <input type="text" name="problems">
        </div>

        </br><label>Consequences</label></br>
        <div class="labelinfo">
            <textarea name="consequences"></textarea><br/>
            <span class="note">Please separate the consequences with a semi-colon (;) </span>
        </div>

        </br><label>Solution</label></br>
        <div class="labelinfo">
            <textarea name="solutions"></textarea>
        </div>
    </div>
    <div><input type="hidden" name="totalTextfields" value="1"></div>
    <div class="patterninfo2">
        <div class="input_fields_wrap">
            </br><label>Purpose</label> <label id="subtypeLabel">Scope</label></br>
            <div><input type="text" name="mytext"> <input type="text" name="subcat"><br/></div>
        </div>
        <br/>
    </div>
    <div class="patterninfo">
        <!-- file upload -->
        <input type="file" name="file" />
        <!-- einde fileupload -->
        <input type="submit" name="button" value="Add new pattern" class="button"></div>
    </div>
    <br/>
    <br/>

    <div class="import" onclick="javascript:location.href='ImportPattern.jsp'">
        Import patterns
       <!-- <input type="submit" name="import" value="Import patterns" class="buttonimportexport" onclick="javascript:location.href='ImportPattern.jsp'">
        -->
    </div>
    <div class="export">
        <input type="submit" name="export" value="Export patterns" class="buttonimportexport" alignright>
    </div>
</form>
</body>
</html>