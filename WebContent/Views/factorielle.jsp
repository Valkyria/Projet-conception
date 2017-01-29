<%-- 
    Document   : factorielle
    Created on : 5 nov. 2016, 10:21:27
    Author     : lotona12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercice 2 TP2</title>
    </head>
    <body>
    	<% controller.Factorielle.adding_user("cedric"); %>
        <form method="post" action="affichageFactorielle.jsp">
            <label for="textbox">Nombre(s) a saisir pour la factorielle : </label>
            <input type="text" name="textbox" id="textbox" width="200" height="200"/>
            <br/>
            <input type="submit"/>
        </form>
    </body>
</html>
