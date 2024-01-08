<%-- 
    Document   : loginJSP
    Created on : Dec 9, 2023, 12:54:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
                if(request.getAttribute("er")!=null){
                String error = (String)request.getAttribute("er");
            
            %>
            <h1 style="color: red"><%= error%></h1>
            <%
            }
        %>
        <form action="action" method="post">
            Username: <input type="text" name="user"/> </br>
            Password: <input type="password" name="pass" /> </br><!-- comment -->
            <input type="submit" name="Submit"/>
        </form>
    </body>
</html>
