package fi.tuomitie.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sudoku {

    private int[][] rivit;
    private final List numerot;

    public Sudoku() {
        rivit = new int[9][9];
        numerot = new ArrayList<>();
    }

    public void alusta() {
        for (int i = 1; i < 10; i++) {
            numerot.add(i);
        }

        for (int a = 0; a < 9; a++) {
            Collections.shuffle(numerot);
            for (int b = 0; b < 9; b++) {
                rivit[a][b] = (Integer) numerot.get(b);
            }
        }
    }

    public int[][] haeRivit() {
        return this.rivit;
    }

    public void tulostaRivit() {
        System.out.println("\n");
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                System.out.print(rivit[a][b] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}
