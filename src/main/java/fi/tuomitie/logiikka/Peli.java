package fi.tuomitie.logiikka;

import java.util.Scanner;

public class Peli {

    private Scanner lukija;
    private Sudoku sudoku;

    public Peli(Scanner lukija) {
        this.lukija = lukija;
        this.sudoku = new Sudoku();
    }

    public void kaynnista() {
        System.out.print(
                " Number Palace!\n"
                + " käytettävissä olevat komennot:\n"
                + " 1 alusta peli\n"
                + " 2 tulosta peli\n"
                + " x lopeta\n"
                + "\n");
        while (true) {
            System.out.print("komento: ");
            String valinta = lukija.nextLine();
            if (valinta.equals("x")) {
                break;
            }

            suorita(valinta);
        }
    }

    public void suorita(String valinta) {
        if (valinta.equals("1")) {
            alusta();
        } else if (valinta.equals("2")) {
            tulosta();
        } else {
            System.out.print("komento: ");
        }

    }

    public void alusta() {
        sudoku.alusta();
    }

    public void tulosta() {
        sudoku.tulostaRivit();
    }

}
