/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Service.Service_Event;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import Entities.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;


/* FXML Controller class
 *
 * @author Baz enna
 */
public class ListEventController implements Initializable {

    @FXML
    private JFXTextField recherchetext;
    @FXML
    private ScrollPane pane;
    @FXML
    private JFXComboBox<String> tri;
    private ObservableList<Event> data;
    @FXML
    private JFXButton retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        Service_Event Lp = new Service_Event();
        tri.getItems().addAll("Meilleur Prix");
        tri.getItems().addAll("Meilleur rating");
        tri.getItems().addAll("Default order");
        tri.setValue("Default order");
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
        for (Event d : data) {
         
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("divEvent.fxml"));
                Parent root = (Pane) loader.load();
                DiveventController DHC = loader.getController();
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
    private void RechercheDynamique(KeyEvent event) throws SQLException {
         Service_Event LDS = new Service_Event();
        data = FXCollections.observableArrayList(LDS.getShow());
        FilteredList<Event> filteredData = new FilteredList<>(data, e -> true);
        recherchetext.setOnKeyReleased(e
                -> {
            recherchetext.textProperty().addListener((ObservableValue<? extends String> ObservableValue, String oldValue, String newValue) -> {
                filteredData.setPredicate((Predicate<? super Event>) new Predicate<Event>() {
                    @Override
                    public boolean test(Event d) {
                        if (newValue == null || newValue.isEmpty()) {

                            return true;

                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return d.getNom().toLowerCase().contains(lowerCaseFilter.subSequence(0, lowerCaseFilter.length()));
                    }
                });
            });
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            for (Event d : filteredData) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("divPlante.fxml"));
                    Parent root = (Pane) loader.load();
                    DiveventController DHC = loader.getController();
                    DHC.LoadValues(d);

                    c.getChildren().removeAll();

                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(ListEventController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);
        });

    }

}
