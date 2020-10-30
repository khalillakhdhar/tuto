<%-- 
    Document   : index
    Created on : 23 oct. 2020, 15:01:53
    Author     : TPC
--%>

<% 

            session.setAttribute("id", null);

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta charset="UTF-8">

                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <form method="post" action="UserServlet">
            <table>
                <tr><td colspan="2"><h1>Connexion</h1></td></tr>
                <tr><td>Email:</td><td><input type="text" required name="login"></td></tr>
                <tr><td>Mot de passe</td><td><input type="password" required name="mdp"></td></tr>
                <tr><td colspan="2"><input type="submit" value="connexion"></td></tr>
            </table></form>
    </body>
</html>
