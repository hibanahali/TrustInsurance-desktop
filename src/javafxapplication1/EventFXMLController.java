/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entities.Event;
import Service.Service_Event;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author marwen
 */
public class EventFXMLController implements Initializable {

    @FXML
    private ImageView pic1;
    @FXML
    private TextField capacite;
    @FXML
    private Button ajouter_image;
    @FXML
    private TextField lieu;
    @FXML
    private TextField nom;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextArea des;
    @FXML
    private JFXTextField prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouter_image.setOnAction(e -> {
            Image img = pic1.getImage();
            try {
                String nameImage1 = saveToFileImageNormal(img);
                Event ev = new Event();
                int cap = Integer.parseInt(capacite.getText());
               
                
                ev = new Event(0, Date.valueOf(date_debut.getValue()), Date.valueOf(date_fin.getValue()), des.getText(), 0, cap, lieu.getText(), nom.getText(), nameImage1, 0);
                Service_Event sev = new Service_Event();
                sev.insert(ev);
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
                Stage stage = new Stage();
                stage.close();
                Scene scene = new Scene(root);
                Stage stagee = (Stage) ajouter_image.getScene().getWindow();

                stagee.close();
               stage.setScene(scene);
                stage.show();
            } catch (SQLException ex) {
                
            } catch (IOException ex) {
                Logger.getLogger(EventFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
    }

    public static String saveToFileImageNormal(Image image) throws SQLException {

        String ext = "jpg";
        File dir = new File("C:\\wamp64\\www\\uploads");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    @FXML
    private void addImage(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            pic1.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
