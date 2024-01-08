<%-- 
    Document   : add
    Created on : Dec 12, 2023, 9:06:07 PM
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
        .input{
            margin: 15px 0;
            text-align: center;
        }
        .input label{
            display: inline-block;
            min-width: 90px;
        }
        h1{
            text-align: center;
        }
         input[type="submit"]{
             display: block;
            margin: auto;
        }
        h3{
            text-align: center;
        }
    </style>
    <body>
        <h1>Add new category</h1>
        <h3 style="color: red ">${requestScope.error}</h3>
        <form action="add">
            <div class="input"> 
                 <label for="code">Book code</label>
                 <input type="text" name="code"/>               
            </div>
                 <div class="input"> 
                 <label for="code">Category</label>
                 <input type="text" name="category"/>               
            </div>
            <input type="submit" name="SAVE"/>
        </form>
    </body>
</html>
