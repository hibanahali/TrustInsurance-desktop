/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ConnecxionDB.ConnexionDB;
import Entities.Article;
import Entities.Evennement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author acer hiba
 */
public class service_article implements Crud<Article> {

    private ConnexionDB con;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public service_article() {
        con = ConnexionDB.getInstance();
    }

    @Override
    public void insert(Article t) {
         String req = "INSERT INTO `article`( `titre`, `text`, `image`,`likes`) VALUES  (?,?,?,?)";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);
            pst.setString(1, t.getTitre());
            pst.setString(2, t.getText());
            pst.setString(3, t.getImage());
            pst.setInt(4, 0);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(service_article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void delete(Article t) {
        String req="delete from article where id=?";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(service_article.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    public void Update(Article t) {
        String req = "UPDATE `article` SET `titre`=?,`text`=?,`image`=?,`likes`=?] WHERE `id`=?";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);
            pst.setString(1, t.getTitre());
            pst.setString(2, t.getText());
            pst.setString(2, t.getImage());
            pst.setInt(4, 0);
            pst.setInt(5, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(service_article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public List<Article> getShow() {
       String req="SELECT * from article";
        List<Article> list= new ArrayList<>();
        try {
            ste=ConnexionDB.getCnx().createStatement();
            rs=ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(service_article.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }

    @Override
    public Article getelement(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

} 
