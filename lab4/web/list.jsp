<%-- 
    Document   : list
    Created on : Jan 25, 2024, 7:54:22 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
        <style>
            button a{
                text-decoration: none;
                color: white;
            }
            button a:hover{
                color: #9999;
            }
        </style>
        <script>
    function deleteItem(code){
        if(confirm("Are you sure to delete: " + code)){
            window.location = "delete?id=" + code;
        }
    }
</script>
    </head>
    
    <body>

<div class="container shadow min-vh-100 py-4">
    <button type="button" class="btn btn-primary"><a href="add.jsp">Add</a></button>
    <div class="row mt-4">
        <div class="col">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col" class="col-md-2">ID</th>
                        <th scope="col" class="col-md-2">First</th>
                        <th scope="col" class="col-md-2">Last</th>
                        <th scope="col" class="col-md-2">Age</th>
                        <th scope="col"class="col-md-2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.list}" var="o">
                        <tr>
                            <th scope="row">${o.id}</th>
                            <td>${o.first}</td>
                            <td>${o.lastString}</td>
                            <td>${o.age}</td>
                            <td>
                                <button type="button" class="btn btn-secondary" ><a href="update?id=${o.id}">Update</a></button>
                                <button type="button" class="btn btn-secondary"><a href="#" onclick="deleteItem('${o.id}')">Delete</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>



       
    </body>
</html>
