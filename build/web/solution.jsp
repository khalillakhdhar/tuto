<%-- 
    Document   : solution
    Created on : 30 oct. 2020, 15:46:03
    Author     : TPC
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.Solution"%>
<%
     int id=0;
     if(session.getAttribute("id")==null)
        {
        response.sendRedirect("index.jsp");
        }
     if(request.getParameter("id")==null)
        {
        response.sendRedirect("index.jsp");
        }
     else
     {
      id = Integer.parseInt(request.getParameter("id"));
     }
     Solution s=new Solution();
     s.setIdBulletin(id);

ResultSet rs=s.mesaffichage();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="nav.jsp" />  

        <h1>Solution possible!</h1>
        <table class="table table-bordered">
            <tr><td>Titre</td><td>Description</td></tr>
            <% if(rs.first())
            { %>
            
            <tr><td><%= rs.getString("titre") %></td><td><%= rs.getString("description") %></td></tr>
            
            <% } %>
            
        </table>
    </body>
</html>
