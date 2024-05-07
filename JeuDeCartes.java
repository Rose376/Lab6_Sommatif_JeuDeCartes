package Classes;

import Enums.Couleur;
import Enums.Face;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Exceptions.*;

public class JeuDeCartes {

    private List<Carte> paquetCartes;
    private int indexProchaineCarte;

    //Constructeur remplit la liste avec les 52 cartes
    public JeuDeCartes() {

        paquetCartes = new ArrayList<Carte>(52);
        indexProchaineCarte = 0;

        //Boucle for pour parcourir les faces
        for (Face face : Face.values()) {
            //Boucle for imbriquée pour parcourir les couleurs
            for (Couleur couleur : Couleur.values()) {
                //Créer new Carte dans la méthode add()
                paquetCartes.add(new Carte(face, couleur));
            }
        }
    }

    //Méthode brasser()
    public void brasser() {
        indexProchaineCarte = 0;
        Collections.shuffle(paquetCartes);

    }

    //Méthode distrubuer()
    public Carte distribuer() throws ExceptionManqueCarte {

        if (indexProchaineCarte == 52) {
            throw (new ExceptionManqueCarte());

        }
        return paquetCartes.get(indexProchaineCarte++);

    }

}
