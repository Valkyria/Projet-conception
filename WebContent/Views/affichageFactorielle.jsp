<%-- 
    Document   : affichageFactorielle
    Created on : 5 nov. 2016, 10:44:16
    Author     : lotona12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page errorPage="error_catch.jsp" %>
        <% String val=request.getParameter("textbox"); %>
        <% controller.Factorielle.adding_user(val); %>
        <% //out.print(Controller.Factorielle.calculFactorielle(val)); %>
    </body>
</html>
