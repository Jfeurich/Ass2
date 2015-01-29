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

<!-- upload script -->
<script>
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        alert("File API supported.!");
    } else {
        alert("The File APIs are not fully supported in this browser.");
    }

    function startRead(evt) {
        var file = document.getElementById('file').files[0];
        if (file) {
            //  getAsText(file);
            alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
        }
    }
</script>
<!-- einde inladen upload script -->
<script>

    $(document).ready(function() {
        var max_fields      = 10; //maximum input boxes allowed
        var wrapper         = $(".input_fields_wrap"); //Fields wrapper
        var add_button      = $(".add_field_button"); //Add button ID
        var x = 1; //initlal text box count
        $(add_button).click(function(e){ //on add input button click
            e.preventDefault();

            if(x < max_fields){ //max input box allowed
                x++; //text box increment
                $(wrapper).append('<div><input type="text" name="mytext'+x+'"/><a href="#" class="remove_field">Remove</a></div>'); //add input box
            }
        });

        $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
            e.preventDefault(); $(this).parent('div').remove(); x--;
        })
    })
    ;

</script>


<body>

<h1>Pattern Editor</h1>
<div class="patterninfo">
    <label>Pattern name</label></br>
    <div class="labelinfo">
        <input type="text" name="patternname">
    </div>

    </br><label>Problem</label></br>
    <div class="labelinfo">
        <input type="text" name="patternproblem">
    </div>

    </br><label>Solution</label></br>
    <div class="labelinfo">
        <textarea name="patternproblem"></textarea>
    </div>

    <div class="input_fields_wrap">
        </br><label>Category</label></br>
        <!--<button class="add_field_button">Add More Fields</button>-->
        <div><input type="text" name="mytext[]">  <img src="plusicon2.png" style="width:30px" class="add_field_button"></br></div>
    </div>
    <br/>


    <!-- file upload -->
    <input type="file" id="file" onchange="startRead()" name="files[]" multiple />
    <!-- einde fileupload -->

    <input type="submit" value="Add new Pattern" class="button">
</div>
<br/>
<br/>



</body>
</html>