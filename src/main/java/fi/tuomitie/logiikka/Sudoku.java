package fi.tuomitie.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sudoku {

    private String[][] rivit;
    private final List numerot;

    public Sudoku() {
        rivit = new String[9][9];
        numerot = new ArrayList<>();
    }

    public void alusta() {
        int random = ThreadLocalRandom.current().nextInt(1, 5);
        String rimpsu;
        if (random == 1) {
            rimpsu = "4 3 8 9 5 7 6 1 2 7 1 5 6 8 2 9 4 3 9 2 6 3 4 1 5 8 7 6 7 3 8 9 4 1 2 5 1 8 9 2 6 5 3 7 4 2 5 4 1 7 3 8 6 9 5 6 7 4 3 8 2 9 1 3 9 1 7 2 6 4 5 8 8 4 2 5 1 9 7 3 6";
        } else if (random == 2) {
            rimpsu = "6 4 5 7 1 3 8 2 9 9 2 3 8 6 4 1 5 7 7 8 1 9 2 5 3 4 6 4 1 6 2 3 7 5 9 8 2 5 7 6 9 8 4 1 3 8 3 9 5 4 1 7 6 2 1 7 2 4 8 9 6 3 5 3 6 8 1 5 2 9 7 4 5 9 4 3 7 6 2 8 1";
        } else if (random == 3) {
            rimpsu = "6 8 9 5 1 3 4 2 7 1 3 2 4 7 6 8 9 5 5 7 4 8 2 9 6 1 3 3 9 6 2 4 7 1 5 8 7 4 8 6 5 1 2 3 9 2 1 5 9 3 8 7 4 6 4 2 7 3 8 5 9 6 1 8 6 3 1 9 4 5 7 2 9 5 1 7 6 2 3 8 4";
        } else {
            rimpsu = "6 5 8 4 1 3 7 2 9 2 3 4 7 9 8 1 5 6 7 9 1 6 5 2 8 4 3 9 7 3 8 6 5 4 1 2 1 4 6 2 7 9 3 8 5 8 2 5 3 4 1 6 9 7 3 1 7 9 2 4 5 6 8 5 8 2 1 3 6 9 7 4 4 6 9 5 8 7 2 3 1";
        }
        String[] osat = rimpsu.split(" ");

        int indeksi = 0;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                rivit[a][b] = osat[indeksi];
                indeksi++;
            }
        }
    }

    public String[][] haeRivit() {
        return this.rivit;
    }

    public void tulostaRivit() {
        System.out.print("\n");
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                System.out.print(rivit[a][b] + "  ");
            }
            System.out.print("\n");
        }

        System.out.println("\nPelaajan näkymä\n");

        String peitto = ". 5 . . . 3 . . . . . 4 . . 8 . . 6 . . . . 5 2 . 4 . 9 7 3 . . . . . . . . 6 . . . 3 . . . . . . . . 6 9 7 . 1 . 9 2 . . . . 5 . . 1 . . 9 . . . . . 5 . . . 3 .";
        String[] osat = peitto.split(" ");
        int indeksi = 0;

        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (osat[indeksi].equals(".")) {
                    System.out.print("*  ");
                } else {
                    System.out.print(rivit[a][b] + "  ");
                }
                indeksi++;
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
