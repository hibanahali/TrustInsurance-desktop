/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.User;
import Service.IUserService;
import ConnecxionDB.ConnexionDB;
import java.sql.Statement;

/**
 *
 * @author acer hiba
 */
public class UserService implements IUserService {

    
    private ConnexionDB cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserService() throws SQLException {
        cnx = ConnexionDB.getInstance();
    }

    @Override
    public void addUser(User u) {

        try {
            String req = "insert into fos_user(id, username, username_canonical, email, email_canonical, enabled,  salt, password, last_login, confirmation_token, password_requested_at, roles) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cnx.getCnx().prepareStatement(req);
            pstm.setInt(1, u.getId());
            pstm.setString(2, u.getUsername());
            pstm.setString(3, u.getUsername_canonical());
            pstm.setString(3, u.getEmail());
            pstm.setString(4, u.getEmail_canonical());
            pstm.setBoolean(5, u.getEnabled());
            pstm.setString(6, u.getSalt());
            pstm.setString(7, u.getPassword());
            pstm.setDate(8, (Date) u.getlast_login());
            pstm.setString(9, u.getConfirmation_token());
            pstm.setDate(10, (Date) u.getPassword_requested_at());
            pstm.setString(11, u.getRoles());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    /*
    public void updateUser(User u) {
        try {
            String req = "update fos_user set country=?, age=?, phone_number=?, Email=?, photo_membre=? where id=?";
            PreparedStatement pstm = ConnexionDB.getCnx().prepareStatement(req);
            pstm.setString(1, u.getCountry());
            
             pstm.setInt(2, u.getAge());
            pstm.setInt(3, u.getPhone_number());
            pstm.setString(4, u.getEmail());
            pstm.setString(5,u.getPhoto_membre());
            
       
            pstm.setInt(6, u.getId());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void updateUserEnabled(User u){
               try {
            String req = "update fos_user set enabled=? where id=?";
            PreparedStatement pstm = cnx.getCnx().prepareStatement(req);
            pstm.setBoolean(1, u.getEnabled());
   
            pstm.setInt(2, u.getId());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    */
    @Override
    public void deleteUser(int id) {
        try {
            String req = "delete from fos_user where id =?";
            PreparedStatement pstm = ConnexionDB.getCnx().prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/*
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            String req = "select * from fos_user";
            PreparedStatement pstm = ConnexionDB.getCnx().prepareStatement(req);
            ResultSet rs = pstm.executeQuery(req);
            while (rs.next()) {
                User u = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12) , rs.getInt(13));
                users.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    /*
    @Override
    public ArrayList<User> getUsersInfo(){
        ArrayList<User> users = new ArrayList<>();
       
        try { 
            String req = "select * from fos_user";
            PreparedStatement pstm;
            pstm = ConnexionDB.getCnx().prepareStatement(req);
            ResultSet rs = pstm.executeQuery(req);
            while(rs.next()){
                String name = rs.getString("username");
                User u = new User(name);
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
        
    }

    @Override
    public User findUserById(int id) {
        User u = null;
        String req = "select * from fos_user where id=?";

        try {
            PreparedStatement pstm = cnx.getCnx().prepareStatement(req);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
            u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13), rs.getString(14),rs.getInt(15),rs.getString(16),rs.getInt(17));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;

    }

    @Override
    public User findUserByUsername(String username) {
        User u = null;
        System.out.println(username);
        String req = "SELECT * FROM `fos_user` WHERE `username` = ?";
        try {
            PreparedStatement pstm = cnx.getCnx().prepareStatement(req);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
           u = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13), rs.getString(14),rs.getInt(15),rs.getString(16),rs.getInt(17));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;

    }
     @Override
    public User findUserByEmail(String Email) {
        User u = null;
        String req = "select * from fos_user where email=?";
        try {
            PreparedStatement pstm = cnx.getCnx().prepareStatement(req);
            pstm.setString(1, Email);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
           u = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13), rs.getString(14),rs.getInt(15),rs.getString(16),rs.getInt(17));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;

    }
    public User getUser() {
        String req = "select * from fos_user WHERE connecte=1";
        User u = null;

        try {
            pst = cnx.getCnx().prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                u = new User(rs.getString("username"), rs.getString("email"),rs.getString("stripe_id"));
                System.out.println("aaa");
                System.out.println(rs.getString("username")+" "+ rs.getString("email")+" "+rs.getString("stripe_id"));
            }
        } catch (SQLException ex) {

        }
        return u;
    }
/*
    public void add_stripe_user(String id_stripe, User u) {
        String req = "UPDATE `fos_user` SET `stripe_id` = '"+id_stripe+"' where email = ?";
        try {
            //System.out.println(u.getEmail());
            pst = cnx.getCnx().prepareStatement(req);
            pst.setString(1, u.getEmail());
            
            pst.executeUpdate();
        } catch (SQLException ex) {

        }
    }
    
    
    
    public String get_stripe_user(String t) throws SQLException {
        String s = null;
        String req = "select stripe_id from fos_user where email = '"+t+"'";
         User u = null;

        try {
            pst = cnx.getCnx().prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException ex) {

        }
        
        return s;
    }
    
    */
    public void VerifierConnexion(int c, String mail) {

        String req = "UPDATE `fos_user` SET  `connecte`= ? WHERE `username`= ?";
        try {
            pst = ConnexionDB.getCnx().prepareStatement(req);
            pst.setInt(1, 1);
            pst.setString(2, mail);
            pst.executeUpdate();
        } catch (SQLException ex) {

        }
    }
    
    
   
    public User getUserRole() {
        String req = "SELECT `username`, `roles` FROM `fos_user` WHERE `connecte` = 1";
        User u = new User();

        try {
            pst = cnx.getCnx().prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                u.setUsername(rs.getString(1));
                System.out.println(u.getUsername());
                u.setRoles(rs.getString(2));
                System.out.println(u.getRoles());
            }
        } catch (SQLException ex) {

        }
        return u;
    }

    @Override
    public void updateUser(User r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUsersInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findUserByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findUserByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    




}
