<%-- 
    Document   : welcome
    Created on : Dec 9, 2023, 1:22:05 PM
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
            if(request.getAttribute("u")!=null){
            String username = (String)request.getAttribute("u");
           
        %>
        <h1>Hello: <%= username%></h1> 
        
        <%
            }
       %>
    </body>
</html>
