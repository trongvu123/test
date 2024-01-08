<%-- 
    Document   : h3
    Created on : Dec 10, 2023, 2:27:34 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="c" value="${requestScope.st}"/>
        <h2>Hello ${requestScope.name}</h2>
        <img src="${c.gender ? 'img/male3.png' : 'img/female2.png'} " width="10%" />
        <c:if test="${c.mark>=5}">
            <h3>Pass</h3>
        </c:if>
        <c:if test="${c.mark<5}">
            <h3>fail</h3>
        </c:if>
        <table border="1px" cellspacing="10px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Mark</th>
                <th>Rank</th>
            </tr>

            <c:forEach items="${requestScope.data}" var="l">
                <tr>
                    <td>${l.id}</td>
                    <td>${l.name}</td>
                    <td>
                        <img src="${l.gender ? 'img/male3.png' : 'img/female2.png'}" width="20px"/>
                    </td>
                    <td>${l.mark}</td>
                    <td>
                        <c:if test="${l.mark>=8}">
                            Excellent
                        </c:if>
                        <c:if test="${l.mark>=5}">
                            Average
                        </c:if>
                        <c:if test="${l.mark<5}">
                            Weak
                        </c:if>
                    </td>
                </tr>
            </c:forEach>


        </table>

    </body>
</html>
