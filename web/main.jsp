<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <div id="mainFrame">
        <div id="employeesFrame"></div>
    </div>

    <script>
        $(document).ready(function() {
            loadEmployees();
        });

        function loadEmployees(){
            $.ajax({
                type: "POST",
                url: "AjaxServlet",
                data: "service=EmployeeService&action=getAll"
            }).done( function(msg) {
                        var res = eval(msg);

                        //alert( "Employee.getAll(): " +  );
                    }).fail( function( xmlHttpRequest, statusText, errorThrown ) {
                        alert("Your form submission failed.\n\n"
                                        + "XML Http Request: " + JSON.stringify( xmlHttpRequest )
                                        + ",\nStatus Text: " + statusText
                                        + ",\nError Thrown: " + errorThrown );
                    });
        }

    </script>

    <a href="LogoutServlet">Logout</a>

</body>
</html>
