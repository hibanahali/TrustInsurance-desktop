/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ConnecxionDB.ConnexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer hiba
 */
public class ServiceCategorie {
        Connection C=ConnexionDB.getInstance().getCnx();

        
        
    public int getIDCategorie_ParNom(String Categorie_nom)  {
        try {
            Statement statement = C.createStatement();
            String requete = "select id from categorie where name = '"+Categorie_nom+"' ";
            System.out.println("requete = "+requete);
            ResultSet resultat = statement.executeQuery(requete);
            int c=-1 ; 
            while (resultat.next()) {
                c=resultat.getInt("id");
                System.out.println("id categorie = "+c);
                
            }
            return c;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des categorie ds le combobox " + ex.getMessage());
        } 
        
        
        return -1 ; 
     }  
        
        
        
    public List<String> DisplayCategorie() {

        List<String> listeGenre = new ArrayList<>();
        String requete = "select name from categorie";
        System.out.println("requete = "+requete);
        try {
            Statement statement = C.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                String type ;
                type=resultat.getString("name");
                System.out.println("type = "+type);
                listeGenre.add(type);
            }
            return listeGenre;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des categorie ds le combobox " + ex.getMessage());
            return null;
        }
    }







}
