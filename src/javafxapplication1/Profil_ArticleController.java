/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entities.Article;
import Entities.Event;
import Service.Service_Event;
import Service.service_article;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author acer hiba
 */
public class Profil_ArticleController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Label nom;
    @FXML
    private Label dispo;
    @FXML
    private Label prix;
    @FXML
    private Button acheter;
    @FXML
    private Label id_stripe_plante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void LoadValues(Article e) throws IOException {
        service_article sp= new service_article();
        nom.setText(e.getTitre());
        dispo.setText(e.getDescription());
        prix.setText(String.valueOf(e.getNbr_like()));
        Image imageURI2 = new Image("file:C://wamp64/www/uploads/" + e.getImage());
        rectangle.setFill(new ImagePattern(imageURI2));
        
      
    }

    
}
