<%-- 
    Document   : list
    Created on : Dec 12, 2023, 8:28:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.4/gsap.min.js"></script>
        <style>
            table{
                margin: auto;
            }
            .link{
                display: block;
                text-align: center;
                margin: 20px 0;
                text-decoration: none;
                font-size: 1rem;
                font-weight: bold;
                font-family: fantasy;
            }
            .overlay {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5); /* Màu đen với độ trong suốt */
                display: none;
                opacity: 0; /* Mặc định là ẩn và không trong suốt */
            }

            .loginForm form label {
                margin: 15px 0;
                display: inline-block;
                min-width: 80px;
            }

            .loginForm {
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%) translateY(-100%); 
                background-color: white; 
                color: black; 
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.15);
                padding: 20px;
                opacity: 0; 
            }

            .loginForm form {

                background-color: wheat; /* Màu nền form */
                color: black; /* Màu chữ đen */
                display: none;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.15);
                padding: 20px;
                /*            position: absolute;
                            top: 50%;
                            left: 50%;
                            transform: translate(-50%, -50%);*/
            }

            h2 a {
                cursor: pointer;
            }

            #loginLink{
                cursor: pointer;
            }
            .updateLink{
                cursor: pointer;
            }
            .deleteLink{
                cursor: pointer;
            }
        </style>
        <script type="text/javascript">
            function doDelete(code) {
                if (confirm("Are you sure delete " + code)) {
                    window.location = "delete?code=" + code;
                }
            }

        </script>
    </head>
    <body>
        <div class="overlay" id="overlay"></div>

        <c:if test="${sessionScope.acc == null}">
            <h2><a id="loginLink">Login</a></h2>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
            <h2>Hello ${sessionScope.acc.username}</h2>
            <h2><a id="loginLink" href="logout">logout</a></h2>
        </c:if>

        <div class="loginForm" id="loginForm">
            <form action="list" method="post">
                <label>User name: </label>
                <input type="text" name="user"><br/>
                <label>Password: </label>
                <input type="password" name="pass">
                <input id="submitButton" type="submit" name="SUBMIT"/>
            </form>
        </div>
        <h1 style="text-align: center">List category</h1>
        <c:if test="${sessionScope.acc==null}">
            <a id="link" >Add category</a>
        </c:if>
        <c:if test="${sessionScope.acc!=null}">
            <a class="link" href="add.jsp" >Add category</a>
        </c:if>
        <table border="1px" cellpadding="10px" cellspacing="10px" >
            <tr>
                <td>Book code</td>
                <td>Category</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${requestScope.data}" var="c">
                <tr>
                    <td>${c.bookCode}</td>
                    <td>${c.category}</td>
                    <td> 
                        <c:if test="${sessionScope.acc!=null}">                          
                            <a href="#" onclick="doDelete('${c.bookCode}')">Delete</a> &nbsp; &nbsp; &nbsp;  
                        </c:if>
                        <c:if test="${sessionScope.acc==null}">
                            <a class="deleteLink">Delete</a> &nbsp; &nbsp; &nbsp;                          
                        </c:if>                                    
                        <c:if test="${sessionScope.acc==null}">
                            <a class="updateLink" >Update</a>
                        </c:if>
                        <c:if test="${sessionScope.acc!=null}">
                            <a href="update?code=${c.bookCode}" >Update</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script src="./main.js"></script>
    </body>
</html>
