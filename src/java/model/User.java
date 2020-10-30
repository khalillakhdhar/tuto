/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TPC
 */
public class User {
      private int id;
    private String grade,email,mdp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public User(int id,  String grade, String email, String mdp) {
        this.id = id;
        this.grade = grade;
        this.email = email;
        this.mdp = mdp;
    }

    public User(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public User() {
    }
    
    
    
    
     public ResultSet authentifier() throws SQLException
    {
      Connexion c = new Connexion(); //appel de connexion à la BD
        PreparedStatement pst; 
        pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM user WHERE email='"+this.getEmail()+"' AND mdp='"+this.getMdp()+"' "); // lister les admins
        pst.executeQuery(); // lister les admins
        ResultSet rs = (ResultSet) pst.executeQuery(); // stocker le résultat dans un resultset
        if(rs.next()) {
           return rs;
        }
        else
        {
        return null;
        }
    
    }
     
       public ResultSet affichage() throws SQLException
    {
      Connexion c = new Connexion(); //appel de connexion à la BD
        PreparedStatement pst; 
        pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM user"); // lister les admins
        pst.executeQuery(); // lister les admins
        ResultSet rs = (ResultSet) pst.executeQuery(); // stocker le résultat dans un resultset
        if(rs.next()) {
            return rs;
        }
        else
        {
        return null;
        }
    
    }
}
