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
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author acer hiba
 */
public class ListArticleController implements Initializable {

    @FXML
    private JFXTextField recherchetext;
    @FXML
    private ScrollPane pane;
    @FXML
    private JFXComboBox<?> tri;
    private ObservableList<Article> data;
    @FXML
    private JFXButton retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        service_article Lp = new service_article();
        
        TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
       
        data = FXCollections.observableArrayList(Lp.getShow());
        retour.setOnAction(e->{
           
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Authentification.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                Stage stagee = (Stage) retour.getScene().getWindow();

                stagee.close();
               stage.setScene(scene);
                stage.setScene(scene);
                stage.show();
///Interfaces/Authentification.fxml
            } catch (IOException ex) {
                Logger.getLogger(ListEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        for (Article d : data) {
         
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("divArticle.fxml"));
                Parent root = (Pane) loader.load();
                DivarticleController DHC = loader.getController();
                DHC.LoadValues(d);

                c.setVgap(40);
                c.getChildren().removeAll();

                c.getChildren().add(root);
            } catch (IOException ex) {

            }
        }
        c.setPrefColumns(3);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(10);
        c.setVgap(80);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        pane.setContent(b);
    }    

    @FXML
    private void RechercheDynamique(KeyEvent event) {
    }
    
}
