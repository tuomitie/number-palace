package com.tuomitie.logiikka;

import java.util.concurrent.ThreadLocalRandom;

public class Sudoku {

    private Kentta kentta;              // The Kentta (Field) object contains the difficulty level, solution and start view of the game
    private int[][] tilanne;            // Tilanne contains the state of the game as it stands

    public Sudoku() {
        tilanne = new int[9][9];
        alusta();
    }

    public void alusta() {
        Kenttamestari kenttamestari = new Kenttamestari();      // Set up the game by creating a new field manager
        kenttamestari.haeTiedosto();
        kenttamestari.haeKaikkiKentatListalle();
        kentta = kenttamestari.annaKentta();                    // Get one field from the manager
        tilanne = luoRuudukko(kentta.taulukkoNumeroina(kentta.haeNakyma()));
    }

    public int[][] luoRuudukko(int[] numerot) {
        int[][] ruudukko = new int[9][9];
        int[] osat = numerot;  // Get an array with one number each from the player view we got
        int indeksi = 0;
        for (int a = 0; a < 9; a++) {           // Rows
            for (int b = 0; b < 9; b++) {       // Cells
                ruudukko[a][b] = osat[indeksi];                      // Set the numbers up in the 9x9 array
                indeksi++;
            }
        }
        return ruudukko;
    }

    public void tulosta(int[][] taulukko) {
        System.out.print("\n");
        for (int a = 0; a < 9; a++) {       // Rows
            for (int b = 0; b < 9; b++) {   // Cells
                System.out.print(taulukko[a][b] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void asetaNumero(String syote) {
        if (syote.matches("[1-9]{3}")) {
            int[] luvut = kasitteleSyote(syote);
            int rivi = luvut[0];                    // Convert back to variables for legibility
            int solu = luvut[1];
            int arvo = luvut[2];
            if ((rivi < 9) & (rivi >= 0) & (solu < 9) & (solu >= 0) & (arvo <= 9) & (arvo > 0)) {
                if (tilanne[rivi][solu] == 0) {
                    tilanne[rivi][solu] = luvut[2];
                }
            }
        }
    }

    public int[] kasitteleSyote(String syote) {
        String[] osat = syote.split("");
        int rivi = Integer.valueOf(osat[0]) - 1;        // Correct the user coordinates down by one
        int solu = Integer.valueOf(osat[1]) - 1;
        int arvo = Integer.valueOf(osat[2]);
        int[] luvut = {rivi, solu, arvo};
        return luvut;
    }

    public int haePelikentanSolu(int a, int b) {
        if ((a < 9) & (a >= 0) & (b < 9) & (b >= 0)) {
            return tilanne[a][b];
        } else {
            return -1;
        }
    }
    
    public int[][] haeTilanne() {
        return tilanne;
    }
    
    public int[][] haeRatkaisu() {
        return luoRuudukko(kentta.taulukkoNumeroina(kentta.haeVastaus()));
    }
}
