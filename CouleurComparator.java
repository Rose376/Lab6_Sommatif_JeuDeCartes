package Comparators;

import Classes.Carte;
import java.util.Comparator;

public class CouleurComparator implements Comparator<Carte> {

    @Override
    public int compare(Carte carte1, Carte carte2) {
        return carte1.getCouleur().compareTo(carte2.getCouleur());
    }
}
