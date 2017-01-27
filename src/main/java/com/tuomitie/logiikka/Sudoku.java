package com.tuomitie.logiikka;

import java.util.concurrent.ThreadLocalRandom;

public class Sudoku {

    private int[][] rivit;
    private int[][] peliKentta;

    public Sudoku() {
        rivit = new int[9][9];       // The 9x9 Sudoku grid is stored in an array of arrays of ints
        peliKentta = new int[9][9];  // The same grid but with hidden information, shown to the player
    }

    public void alusta() {
        int[] osat = luoPohja();
        /* Fill the 9x9 grid with the preset data from haePohja() method */
        int indeksi = 0;                        // Index used in going through the source int array
        for (int a = 0; a < 9; a++) {           // Rows of the array 
            for (int b = 0; b < 9; b++) {       // Cells of a row
                rivit[a][b] = osat[indeksi];
                indeksi++;
            }
        }
        luoPelaajanNakyma();
    }

    public int[] luoPohja() {
        int random = ThreadLocalRandom.current().nextInt(1, 5);     // Random int in the range 1-4
        String rimpsu;                                              // Used to pick one of the four prepared Sudoku bases below
        if (random == 1) {
            rimpsu = "4 3 8 9 5 7 6 1 2 7 1 5 6 8 2 9 4 3 9 2 6 3 4 1 5 8 7 6 7 3 8 9 4 1 2 5 1 8 9 2 6 5 3 7 4 2 5 4 1 7 3 8 6 9 5 6 7 4 3 8 2 9 1 3 9 1 7 2 6 4 5 8 8 4 2 5 1 9 7 3 6";
        } else if (random == 2) {
            rimpsu = "6 4 5 7 1 3 8 2 9 9 2 3 8 6 4 1 5 7 7 8 1 9 2 5 3 4 6 4 1 6 2 3 7 5 9 8 2 5 7 6 9 8 4 1 3 8 3 9 5 4 1 7 6 2 1 7 2 4 8 9 6 3 5 3 6 8 1 5 2 9 7 4 5 9 4 3 7 6 2 8 1";
        } else if (random == 3) {
            rimpsu = "6 8 9 5 1 3 4 2 7 1 3 2 4 7 6 8 9 5 5 7 4 8 2 9 6 1 3 3 9 6 2 4 7 1 5 8 7 4 8 6 5 1 2 3 9 2 1 5 9 3 8 7 4 6 4 2 7 3 8 5 9 6 1 8 6 3 1 9 4 5 7 2 9 5 1 7 6 2 3 8 4";
        } else {
            rimpsu = "6 5 8 4 1 3 7 2 9 2 3 4 7 9 8 1 5 6 7 9 1 6 5 2 8 4 3 9 7 3 8 6 5 4 1 2 1 4 6 2 7 9 3 8 5 8 2 5 3 4 1 6 9 7 3 1 7 9 2 4 5 6 8 5 8 2 1 3 6 9 7 4 4 6 9 5 8 7 2 3 1";
        }
        String[] merkit = rimpsu.split(" ");            // Split the String into pieces
        int[] numerot = new int[81];
        for (int i = 0; i < merkit.length; i++) {
            numerot[i] = Integer.valueOf(merkit[i]);    // Convert from String to int
        }
        return numerot;
    }

    public int[][] haePohja() {
        return this.rivit;
    }

    public int[][] haePelaajanNakyma() {
        return this.peliKentta;
    }

    public void tulosta(int[][] taulukko) {
        System.out.print("\n");
        for (int a = 0; a < 9; a++) {       // Table rows
            for (int b = 0; b < 9; b++) {   // Table cells
                System.out.print(taulukko[a][b] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void luoPelaajanNakyma() {
        /* Creates the player view with hidden cells */
        String peitto = ". 5 . . . 3 . . . . . 4 . . 8 . . 6 . . . . 5 2 . 4 . 9 7 3 . . . . . . . . 6 . . . 3 . . . . . . . . 6 9 7 . 1 . 9 2 . . . . 5 . . 1 . . 9 . . . . . 5 . . . 3 .";
        String[] osat = peitto.split(" ");
        int indeksi = 0;

        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (osat[indeksi].equals(".")) {    // If the cell in question contains a dot, hide it
                    peliKentta[a][b] = 0;
                } else {
                    peliKentta[a][b] = rivit[a][b]; // If the cell contains a number, display it
                }
                indeksi++;
            }
        }
    }

    public void asetaNumero(int a, int b, int x) {
        a--;
        b--;
        if ((a < 9) & (a >= 0) & (b < 9) & (b >= 0) & (x <= 9) & (x > 0)) {
            if (peliKentta[a][b] == 0) {
                peliKentta[a][b] = x;
            }
        }
    }

    public int haePelikentanSolu(int a, int b) {
        if ((a < 9) & (a >= 0) & (b < 9) & (b >= 0)) {
            return peliKentta[a][b];
        } else {
            return -1;
        }
    }

}
