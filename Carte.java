package Classes;

import Enums.Couleur;
import Enums.Face;

public class Carte {

    private Face face;
    private Couleur couleur;

    public Carte(Face face, Couleur couleur) {
        this.face = face;
        this.couleur = couleur;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return face + " de " + couleur;
    }

}
