/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import Entities.Event;
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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Baz enna
 */
public class DiveventController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label nom;
    @FXML
    private Label prix;
    @FXML
    private Label id;
    @FXML
    private Rectangle rectangle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void LoadValues(Event e) throws IOException {
        System.out.println(e.getNom());
        nom.setText(e.getNom());

        //   etoile.setRating(Double.valueOf(e.getEtoile()));
        prix.setText(String.valueOf("nombre de participant "+e.getNb_participant()) );
        id.setText(String.valueOf(e.getId()));

             sq.setPadding(new Insets(-10, -10, -10, -10));
        //    circle.setFill(new ImagePattern(imageURI));
//       qualite.setRating(e.getMoyqualite());
        Image imageURI2 = new Image("file:C://wamp64/www/uploads/" + e.getImage());//C:\\wamp64\\www\\uploads
        rectangle.setFill(new ImagePattern(imageURI2));

        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    doubleclick(event, e);
                }

            }
        });

    }

    public void doubleclick(MouseEvent event, Event selectedetab) {
        if (event.getClickCount() == 2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil_Plante.fxml"));
                Parent root = loader.load();
                Profil_PlanteController DDC = loader.getController();
                DDC.LoadValues(selectedetab);
                /*
                FXMLLoader loade = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Parent roo = loade.load();
                HomePageController Dhp = loade.getController();*/
                Stage ss = new Stage();
                Scene sc = new Scene(root);
                ss.setScene(sc);
                

                ss.show();

            } catch (IOException ex) {
                Logger.getLogger(DiveventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

}
