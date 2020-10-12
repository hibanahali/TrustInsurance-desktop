/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entities.Article;
import Entities.Event;
import Service.service_article;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static javafxapplication1.EventFXMLController.saveToFileImageNormal;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author acer hiba
 */
public class ArticleFXMLController implements Initializable {

    @FXML
    private ImageView pic1;
    @FXML
    private JFXTextField capacite;
    @FXML
    private JFXTextArea des;
    @FXML
    private JFXButton ajouter_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ajouter_image.setOnAction(e->{
           try {
               Image img = pic1.getImage();
               String nameImage1 = saveToFileImageNormal(img);
               Article ev = new Article();
            
               
               
               ev = new Article(0,capacite.getText(), des.getText(), nameImage1,0);
               service_article sa = new service_article();
               sa.insert(ev);
               Parent root;
                root = FXMLLoader.load(getClass().getResource("Afficher_article.fxml"));
                Stage stage = new Stage();
                stage.close();
                Scene scene = new Scene(root);
                Stage stagee = (Stage) ajouter_image.getScene().getWindow();

                stagee.close();
               stage.setScene(scene);
                stage.show();
           } catch (SQLException ex) {
               Logger.getLogger(ArticleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ArticleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
