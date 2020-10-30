

<%@page import="java.sql.ResultSet"%>
<%@page import="model.Bulletin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta charset="UTF-8">

        <%
            int gravite=0;
            gravite=Integer.parseInt(request.getParameter("gravite"));
        Bulletin bl=new Bulletin();
        int id=0;
        if(session.getAttribute("id").equals(null))
        {
        response.sendRedirect("index.jsp");
        }
        else
        {
         id=   Integer.parseInt(session.getAttribute("id").toString());
        bl.setIdUser(id);
        }
                ResultSet rs=bl.affichage();

        %>
        
        
        

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<jsp:include page="nav.jsp" />  
        
        <br>
        <h1>Liste</h1>
        <table class="table table-bordered">
            <thead><tr><th>Synthése</th><th>Description</th><th>logiciel</th><th>Gravité</th></tr></thead>
            <tbody>
                  <% if( rs.first())
                {%>
                                <% if(rs.getInt("gravite")==gravite)
                                
                {%>

                <% if((rs.getInt("id_user")==id) ||(session.getAttribute("grade").equals("admin")))
                {
                %>
                
                <tr><td><%= rs.getString("synthese") %></td><td><%=rs.getString("description") %></td><td><%=rs.getString("logiciel") %></td><td><%=rs.getString("gravite") %></td></tr>
                <% }} } %>
                 <% while( rs.next())
                {%>
                              <% if(rs.getInt("gravite")==gravite)
                                
                {%>
                
                <% if((rs.getInt("id_user")==id) ||(session.getAttribute("grade").equals("admin")))
                {
                %>
                
                <tr><td><%= rs.getString("synthese") %></td><td><%=rs.getString("description") %></td><td><%=rs.getString("logiciel") %></td><td><%=rs.getString("gravite") %></td></tr>
                <% }} } %>
            
            
        </table>
    </body>
</html>
