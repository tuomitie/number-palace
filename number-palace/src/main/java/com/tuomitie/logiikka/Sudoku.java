package com.tuomitie.logiikka;

import com.tuomitie.gui.Kayttoliittyma;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 * The class establishes rules for the common Sudoku 9x9 game. Contains a Kentta
 * object read from a file by the Kenttamestari class, tilanne and ratkaisu
 * views based on the Kentta-input, and a list of moves the player has made.
 * Also holds the GUI.
 *
 * @author Tuomas
 */
public class Sudoku {

    private Kentta kentta;              // The Kentta (Field) object contains the difficulty level, solution and start view of the game
    private int[][] tilanne;            // Tilanne contains the state of the game as it stands
    private final int[][] ratkaisu;
    private List<int[]> siirrot;

    private Kayttoliittyma kayttoliittyma;

    /**
     * Create the data structures and call the initializing method
     *
     * @see com.tuomitie.logiikka.Sudoku#alusta()
     */
    public Sudoku() {
        siirrot = new ArrayList<>();
        alusta();
        tilanne = luoRuudukko(kentta.taulukkoNumeroina(kentta.haeNakyma()));
        ratkaisu = luoRuudukko(kentta.taulukkoNumeroina(kentta.haeVastaus()));
        kayttoliittyma = new Kayttoliittyma(this);
    }

    /**
     * Calls the Kenttamestari class, which handles the different game layouts,
     * creates the player view and solution based on the data, and invokes GUI.
     */
    public void alusta() {
        Kenttamestari kenttamestari = new Kenttamestari();      // Set up the game by creating a new grid manager
        kenttamestari.haeTiedosto();
        kenttamestari.haeKaikkiKentatListalle();
        kentta = kenttamestari.annaKentta();                    // Get one grid from the manager and use it for the rest of the game        
        SwingUtilities.invokeLater(kayttoliittyma);
    }

    /**
     * To convert an one-dimensional array of values into a 9x9 grid.
     *
     * @param numerot The input array.
     * @return The 9x9 integer array.
     */
    public int[][] luoRuudukko(int[] numerot) {
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

    /**
     * Method prints out a 9x9 grid on the console.
     *
     * @param taulukko The array to be printed.
     */
    public void tulosta(int[][] taulukko) {
        System.out.print("\n");
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                System.out.print(taulukko[a][b] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**
     * Update the state of the player board.
     *
     * @param syote User entered input read from the keyboard.
     */
    public void asetaNumero(String syote) {
        if (syote.matches("[0-9]{3}")) {      // Regex to check if input was three numbers
            int[] luvut = kasitteleSyote(syote);
            int rivi = luvut[0];                    // Convert back to variables for legibility
            int solu = luvut[1];
            int arvo = luvut[2];                    // Row and cell should be 0-8, and value 1-9
            if ((rivi < 9) && (rivi >= 0) && (solu < 9) && (solu >= 0) && (arvo <= 9) && (arvo >= 0)) {
                tilanne[rivi][solu] = luvut[2];
            }
        }
    }

    /**
     * Turn the input string into integers.
     *
     * @param syote The input read from the user.
     * @return An array of two coordinates and a number value.
     */
    public int[] kasitteleSyote(String syote) {
        String[] osat = syote.split("");
        int rivi = Integer.valueOf(osat[0]) - 1;    // Correct the user coordinates down by one
        int solu = Integer.valueOf(osat[1]) - 1;
        int arvo = Integer.valueOf(osat[2]);
        int[] luvut = {rivi, solu, arvo};
        return luvut;
    }

    /**
     * Check if user grid matches the given solution.
     *
     * @return
     */
    public boolean tarkistaRatkaisu() {
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

    public int haePelikentanSolu(int a, int b) {
        if ((a < 9) & (a >= 0) & (b < 9) & (b >= 0)) {
            return tilanne[a][b];
        } else {
            return -1;
        }
    }

    public int haeSiirtojenMaara() {
        return siirrot.size();
    }

    public int[][] haeTilanne() {
        return tilanne;
    }

    public int[][] haeRatkaisu() {
        return ratkaisu;
    }

    public Kentta haeKentta() {
        return kentta;
    }
}
