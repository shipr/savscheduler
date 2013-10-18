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

    <div id="positionsContainer" style="width: 100%;"></div>



    <script>
        $(document).ready(function () {
            createEmployeesTable()
            createPositionsTable()
        });

        function createEmployeesTable() {
            $('#employeesContainer').jtable({
                title: 'Table of employees',
                actions: {
                    listAction: '/restful/Employee/getAll',
                    createAction: '/restful/Employee/create',
                    updateAction: '/restful/Employee/update',
                    deleteAction: '/restful/Employee/delete'
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
                    positionName: {
                        title: 'Positions',
                        width: '40%',
                        options: function (data) {
                            return '/restful/Position/getAllOptions';
                        },
                        input: function (data){
                            if (data.record) {
                                return '<input type="text" name="positions" style="width:200px" value="' + data.record.positions+ '" />';
                            } else {
                                return '<input type="text" name="positions" style="width:200px" value="" />';
                            }
                        }
                    }
                }
            });
            $('#employeesContainer').jtable('load');
        }
        function createPositionsTable() {
            $('#positionsContainer').jtable({
                title: 'Table of positions',
                actions: {
                    listAction: '/restful/Position/getAll',
                    createAction: '/restful/Position/create',
                    updateAction: '/restful/Position/update',
                    deleteAction: '/restful/Position/delete'
                },
                fields: {
                    positionId: {
                        key: true,
                        list: false
                    },
                    positionName: {
                        title: 'Name',
                        width: '100%'
                    }
                }
            });
            $('#positionsContainer').jtable('load');
        }
    </script>

    <br>
    <a href="LogoutServlet">Logout</a>
    <br>

</body>
</html>
