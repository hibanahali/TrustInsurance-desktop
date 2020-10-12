/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwen
 */
public class AccueilController implements Initializable {

    @FXML
    private JFXButton go_to_events;
    @FXML
    private JFXButton autre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             autre.setOnAction(e->{
         try {
             Parent root;
             root = FXMLLoader.load(getClass().getResource("ListEvent.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);
             
             stage.setScene(scene);
             Stage stagee = (Stage) autre.getScene().getWindow();
             
             stagee.close();
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
         }
    });  
             
    }
    @FXML
 private void free(MouseEvent event) throws IOException
 {
     if(event.getSource() == go_to_events)
     {
         try{
         Parent root;
         root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
         Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
         stage.close();
         Scene scene = new Scene(root);

         stage.setScene(scene);
         stage.show();
     }
         catch(IOException ex){
             
         }
     }
    
     
       
 }
    
}
