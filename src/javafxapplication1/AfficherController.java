/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entities.Evennement;
import static Service.DateCon.cDate;
import Service.Service_Evennement;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author marwen
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Evennement> table_view_event;
    @FXML
    private TableColumn<Evennement, String> date_debut;
    @FXML
    private TableColumn<Evennement, String> date_fin;
    @FXML
    private TableColumn<Evennement, String> description;
    @FXML
    private TableColumn<Evennement, String> nombre_participant;
    @FXML
    private TableColumn<Evennement, String> capacite;
    @FXML
    private TableColumn<Evennement, String> lieu;
    @FXML
    private TableColumn<Evennement, String> nom;
    @FXML
    private Button go_to_add;
    @FXML
    private Button got_to_modifier;
    @FXML
    private Button delete;
    @FXML
    private TextField search_bar;
    @FXML
    private Button chercher;
    @FXML
    private Rectangle rectangle;
    @FXML
    private JFXButton retour;

    /**
     * Initializes the controller class.
     */
    public void afficher() {
        Service_Evennement ps = new Service_Evennement();
        ArrayList list = (ArrayList) ps.getShow();
        ObservableList<Evennement> obslist = FXCollections.observableArrayList(list);
        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        nombre_participant.setCellValueFactory(new PropertyValueFactory<>("nb_participant"));
        capacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       
        table_view_event.setItems(obslist);
    }

    public void afficherAdvanced(String t) {
        Service_Evennement ps = new Service_Evennement();
        ArrayList list = (ArrayList) ps.getShowAdvanced(t);
        ObservableList<Evennement> obslist = FXCollections.observableArrayList(list);
        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        nombre_participant.setCellValueFactory(new PropertyValueFactory<>("nb_participant"));
        capacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        table_view_event.setItems(obslist);
    }

    public void afficherunique(String t) {
        Service_Evennement ps = new Service_Evennement();
        Evennement ev = new Evennement();
        ev = ps.getelement(t);
        List<Evennement> l = new ArrayList<>();
        l.add(ev);
        ArrayList list = (ArrayList) l;
        ObservableList<Evennement> obslist = FXCollections.observableArrayList(list);
        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        nombre_participant.setCellValueFactory(new PropertyValueFactory<>("nb_participant"));
        capacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       
        table_view_event.setItems(obslist);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
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
        go_to_add.setOnAction(e -> {

            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("EventFXML.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                Stage stagee = (Stage) go_to_add.getScene().getWindow();

                stagee.close();
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               
                        Evennement ev = new Evennement();
                        Service_Evennement sev = new Service_Evennement();
                        ev = table_view_event.getSelectionModel().getSelectedItem();
                        sev.delete(ev);
                        afficher();
                   
            }
        });
        search_bar.textProperty().addListener((observable, oldValue, newValue) -> {
            afficherAdvanced(newValue);
        });
        chercher.setOnAction(e -> {
            afficherunique(search_bar.getText());
        });
        got_to_modifier.setOnAction(e -> {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Update.fxml"));
                Parent root = loader.load();
                Update det = (Update) loader.getController();
                Evennement ev = table_view_event.getSelectionModel().getSelectedItem();
                det.remplir(/*DDD, DF,*/String.valueOf(ev.getCapacite()), ev.getNom(), ev.getLieu(), ev.getDescription());

                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Update event");
                stage.setScene(new Scene(root));
                Stage stagee = (Stage) got_to_modifier.getScene().getWindow();
                stagee.close();
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    @FXML
    private void afficher_taswira(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Evennement e = table_view_event.getSelectionModel().getSelectedItem();
            Image imageURI2 = new Image("file:C://wamp64/www/uploads/" + e.getImage());//C:\\wamp64\\www\\uploads
            rectangle.setFill(new ImagePattern(imageURI2));
        }
    }

}
