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
    </head>
    <body>

        <div class="container shadow min-vh-100 py-4">
            <div class="row">
                
                <div class="col-md-5 mx-auto">
                    <div class="small fw-light">search input with icon</div>
                    <form action="search">
                                         <div class="input-group">
                                             <input class="form-control border-end-0 border rounded-pill" name="text-search" type="search" value="${requestScope.txt}" id="example-search-input">
                        <span class="input-group-append">
                            <button class="btn btn-outline-secondary bg-white border-bottom-0 border rounded-pill ms-n5" type="submit">
                                <i class="fa-solid fa-magnifying-glass"></i>
                            </button>
                        </span>
                    </div>
                    </form>
                </div>
                <c:set var="list" value="${requestScope.list}"></c:set>
                <c:set var="ms" value="${requestScope.msErr}"></c:set>
                <c:if test="${empty list}">
                    <h1>${ms}</h1>
                </c:if>
                <c:if test="${not empty list}">
                    <table class="table">
                    <thead>

                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="o">
                            <tr>
                                <th scope="row">${o.id}</th>
                                <td>${o.first}</td>
                                <td>${o.lastString}</td>
                                <td>${o.age}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
                </c:if>
                
            </div>

        </div>
       
    </body>
</html>
