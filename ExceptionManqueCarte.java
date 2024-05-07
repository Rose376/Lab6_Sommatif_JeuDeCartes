package Exceptions;

public class ExceptionManqueCarte extends Exception {

    public ExceptionManqueCarte() {
        super("Il n'y a plus de cartes dans le paquet.");
    }

    public ExceptionManqueCarte(String msg) {
        super(msg);
    }

}
