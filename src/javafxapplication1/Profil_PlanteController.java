/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entities.Event;
import Entities.User;
import Service.Service_Event;
import Service.UserService;
//import Service.UserService;
//import entities.Plante;
//import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
//import vikings.Stock.Afficher_stockController;

/**
 * FXML Controller class
 *
 * @author Baz enna
 */
public class Profil_PlanteController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label dispo;
    @FXML
    private Label prix;
    @FXML
    private Rectangle rectangle;
    @FXML
    private AnchorPane ap;
    @FXML
    private Button acheter;
    @FXML
    private Label id_stripe_plante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      id_stripe_plante.setVisible(true);
  
    
    
       acheter.setOnAction(e->{
          try {
              Service_Event se = new Service_Event();
              Event ev =new Event();
              ev.setNom(nom.getText());
              se.incr_nobmbre_participant(ev);
              Stage stage = new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("ListEvent.fxml"));
              
              Scene scene = new Scene(root);
              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(Profil_PlanteController.class.getName()).log(Level.SEVERE, null, ex);
          }
       });
    }

    public void LoadValues(Event e) throws IOException {
        Service_Event sp= new Service_Event();
        nom.setText(e.getNom());
        dispo.setText(e.getDescription());
        prix.setText(String.valueOf(e.getNb_participant()));
        Image imageURI2 = new Image("file:C://wamp64/www/uploads/" + e.getImage());
        rectangle.setFill(new ImagePattern(imageURI2));
        String s = sp.get_stripe_id(e.getNom());
        id_stripe_plante.setText(s);
    }

    public Profil_PlanteController() {
        
    }

}
