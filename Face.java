package Enums;

public enum Face {

    AS(1),
    DEUX(2),
    TROIS(3),
    QUATRE(4),
    CINQ(5),
    SIX(6),
    SEPT(7),
    HUIT(8),
    NEUF(9),
    DIX(10),
    VALET(11),
    DAME(12),
    ROI(13);

    //Attribut private valeur
    private final int valeur;

    Face(int valeur) {
        this.valeur = valeur;
    }

    //Getter
    public int getValeur() {
        return valeur;
    }
}
