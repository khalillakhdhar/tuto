/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bulletin;

/**
 *
 * @author TPC
 */
@WebServlet(name = "BulletinServlet", urlPatterns = {"/BulletinServlet"})
public class BulletinServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BulletinServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BulletinServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
      Bulletin b =new Bulletin();
     int idb=Integer.parseInt(request.getParameter("id"));
     b.setId(idb);
     b.delete();
     response.sendRedirect("liste.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String s=request.getParameter("synthese");
        String d=request.getParameter("description");
        String  l=request.getParameter("logiciel");
        String src=request.getParameter("source");
        int g=Integer.parseInt(request.getParameter("gravite"));
        //id_user
                int id_user=Integer.parseInt(request.getParameter("id_user"));
                Bulletin b=new Bulletin(d, s, l, g, src, id_user);
                
                if(request.getParameter("acte").equals("modifier"))
                {
                                    int idb=Integer.parseInt(request.getParameter("id"));
                                    b.setId(idb);

                b.update();
                                                response.sendRedirect("index.jsp");

                }
                else
                {
                b.ajout();
                                response.sendRedirect("liste.jsp");
}

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
