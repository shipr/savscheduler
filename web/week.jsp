<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weekly View Page</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
    <link href="/jtable/themes/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
    <script src="/jtable/jquery.jtable.js"></script>
</head>
<body>
    <div id="topSpacer" style="width: 100%;height: 200px">
    </div>
    <div id="selectorsContainer">
    <div id="positionSelectContainer" style="float:left;">
        <select name="position" id="positionSelect" ></select>
    </div>

    <div id="employeesContainer" style="float:left;">
        <select name="employee" id="employeeSelect"></select>
    </div>

    <div id="div3"></div>

    <script>
        var select = $('#positionSelect');
        $.post('/restful/Position/getAll', function(data, status){
            if(status == "success"){
                select.append($("<option />").text("").val(0));
                $.each(data.Records , function(){
                    select.append($("<option />").text(this.positionName).val(this.positionId));
                });
            } else {
                alert("failed");
            }
        });

        $( '#positionSelect' )
                .change(function () {
                    var str = "name:" + this.name + "; text:" + $( "#positionSelect option:selected" ).text() +"; value:" + this.value;
                    $( "#outputDiv" ).text(str);

                    loadEmployees(this.value);
                })
                .change();

        function loadEmployees(positionId){
            var select = $('#employeeSelect');
            select.empty();
            if(positionId == 0){
                return;
            }
            select.append($("<option />").text("").val(0));
            $.post('/restful/Employee/getAll?positionId=' + positionId, function(data, status){

                if(status == "success"){
                    select.append($("<option />").text("").val(0));
                    $.each(data.Records , function(){
                        select.append($("<option />").text(this.name + " " + this.lastName).val(this.employeeId));
                    });
                } else {
                    alert("failed");
                }
            })
        }


    </script>
    </div>
<div>

    <%--<select name="sweets" multiple="multiple" id="sweetsId">--%>
        <%--<option>Chocolate</option>--%>
        <%--<option selected="selected">Candy</option>--%>
        <%--<option>Taffy</option>--%>
        <%--<option selected="selected">Caramel</option>--%>
        <%--<option>Fudge</option>--%>
        <%--<option>Cookie</option>--%>
    <%--</select>--%>
    <%--<div id="outputDiv"></div>--%>
    <%--<script>--%>
        <%--$( '#sweetsId' )--%>
                <%--.change(function () {--%>
                    <%--var str = "";--%>
                    <%--$( "select option:selected" ).each(function() {--%>
                        <%--str += $( this ).text() + " ";--%>
                    <%--});--%>
                    <%--$( "#outputDiv" ).text( str );--%>
                <%--})--%>
                <%--.change();--%>
    <%--</script>--%>

</div>

    <div id="outputDiv"></div>


</body>
</html>