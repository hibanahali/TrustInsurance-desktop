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
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer hiba
 */
public class Afficher_ArticleController implements Initializable {

    @FXML
    private TableView<Article> table_view_event;
    
    @FXML
    private TableColumn<Article, String> description;
    @FXML
    private Rectangle rectangle;
    @FXML
    private JFXButton chercher;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton got_to_modifier;
    @FXML
    private JFXButton go_to_add;
    @FXML
    private JFXTextField search_bar;
    @FXML
    private JFXButton retour;
    @FXML
    private TableColumn<Article, String> titre;
    @FXML
    private TableColumn<Article, String> nombre_like;

    /**
     * Initializes the controller class.
     */
    public void Afficher()
    {
        service_article ps = new service_article();
        ArrayList list = (ArrayList) ps.getShow();
        ObservableList<Article> obslist = FXCollections.observableArrayList(list);
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        description.setCellValueFactory(new PropertyValueFactory<>("nbr_like"));
        nombre_like.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        table_view_event.setItems(obslist);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Afficher();
        go_to_add.setOnAction(e->{
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("ArticletFXML.fxml"));
                Stage stage = new Stage();
                stage.close();
                Scene scene = new Scene(root);
                Stage stagee = (Stage) go_to_add.getScene().getWindow();

                stagee.close();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Afficher_ArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        delete.setOnAction(e->{
               Article ev = new Article();
                        service_article sev = new service_article();
                        ev = table_view_event.getSelectionModel().getSelectedItem();
                        sev.delete(ev);
                        Afficher();
        });
    }    

    @FXML
    private void afficher_taswira(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Article e = table_view_event.getSelectionModel().getSelectedItem();
            Image imageURI2 = new Image("file:C://wamp64/www/uploads/" + e.getImage());//C:\\wamp64\\www\\uploads
            rectangle.setFill(new ImagePattern(imageURI2));
        }
    }
    
}
