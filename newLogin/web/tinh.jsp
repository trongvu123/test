<%-- 
    Document   : tinh
    Created on : Dec 9, 2023, 3:09:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .form-container {
                background-color: pink;
                width: 24%;
                padding: 20px 0;
                margin: auto;
                border-radius: 10px;

            }
            .form-container h2{
                margin-top: 0;
                text-align: center;
            }
            .input-num{
                margin: 8px 0;
            }
            form input[type="submit"]{
                display: flex;
                margin: auto;
                border: none;
                border-radius: 9px;
                padding: 8px;
                color: white;
                background-color: blanchedalmond;
                cursor: pointer;
                margin-top: 35px;
            }
            .input-num{
                text-align: center;
            }
            .input-num label{
                position: relative;
                display: inline-block;
            }
            .option{
                left: 41%;
                position: absolute;
                
            }
            .form-container h3{
                text-align: center;
                color: #9999ff;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h2>A Simple Calculate</h2>

            <form action="">
                <div class="input-num">
                    <label for="op1" > Enter Operand1: </label>
                    <input type="text" id="op1" name="num1">
                </div>
                <div class="input-num">
                    <label for="op2" > Enter Operand2: </label>
                    <input type="text" id="op2" name="num2">
                </div>
                <select class="option" name="op">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
                <input type="submit" value="Submit"/>
            </form>
            <h3>
                <jsp:useBean id="c" class="model.Math" />
                <jsp:setProperty name="c" property="*" />
                <jsp:getProperty name="c" property="Result" />
                
                
            </h3>
        </div>
    </body>
</html>
