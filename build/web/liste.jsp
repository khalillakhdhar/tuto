

<%@page import="java.sql.ResultSet"%>
<%@page import="model.Bulletin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta charset="UTF-8">

        <%
            String synthese="";
            String description="";
            String logiciel="";
            int gravite=0;
            String source="";
           String acte="ajouter";
           int id=0;
            String message="Ajouter un Bulletin";
            String bouton="Ajouter";
            String direction="BulletinServlet";
            if(request.getParameter("synthese")!=null)
            {
                
                       message="Modifier le Bulletin";
             bouton="Modifier";
              synthese=request.getParameter("synthese");
             description=request.getParameter("description");
             logiciel=request.getParameter("logiciel");;
             gravite=Integer.parseInt(request.getParameter("gravite"));
                          id=Integer.parseInt(request.getParameter("id"));

             source=request.getParameter("source");
             acte="modifier";
            
            }
        Bulletin bl=new Bulletin();
        int idu=0;
        if(session.getAttribute("id")==null)
        {
        response.sendRedirect("index.jsp");
        }
        else
        {
         idu=   Integer.parseInt(session.getAttribute("id").toString());
        bl.setIdUser(idu);
        }
                ResultSet rs=bl.affichage();
                // " or 1=1

        %>
        
        
        
        <style>
            
            td{
                text-align: center;
            }
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<jsp:include page="nav.jsp" />  
        <%
        if(request.getParameter("synthese")!=null)    
        {
        %>
<form method="post" action="<%= direction%>">
    <table align="center" width="30%" border="0">
      
        <tbody>
            <tr><td colspan="2"><h1><%=message %></h1></td></tr>
            <tr>
                <td>Synthése</td>
                <td><input value="<%=synthese %>" type="text" name="synthese" class="form-control" required></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><textarea name="description" class="form-control" required><%=description %></textarea></td>
            </tr>
            <tr>
                <td>Logiciel</td>
                <td><textarea  name="logiciel" class="form-control" required><%=logiciel %></textarea></td>
            </tr>
              <tr>
                <td>Gravité</td>
                <td><input type="number" value="<%=gravite %>" name="gravite" min="1" max="4" class="form-control" required></td>
            </tr>
            <tr>
                <td>Source</td>
                <td><input type="url" name="source" value="<%=source %>" class="form-control" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="<%=bouton%>"></td>
        <input type="hidden" name="id_user" value="<%=idu %>">
                <input type="hidden" name="id" value="<%=id %>">

        <input type="hidden" value="<%=acte %>" name="acte">
            </tr>
        </tbody>
    </table>

    
    
    
</form> <% } %>
 <%
        if(request.getParameter("synthese")==null)    
        {
        %>
<form method="post" action="<%= direction%>">
    <table align="center" width="30%" border="0">
      
        <tbody>
            <tr><td colspan="2"><h1><%=message %></h1></td></tr>
            <tr>
                <td>Synthése</td>
                <td><input type="text" name="synthese" class="form-control" required></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><textarea name="description" class="form-control" required></textarea></td>
            </tr>
            <tr>
                <td>Logiciel</td>
                <td><textarea  name="logiciel" class="form-control" required></textarea></td>
            </tr>
              <tr>
                <td>Gravité</td>
                <td><input type="number" value="" name="gravite" min="1" max="4" class="form-control" required></td>
            </tr>
            <tr>
                <td>Source</td>
                <td><input type="url" name="source" value="" class="form-control" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="<%=bouton%>"></td>
        <input type="hidden" name="id_user" value="<%=idu %>">
                <input type="hidden" name="id" value="<%=id %>">

        <input type="hidden" value="<%=acte %>" name="acte">
            </tr>
        </tbody>
    </table>
</form>
            <% } %>

        <br>
        <h1>Liste</h1>
        <table class="table table-bordered">
            <thead><tr><th>Synthése</th><th>Description</th><th>logiciel</th><th>Gravité</th><% if(session.getAttribute("grade").equals("admin")){ %><th>Action</th> <% } %><td>Solution</td></tr></thead>
            <tbody>
                  <% if( rs.first())
                {%>
                <% if((rs.getInt("id_user")==idu) ||(session.getAttribute("grade").equals("admin")))
                {
                %>
                
                <tr><td><%= rs.getString("synthese") %></td><td><%=rs.getString("description") %></td><td><%=rs.getString("logiciel") %></td><td><%=rs.getString("gravite") %></td><% if(session.getAttribute("grade").equals("admin")){ %><td>
                        <a href="liste.jsp?id=<%= rs.getInt("id") %>&synthese=<%= rs.getString("synthese") %>&description=<%= rs.getString("description") %>&logiciel=<%= rs.getString("logiciel") %>&source=<%= rs.getString("source") %>&gravite=<%= rs.getInt("gravite") %>" class="btn-outline-success">Séléctionner</a><a href="BulletinServlet?id=<%= rs.getInt("id") %>"  class="btn-outline-danger">Supprimer</a></td><% } %><td><a href="solution.jsp?id=<%= rs.getInt("id") %>">Solution</a></td></tr>
                <% }} %>
                 <% while( rs.next())
                {%>
                <% if((rs.getInt("id_user")==idu) ||(session.getAttribute("grade").equals("admin")))
                {
                %>
                
                <tr><td><%= rs.getString("synthese") %></td><td><%=rs.getString("description") %></td><td><%=rs.getString("logiciel") %></td><td><%=rs.getString("gravite") %></td><% if(session.getAttribute("grade").equals("admin")){ %><td>
                        <a href="liste.jsp?id=<%= rs.getInt("id") %>&synthese=<%= rs.getString("synthese") %>&description=<%= rs.getString("description") %>&source=<%= rs.getString("source") %>&logiciel=<%= rs.getString("logiciel") %>&gravite=<%= rs.getInt("gravite") %>" class="btn-outline-success">Séléctionner</a><a href="BulletinServlet?id=<%= rs.getInt("id") %>"  class="btn-outline-danger">Supprimer</a></td><% } %><td><a href="solution.jsp?id=<%= rs.getInt("id") %>">Solution</a></td></tr>

                <% }} %>
            
            
        </table>
    </body>
</html>
