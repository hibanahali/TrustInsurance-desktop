/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ConnecxionDB.ConnexionDB;
import Entities.Evennement;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer hiba
 */
public class Service_Evennement implements Crud<Evennement> {

    private ConnexionDB con;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public Service_Evennement() {
        con = ConnexionDB.getInstance();
    }

    @Override
    public void insert(Evennement t) {
        String req = "INSERT INTO `evennement`(`id`, `titre`, `description`, `image`, `participants`, `last_modification`, `due_date`, `start_date`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.setString(2, t.getTitre());
            pst.setString(3, t.getDescription());
            pst.setString(4, t.getImage());
            pst.setInt(5, t.getParticipants());
            pst.setDate(6, (Date) t.getLast_modification());
            pst.setDate(7, (Date) t.getDue_date());
            pst.setDate(8, (Date) t.getStart_date());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void delete(Evennement t) {
        String req = "delete from evennement where id=?";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Update(Evennement t) {
        String req = "UPDATE `evennement` SET `id`=?,`titre`=?,`description`=?,`image`=?,`participants`=?,`last_modification`=?,`due_date`=?,`start_date`=?";
        try {
            
            pst = ConnexionDB.getCnx().prepareStatement(req);
            
            pst.setInt(1, t.getId());
            pst.setString(2, t.getTitre());
            pst.setString(3, t.getDescription());
            pst.setString(4, t.getImage());
            pst.setInt(5, t.getParticipants());
            pst.setDate(6, (Date) t.getLast_modification());
            pst.setDate(7, (Date) t.getDue_date());
            pst.setDate(8, (Date) t.getStart_date());
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evennement> getShow() {
        String req = "SELECT * from evennement";
        List<Evennement> list = new ArrayList<>();
        try {
            ste = ConnexionDB.getCnx().createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Evennement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getDate(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    /*
    @Override
    public Evennement getelement(String t) {
        String requete = "select * from evennement where nom = '" + t + "'";
        Evennement e = new Evennement();
        try {
            ste = ConnexionDB.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                e = new Evennement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getDate(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public Evennement getelementt(String t) {
        String requete = "select * from event where id = '" + t + "'";
        Evennement e = new Evennement();
        try {
            ste = ConnexionDB.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                e = new Evennement(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getDate(8) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    
  
    public List<Evennement> getShowAdvanced(String t) {
        String requete = "select * from event where nom like '%" + t + " %' or capacite like '%" + t + "%' or description like '%" + t + "%'";
        List<Evennement> list = new ArrayList<>();
        try {
            ste = ConnexionDB.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                list.add(new Evennement(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getDate(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    public String get_stripe_id(String t) {
        String s = "";
        String requete = "select stripe_id from Event where nom = '" + t + "' ";
        try {
            ste = ConnexionDB.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;

    }


    public int get_nobmbre_participant(Evennement e) {
        int s = 0;
        String requete = "select participants  from evennement where id = '" + e.getId() + "' ";
        try {
            ste = ConnexionDB.getCnx().createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                s = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s);
        return s;
    }

    public int incr_nobmbre_participant(Evennement e) {
        int s = get_nobmbre_participant(e);
        System.out.println(e);
        String req = "UPDATE `evennement` SET `participants`=? WHERE `id`=?";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);

            pst.setInt(1, s + 1);
            pst.setInt(2, e.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_Evennement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
*/

    @Override
    public Evennement getelement(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
