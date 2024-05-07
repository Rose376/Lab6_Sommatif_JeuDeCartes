package Comparators;

import Classes.Carte;
import java.util.Comparator;

public class FaceComparator implements Comparator<Carte> {

    @Override
    public int compare(Carte carte1, Carte carte2) {

        if (carte1.getFace().getValeur() < carte2.getFace().getValeur()) {
            return -1;
        } else if (carte1.getFace().getValeur() == carte2.getFace().getValeur()) {
            return 0;
        } else {
            return 1;
        }
    }
}
