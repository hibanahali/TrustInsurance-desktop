/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnecxionDB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fahdj
 */
public class ConnexionDB {

    /**
     * @param args the command line arguments
     */
    private static String url="jdbc:mysql://localhost:3306/inssurance";
    private static String login="root";    
    private static String pwd= "";
    private static Connection cnx;
    private static ConnexionDB con;
    private ConnexionDB() {
           
        try {
            cnx =DriverManager.getConnection(url, login, pwd);
            System.out.println("connected");
            
// TODO code application logic here
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ConnexionDB getInstance(){
        if(con==null)
        {
            con = new ConnexionDB();
        }
        return con;
    }
   
    
    public static void main(String[] args) {
     ConnexionDB con= new ConnexionDB();       
    }

    public static Connection getCnx() {
        return cnx;
    }

}