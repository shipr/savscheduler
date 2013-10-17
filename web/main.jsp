<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
    <link href="/jtable/themes/metro/blue/jtable.min.css" rel="stylesheet" type="text/css" />
    <script src="/jtable/jquery.jtable.min.js"></script>
</head>
<body>
    <div id="employeesContainer" style="width: 100%;"></div>



    <script>
        $(document).ready(function () {
            createEmployeesTable()
        });

        function createEmployeesTable() {
            $('#employeesContainer').jtable({
                title: 'Table of employees',
                actions: {
                    listAction: '/restful/Employee/getAll',
                    createAction: '/restful/Employee/createEmployee',
                    updateAction: '/restful/Employee/updateEmployee',
                    deleteAction: '/restful/Employee/deleteEmployee'
                },
                fields: {
                    employeeId: {
                        key: true,
                        list: false
                    },
                    name: {
                        title: 'Name',
                        width: '20%'
                    },
                    lastName: {
                        title: 'LastName',
                        width: '40%'
                    },
                    positions: {
                        title: 'Positions',
                        width: '40%',
                        type: 'date',
                        create: false,
                        edit: false
                    }
                }
            });
            $('#employeesContainer').jtable('load');
        }

    </script>

    <br>
    <a href="LogoutServlet">Logout</a>
    <br>

</body>
</html>
