package InterfaceGraph;

import Classes.Carte;
import Classes.JeuDeCartes;
import Classes.Poker;
import Exceptions.ExceptionManqueCarte;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea txtOutput;
    @FXML
    private ImageView imgDosCarte;
    @FXML
    private ImageView imgCarte1;
    @FXML
    private ImageView imgCarte2;
    @FXML
    private ImageView imgCarte3;
    @FXML
    private ImageView imgCarte4;
    @FXML
    private ImageView imgCarte5;

    //Déclaration de l'objet JeuDeCartes
    private JeuDeCartes paquet;

    //Déclaration du tableau pour stocker les ImageView
    private ImageView[] tabImgCarte;

    //Compteur de cartes distribuées
    private int nbCartesEnJeu;

    //Compteur de click pour les images de dos de cartes
    private int click = 0;

    //Main de poker List
    private List<Carte> mainPoker = new ArrayList(5);

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Instancier un nouvel objet de type JeuDeCartes
        paquet = new JeuDeCartes();

        //Instancier le tableau ImageView
        tabImgCarte = new ImageView[5];

        tabImgCarte[0] = imgCarte1;
        tabImgCarte[1] = imgCarte2;
        tabImgCarte[2] = imgCarte3;
        tabImgCarte[3] = imgCarte4;
        tabImgCarte[4] = imgCarte5;

        //Image du dos de carte initiale
        String dosCarte = "/Images/back0.gif";
        imgDosCarte.setImage(new Image(dosCarte));

    }

    @FXML
    private void brasser(ActionEvent event) {

        paquet.brasser();
        txtOutput.clear();
        nbCartesEnJeu = 0;

        for (ImageView img : tabImgCarte) {
            img.setImage(null);
        }
    }

    @FXML
    private void distribuer(ActionEvent event) throws ExceptionManqueCarte {

        String nom;
        txtOutput.setText("");
        Carte carteActuelle;

        mainPoker.clear();

        for (ImageView img : tabImgCarte) {
            img.setImage(null);
        }

        try {

            for (int i = 0; i < 5; i++) {
                carteActuelle = paquet.distribuer();
                nom = "/Images/" + carteActuelle.getCouleur().toString().toLowerCase() + "_" + carteActuelle.getFace().toString().toLowerCase() + ".gif";
                tabImgCarte[i].setImage(new Image(nom));
                nbCartesEnJeu++;
                //Ajouter la carte à l'ArrayList mainPoker
                mainPoker.add(carteActuelle);
            }

            checkPokerHand();

        } catch (ExceptionManqueCarte e) {
            txtOutput.setText(e.getMessage());
        }

    }

    @FXML
    private void changerArriere(MouseEvent event) {

        click++;
        if (click > 9) {
            click = 0;
        }
        String nom = "/Images/back" + click + ".gif";
        imgDosCarte.setImage(new Image(nom));

    }

    private void checkPokerHand() {

        txtOutput.clear();

        String resultat = "";

        if (Poker.isFlush(mainPoker)) {
            resultat += "Vous avez un Flush !";
        } else if (Poker.isStraight(mainPoker)) {
            resultat += "Vous avez une Suite !";
        } else if (Poker.is4s(mainPoker)) {
            resultat += "Vous avez un Quadruple !";
        } else if (Poker.isFullHouse(mainPoker)) {
            resultat += "Vous avez un Full House !";
        } else if (Poker.is3s(mainPoker)) {
            resultat += "Vous avez un Triple !";
        } else if (Poker.is22s(mainPoker)) {
            resultat += "Vous avez deux Paires !";
        } else if (Poker.is2s(mainPoker)) {
            resultat += "Vous avez une Paire!";
        } else {
            resultat += "";
        }

        txtOutput.setText(resultat);
    }
}
