package Classes;

import Comparators.CouleurComparator;
import Comparators.FaceComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {

    //Flush = cinq carte de la même couleur
    public static boolean isFlush(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec le CouleurComparator
        Collections.sort(copieCartes, new CouleurComparator());

        //Vérifications
        return copieCartes.get(0).getCouleur() == copieCartes.get(4).getCouleur();
    }

    //Suite (Straight) = cinq carte avec des faces en ordre 
    public static boolean isStraight(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec le FaceComparator
        Collections.sort(copieCartes, new FaceComparator());

        //Vérifications
        int valeurUne = copieCartes.get(0).getFace().getValeur();

        for (int i = 0; i < copieCartes.size(); i++) {
            if (copieCartes.get(i).getFace().getValeur() != ++valeurUne) {
                return false;
            }
        }
        return true;
    }

    //Quadruple = 4 cartes de la même face
    //xxxxy ou yxxxx
    public static boolean is4s(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec le FaceComparator
        Collections.sort(copieCartes, new FaceComparator());

        //Vérification xxxxy
        if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification yxxxx
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
        }
        return false;
    }

    //Full house = une paire + un triple de face
    //xxxyy ou xxyyy
    public static boolean isFullHouse(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec le FaceComparator
        Collections.sort(copieCartes, new FaceComparator());

        //Vérification xxxyy
        if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() != copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification xxyyy
        } else if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
        }
        return false;
    }

    //Triple = 3 même face + 2 autres cartes différentes
    //xxxab, axxxb, abxxx
    public static boolean is3s(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec FaceCompartor
        Collections.sort(copieCartes, new FaceComparator());

        //Vérification xxxab
        if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification axxxb
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification abxxx
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
        }
        return false;
    }

    //2 paires 
    // aabbx, aaxbb, xaabb
    public static boolean is22s(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec FaceCompartor
        Collections.sort(copieCartes, new FaceComparator());

        //Vérification aabbx
        if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification aaxbb
        } else if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() != copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification xaabb
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() != copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
        }
        return false;
    }

    //1 paire
    // aaxyz, xaayz, xyaaz, xyzaa
    public static boolean is2s(List<Carte> cinqCartes) {

        //Créer une copie de la liste
        ArrayList<Carte> copieCartes = new ArrayList(cinqCartes);

        //Trier les cartes avec FaceCompartor
        Collections.sort(copieCartes, new FaceComparator());

        //Vérification aaxyz
        if (copieCartes.get(0).getFace().getValeur() == copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() != copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification xyaaz
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() == copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification xaayz
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() == copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() != copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() != copieCartes.get(4).getFace().getValeur()) {
            return true;
            //Vérification xyzaa
        } else if (copieCartes.get(0).getFace().getValeur() != copieCartes.get(1).getFace().getValeur()
                && copieCartes.get(1).getFace().getValeur() != copieCartes.get(2).getFace().getValeur()
                && copieCartes.get(2).getFace().getValeur() != copieCartes.get(3).getFace().getValeur()
                && copieCartes.get(3).getFace().getValeur() == copieCartes.get(4).getFace().getValeur()) {
            return true;
        }
        return false;
    }
}
