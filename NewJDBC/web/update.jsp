<%-- 
    Document   : update
    Created on : Dec 13, 2023, 10:49:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        input[type="submit"]{
             display: block;
            margin: auto;
        }
        .input{
            margin: 15px 0;
            text-align: center;
        }
         .input label{
            display: inline-block;
            min-width: 90px;
        }
    </style>
    <body>
        <c:set var="c" value="${requestScope.kind}"/>
        <form action="update" method="post">
            <div class="input"> 
                 <label for="code">Book code</label>
                 <input type="text" name="code" readonly value="${c.bookCode}" placeholder="${c.bookCode}"/>               
            </div>
                 <div class="input"> 
                 <label for="code">Category</label>
                 <input type="text" name="category" value="${c.category}"/>               
            </div>
            <input type="submit" name="UPDATE"/>
        </form>
    </body>
</html>
