<%-- 
    Document   : Login
    Created on : Oct 16, 2013, 12:14:20 AM
    Author     : juliantejera
--%>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <h:head>
        <title>Login Form</title>
    </h:head>
    <h:body>
        <h2>Hello, please log in:</h2>
        <form name="loginForm" method="POST" action="j_security_check">
            <p><strong>Please type your user name: </strong>
                <input type="text" name="j_username" size="25"></input></p>
            <p><strong>Please type your password: </strong>
                <input type="password" size="15" name="j_password"></input></p>
            <p>
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/></p>
        </form>       
    </h:body>
</html>