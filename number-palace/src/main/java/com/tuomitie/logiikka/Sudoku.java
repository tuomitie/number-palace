package com.tuomitie.logiikka;

import java.util.concurrent.ThreadLocalRandom;

public class Sudoku {

    private Kentta kentta;              // The Kentta (Field) object contains the difficulty level, solution and start view of the game
    private int[][] tilanne;            // Tilanne contains the state of the game as it stands
    private int[][] ratkaisu;

    public Sudoku() {
        tilanne = new int[9][9];
        alusta();
        ratkaisu = luoRuudukko(kentta.taulukkoNumeroina(kentta.haeVastaus()));
    }

    public void alusta() {
        Kenttamestari kenttamestari = new Kenttamestari();      // Set up the game by creating a new grid manager
        kenttamestari.haeTiedosto();
        kenttamestari.haeKaikkiKentatListalle();
        kentta = kenttamestari.annaKentta();                    // Get one grid from the manager and use it for the rest of the game
        tilanne = luoRuudukko(kentta.taulukkoNumeroina(kentta.haeNakyma()));    // Use the player view of the grid in int[] form with the method below
    }

    public int[][] luoRuudukko(int[] numerot) {     // To convert values into a 9x9 grid
        int[][] ruudukko = new int[9][9];
        int indeksi = 0;
        for (int a = 0; a < 9; a++) {               // Rows
            for (int b = 0; b < 9; b++) {           // Cells
                ruudukko[a][b] = numerot[indeksi];
                indeksi++;
            }
        }
        return ruudukko;
    }

    public void tulosta(int[][] taulukko) {         // To print out a 9x9 grid
        System.out.print("\n");
        for (int a = 0; a < 9; a++) {               // Rows
            for (int b = 0; b < 9; b++) {           // Cells
                System.out.print(taulukko[a][b] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void asetaNumero(String syote) {         // Update the state of the player board
        if (syote.matches("[1-9]{3}")) {            // Regex to check if input was three numbers
            int[] luvut = kasitteleSyote(syote);
            int rivi = luvut[0];                    // Convert back to variables for legibility
            int solu = luvut[1];
            int arvo = luvut[2];                    // Row and cell should be 0-8, and value 1-9
            if ((rivi < 9) & (rivi >= 0) & (solu < 9) & (solu >= 0) & (arvo <= 9) & (arvo > 0)) {
                if (tilanne[rivi][solu] == 0) {
                    tilanne[rivi][solu] = luvut[2];
                }
            }
        }
    }

    public int[] kasitteleSyote(String syote) {     // Turn the input string into integers
        String[] osat = syote.split("");
        int rivi = Integer.valueOf(osat[0]) - 1;    // Correct the user coordinates down by one
        int solu = Integer.valueOf(osat[1]) - 1;
        int arvo = Integer.valueOf(osat[2]);
        int[] luvut = {rivi, solu, arvo};
        return luvut;
    }

    public boolean tarkistaRatkaisu() {             // Check if user grid matches the solution
        boolean oikein = true;
        for (int a = 0; a < 9; a++) {               // Rows
            for (int b = 0; b < 9; b++) {           // Cells
                if (tilanne[a][b] != ratkaisu[a][b]) {
                    oikein = false;                 
                    break;
                }
            }
        }
        return oikein;
    }

//    public int haePelikentanSolu(int a, int b) {
//        if ((a < 9) & (a >= 0) & (b < 9) & (b >= 0)) {
//            return ratkaisu[a][b];
//        } else {
//            return -1;
//        }
//    }
    public int[][] haeTilanne() {
        return tilanne;
    }

    public int[][] haeRatkaisu() {
        return ratkaisu;
    }
}
