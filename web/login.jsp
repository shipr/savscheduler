<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div>
    <form action="LoginServlet" method="POST">
        <c:if test="${loginFailes}">
            <p>Login failed try once again.<p>
        </c:if>

        <div><p>Name:</p><input id='nameInput' type="text" name="name" value="<c:out value="${name}"/>"></div>
        <div><p>Password:</p><input id='passwordInput' type="password" value="name" name="password"></div>
        <div><input type="submit" value="OK" ></div>
    </form>
</div>

</body>
</html>