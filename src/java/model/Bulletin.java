/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Connexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TPC
 */
public class Bulletin implements Serializable {

    private Integer id;

    private String description;

    private String synthese;

    private String logiciel;

    private int gravite;

    private String source;

    private int idUser;

    public Bulletin() {
    }

    public Bulletin(Integer id) {
        this.id = id;
    }

    public Bulletin(Integer id, String description, String synthese, String logiciel, int gravite, String source, int idUser) {
        this.id = id;
        this.description = description;
        this.synthese = synthese;
        this.logiciel = logiciel;
        this.gravite = gravite;
        this.source = source;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSynthese() {
        return synthese;
    }

    public void setSynthese(String synthese) {
        this.synthese = synthese;
    }

    public String getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(String logiciel) {
        this.logiciel = logiciel;
    }

    public int getGravite() {
        return gravite;
    }

    public void setGravite(int gravite) {
        this.gravite = gravite;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public ResultSet mesaffichage() throws SQLException {
        Connexion c = new Connexion(); //appel de connexion à la BD
        PreparedStatement pst;
        pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM `bulletin` WHERE `id_user`='" + this.getIdUser() + "' "); // lister les admins
        pst.executeQuery(); // lister les admins
        ResultSet rs = (ResultSet) pst.executeQuery(); // stocker le résultat dans un resultset
        if (rs.next()) {
            return rs;
        } else {
            return null;
        }

    }

    public ResultSet affichage() throws SQLException {
        Connexion c = new Connexion(); //appel de connexion à la BD
        PreparedStatement pst;
        pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM `bulletin`"); // lister les admins
        pst.executeQuery(); // lister les admins
        ResultSet rs = (ResultSet) pst.executeQuery(); // stocker le résultat dans un resultset
        if (rs.next()) {
            return rs;
        } else {
            return null;
        }

    }

    public void ajout() {
        try {
// TODO add your handling code here:
            Connexion c = new Connexion();
            java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `bulletin`( `description`, `synthese`, `logiciel`, `gravite`, `source`, `id_user`) VALUES('" + this.getDescription() + "','" + this.getSynthese() + "','" + this.getLogiciel() + "','" + this.getGravite() + "','" + this.getSource() + "','" + this.getIdUser() + "')");
            statement.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex);

        }

    }

    public Bulletin(String description, String synthese, String logiciel, int gravite, String source, int idUser) {
        this.description = description;
        this.synthese = synthese;
        this.logiciel = logiciel;
        this.gravite = gravite;
        this.source = source;
        this.idUser = idUser;
    }

    public void delete() {
        try {
// TODO add your handling code here:
            Connexion c = new Connexion();
            String sql = "DELETE FROM `bulletin` WHERE `id`=?";
            java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
            statement.setInt(1, this.getId());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    public void update()
    {
    try {
// TODO add your handling code here:
Connexion c= new Connexion();
String sql="UPDATE `bulletin` SET `description`='"+this.getDescription()+"',gravite='"+this.getGravite()+"' ,`synthese`='"+this.getSynthese()+"' WHERE`id`='"+this.getId()+"';";
java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
statement.executeUpdate();

} catch (SQLException ex) {
System.out.println(ex);
}
    
    
    }
}
