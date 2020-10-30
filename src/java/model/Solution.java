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

public class Solution  {


    private Integer id;
   
    private String titre;
   
    private String description;
   
    private int idBulletin;

    public Solution() {
    }

    public Solution(Integer id) {
        this.id = id;
    }

    public Solution(Integer id, String titre, String description, int idBulletin) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.idBulletin = idBulletin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdBulletin() {
        return idBulletin;
    }

    public void setIdBulletin(int idBulletin) {
        this.idBulletin = idBulletin;
    }

       public ResultSet mesaffichage() throws SQLException {
        Connexion c = new Connexion(); //appel de connexion à la BD
        PreparedStatement pst;
        pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM `solution` WHERE `id_bulletin`='" + this.getIdBulletin()+ "' "); // lister les admins
        pst.executeQuery(); // lister les admins
        ResultSet rs = (ResultSet) pst.executeQuery(); // stocker le résultat dans un resultset
        if (rs.next()) {
            return rs;
        } else {
            return null;
        }

    }
    
}
