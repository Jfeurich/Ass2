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
<script type="text/javascript">

    $(document).ready(function() {
        var max_fields      = 10; //maximum input boxes allowed
        var wrapper         = $(".input_fields_wrap"); //Fields wrapper
        var add_button      = $(".add_field_button"); //Add button ID
        var x = 1; //initial text box count
        $(add_button).click(function(e){ //on add input button click
            e.preventDefault();

            if(x < max_fields){ //max input box allowed
                x++; //text box increment
                $(wrapper).append('<div><input type="text" name="mytext'+x+'"> <input type="text" name="subcat'+x+'"/> <a href="#" class="remove_field"><img src="minicon.png" class="mini_icon"></a></div>'); //add input box
                document.getElementById("totalTextfields").value=x;
            }

        });
        $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
            e.preventDefault(); $(this).parent('div').remove(); x--;
            document.getElementById("totalTextfields").value=x;
        })
    })
    ;
</script>
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
            </br><label>Category</label> <label id="subtypeLabel">Subtype</label></br>
            <div><input type="text" name="mytext[]"> <input type="text" name="subcat[]"> <img src="plusicon2.png" style="width:30px" class="add_field_button"><br/></div>
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

    <div class="import">
        <input type="submit" name="import" value="Import patterns" class="buttonimportexport">
    </div>
    <div class="export">
        <input type="submit" name="export" value="Export patterns" class="buttonimportexport" alignright>
    </div>
</form>
</body>
</html>