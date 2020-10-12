/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Entities.User;
import Service.UserService;
import ConnecxionDB.BCrypt;

/**
 *
 * @author Camilia
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private JFXPasswordField pwd;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private TextField emaile;
    @FXML
    private Label statusUser;
    @FXML
    private Label length;
    @FXML
    private Label statusConfirmer;
    @FXML
    private Label statusEmail;
    @FXML
    private Label pwdStatus;
    @FXML
    private AnchorPane anchorpane;
    private User u;
    @FXML
    private JFXComboBox paysB;
    private final ObservableList<String> listePays = FXCollections.observableArrayList("Afghanistan", " Albanie", " Antarctique", " Algérie", " Samoa Américaines", " Andorre", " Angola", " Antigua-et-Barbuda", " Azerbaïdjan", " Argentine", " Australie", " Autriche", " Bahamas", " Bahreïn", " Bangladesh", " Arménie", " Barbade", " Belgique", " Bermudes", " Bhoutan", " Bolivie", " Bosnie-Herzégovine", " Botswana", " Île Bouvet", " Brésil", " Belize", " Territoire Britannique de Océan Indien", " Îles Salomon", " Îles Vierges Britanniques", " Brunéi Darussalam", " Bulgarie", " Myanmar", " Burundi", " Bélarus", " Cambodge", " Cameroun", " Canada", " Cap-vert", " Îles Caïmanes", " République Centrafricaine", " Sri Lanka", " Tchad", " Chili", " Chine", " Taïwan", " Île Christmas", " Îles Cocos (Keeling)", " Colombie", " Comores", " Mayotte", " République du Congo", " République Démocratique du Congo", " Îles Cook", " Costa Rica", " Croatie", " Cuba", " Chypre", " République Tchèque", " Bénin", " Danemark", " Dominique", " République Dominicaine", " Équateur", " El Salvador", " Guinée Équatoriale", " Éthiopie", " Érythrée", " Estonie", " Îles Féroé", " Îles (malvinas) Falkland", " Géorgie du Sud et les Îles Sandwich du Sud", " Fidji", " Finlande", " Îles Åland", " France", " Guyane Française", " Polynésie Française", " Terres Australes Françaises", " Djibouti", " Gabon", " Géorgie", " Gambie", " Territoire Palestinien Occupé", " Allemagne", " Ghana", " Gibraltar", " Kiribati", " Grèce", " Groenland", " Grenade", " Guadeloupe", " Guam", " Guatemala", " Guinée", " Guyana", " Haïti", " Îles Heard et Mcdonald", " Saint-Siège (état de la Cité du Vatican)", " Honduras", " Hong-Kong", " Hongrie", " Islande", " Inde", " Indonésie", " République Islamique Iran", " Iraq", " Irlande", " Israël", " Italie", " Côte Ivoire", " Jamaïque", " Japon", " Kazakhstan", " Jordanie", " Kenya", " République Populaire Démocratique de Corée", " République de Corée", " Koweït", " Kirghizistan", " République Démocratique Populaire Lao", " Liban", " Lesotho", " Lettonie", " Libéria", " Jamahiriya Arabe Libyenne", " Liechtenstein", " Lituanie", " Luxembourg", " Macao", " Madagascar", " Malawi", " Malaisie", " Maldives", " Mali", " Malte", " Martinique", " Mauritanie", " Maurice", " Mexique", " Monaco", " Mongolie", " République de Moldova", " Montserrat", " Maroc", " Mozambique", " Oman", " Namibie", " Nauru", " Népal", " Pays-Bas", " Antilles Néerlandaises", " Aruba", " Nouvelle-Calédonie", " Vanuatu", " Nouvelle-Zélande", " Nicaragua", " Niger", " Nigéria", " Niué", " Île Norfolk", " Norvège", " Îles Mariannes du Nord", " Îles Mineures Éloignées des États-Unis", " États Fédérés de Micronésie", " Îles Marshall", " Palaos", " Pakistan", " Panama", " Papouasie-Nouvelle-Guinée", " Paraguay", " Pérou", " Philippines", " Pitcairn", " Pologne", " Portugal", " Guinée-Bissau", " Timor-Leste", " Porto Rico", " Qatar", " Réunion", " Roumanie", " Fédération de Russie", " Rwanda", " Sainte-Hélène", " Saint-Kitts-et-Nevis", " Anguilla", " Sainte-Lucie", " Saint-Pierre-et-Miquelon", " Saint-Vincent-et-les Grenadines", " Saint-Marin", " Sao Tomé-et-Principe", " Arabie Saoudite", " Sénégal", " Seychelles", " Sierra Leone", " Singapour", " Slovaquie", " Viet Nam", " Slovénie", " Somalie", " Afrique du Sud", " Zimbabwe", " Espagne", " Sahara Occidental", " Soudan", " Suriname", " Svalbard etÎle Jan Mayen", " Swaziland", " Suède", " Suisse", " République Arabe Syrienne", " Tadjikistan", " Thaïlande", " Togo", " Tokelau", " Tonga", " Trinité-et-Tobago", " Émirats Arabes Unis", " Tunisie", " Turquie", " Turkménistan", " Îles Turks et Caïques", " Tuvalu", " Ouganda", " Ukraine", "ex-République Yougoslave de Macédoine", " Égypte", " Royaume-Uni", " Île de Man", " République-Unie de Tanzanie", " États-Unis", " Îles Vierges des États-Unis", " Burkina Faso", " Uruguay", " Ouzbékistan", " Venezuela", " Wallis et Futuna", " Samoa", " Yémen", " Serbie-et-Monténégro", " Zambie");
    @FXML
    private Button back;
    @FXML
    private TextField agel;
    @FXML
    private Label agen;
    @FXML
    private JFXComboBox genreB;
    private final ObservableList<String> listeGenre = FXCollections.observableArrayList("Homme", "Femme");
    @FXML
    private TextField numl;
    @FXML
    private Label nulb;

    @FXML
    public void Inscriptions(ActionEvent event) throws Exception {

        UserService us = new UserService();
        String username = nom.getText();
        String password = pwd.getText();
        String password2 = pwd2.getText();
        String email = emaile.getText();
        String genre = (String) genreB.getValue();
        String p = (String) paysB.getValue();
            
//         SpinnerValueFactory<Integer> valueFactory =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100,8);
        if (username.length() > 0 && password.length() > 0 && email.length() > 0) {
            if (us.findUserByUsername(username) == null) {
                if (ValidateEmail(email) && us.findUserByEmail(email) == null) {
                    if (password.equals(password2)) {
                        if (password.length() > 8 && !password.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$")) {
                            if (isInteger(agel.getText()) && Integer.parseInt(agel.getText()) < 100 && Integer.parseInt(agel.getText()) > 8) {
                                if (isInteger(numl.getText()) && Integer.parseInt(numl.getText()) < 1000000000 && Integer.parseInt(numl.getText()) > 999) {

                                    Integer age = Integer.parseInt(agel.getText());
                                    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(13));
                                    StringBuilder finalpassword = new StringBuilder(hashedPassword);
                                    finalpassword.setCharAt(2, 'y');
                                    String pass = finalpassword.toString();
                                    User u;

                                    u = new User(username, username, email, email, true, null, pass, null, null, null, "user", "", genre, 0, p, age);
                                    us.addUser(u);
                                    System.out.println("user added");
                                    pwdStatus.setText("");
                                    statusConfirmer.setText("");
                                    statusEmail.setText("");
                                    statusUser.setText("");
                                    length.setText("");
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Utilisateur Ajouté");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Bienvenu :D");

                                    alert.showAndWait();
                                    Stage stage = (Stage) back.getScene().getWindow();
                                    stage.close();
                                } else {
                                    pwdStatus.setText("");
                                    statusConfirmer.setText("");
                                    statusEmail.setText("");
                                    statusUser.setText("");
                                    length.setText("");
                                    agen.setText("");
                                    nulb.setText("le numero est invalide");

                                }
                            } else {
                                pwdStatus.setText("");
                                statusConfirmer.setText("");
                                statusEmail.setText("");
                                statusUser.setText("");
                                length.setText("");
                                agen.setText("l'age est invalide");

                            }
                        } else {
                            pwdStatus.setText("");
                            statusConfirmer.setText("");
                            statusEmail.setText("");
                            statusUser.setText("");
                            length.setText("");
                            agen.setText("");
                            pwdStatus.setText("le mdp doit etre supérieu a 8 et contenir une lettre majuscule et un numero");

                        }

                    } else {
                        pwdStatus.setText("");
                        statusConfirmer.setText("");
                        statusEmail.setText("");
                        statusUser.setText("");
                        length.setText("");
                        agen.setText("");
                        statusConfirmer.setText("les deux mots de passe ne sont pas identiques");
                    }

                } else {
                    pwdStatus.setText("");
                    statusConfirmer.setText("");
                    statusEmail.setText("");
                    statusUser.setText("");
                    length.setText("");
                    agen.setText("");
                    statusEmail.setText("l'email est invalide ou existe deja");
                }
            } else {
                pwdStatus.setText("");
                statusConfirmer.setText("");
                statusEmail.setText("");
                statusUser.setText("");
                length.setText("");
                agen.setText("");
                statusUser.setText("ce nom est deja utilisé");
            }
        } else {
            pwdStatus.setText("");
            statusConfirmer.setText("");
            statusEmail.setText("");
            statusUser.setText("");
            length.setText("");
            agen.setText("");
            length.setText("les champs ne doivent pas etre vide");
        }

    }

    public Boolean ValidateEmail(String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return true;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paysB.setValue("Tunisie");
        paysB.setItems(listePays);
        genreB.setValue("Homme");
        genreB.setItems(listeGenre);

    }

    @FXML
    private void backB(ActionEvent event) {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), radix) < 0) {
                return false;
            }
        }
        return true;
    }

}
