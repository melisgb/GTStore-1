<%-- 
    Document   : error
    Created on : Oct 16, 2013, 12:16:16 AM
    Author     : juliantejera
--%>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <h:head>
        <title>Login Error</title>
    </h:head>
    <h:body>
    <h2>Invalid user name or password.</h2>

    <p>Please enter a user name or password that is authorized to access this
        application. For this application, this means a user that has been
        created in the <code>file</code> realm and has been assigned to the
        <em>group</em>.</p>
   <h:link outcome="login">Return to login page</h:link>

    </h:body>
</html>