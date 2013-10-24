<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee/Position Page</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
    <link href="/jtable/themes/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
    <script src="/jtable/jquery.jtable.js"></script>
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
                    positions: {
                        title: 'Positions',
                        width: '40%',
                        options: function (data) {
                            return '/restful/Position/getAllOptions';
                        },
                        input: function (data, options){
                            if (data.record) {

                                var select = $('<select multiple name="positions" id="show_results" />');

                                containsInArray = function(arrayObj, valueObj){
                                    if(typeof arrayObj === 'string' || typeof arrayObj === 'number' || arrayObj){
                                        return arrayObj == valueObj;
                                    } else if(arrayObj) {
                                        for (var i = 0; i < arrayObj.length; i++) {
                                            if(arrayObj[i] == valueObj){
                                                return true;
                                            }
                                        }
                                        return false;
                                    }

                                }
                                select.append($("<option />").text('').val(0).prop("selected", "selected"));

                                $.each(options, function () {
                                    select.append($("<option />").text(this.DisplayText).val(this.Value).prop("selected", containsInArray(data.value, this.Value) ? "selected" : null));
                                });
                                return select
                            } else {
                                return '<input type="text" name="positions" style="width:200px" value="" />';
                            }
                        },
                        display: function(data){
                            var ret = '';
                            if(data.value){
                                for(var i = 0 ; i < data.value.length; i++){
                                    var val = data.value[i];
                                    for(var ii = 0; ii < data.options.length; ii++){
                                        var option = data.options[ii];
                                        if(option.Value == val){
                                            ret += option.DisplayText + ' ';
                                            break;
                                        }
                                    }
                                }
                            };
                            return ret;
                            //return data.record + ' ' + data.value + ' ' +  data.options;
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
