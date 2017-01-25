import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Peli peli = new Peli(lukija);
        peli.kaynnista();
    }
}
