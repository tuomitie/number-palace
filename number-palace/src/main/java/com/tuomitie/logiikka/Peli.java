package com.tuomitie.logiikka;

import com.tuomitie.gui.Valikko;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 * Provides generic game controls like playing one turn, asking for input and
 * such. These controls are board agnostic, i.e. it doesn't matter if one is
 * playing sudoku or some other variant of the game.
 *
 * @author Tuomas
 */
public class Peli {

    private Sudoku sudoku;
    private Valikko valikko;
    private List<String> highscoret;

    /**
     * Initializes the game. Creates a new sudoku, a new main manu and a list
     * for highscores.
     *
     */
    public Peli() {
        this.sudoku = new Sudoku(this);
        this.valikko = new Valikko(this);
        this.highscoret = new ArrayList<>();
        luoHighScoret();
    }

    /**
     * Initializes the game with a difficulty level. Invokes the main player
     * view.
     *
     * @param vaikeustaso The difficulty level passed by main menu
     * (easy/semi/hard/random)
     * @see com.tuomitie.logiikka.Sudoku#alusta(String vaikeustaso)
     */
    public void kaynnista(String vaikeustaso) {
        sudoku.alusta(vaikeustaso);
        System.out.println("Diff. " + sudoku.getKentta().getVaikeustaso());
        sudoku.tulosta(sudoku.getRatkaisu());                               // Console output for testing
        SwingUtilities.invokeLater(sudoku.getKayttoliittyma());
    }

    /**
     * Assigns a new sudoku to the game. Fixes a problem with playing several
     * games in a row. Overwritten with user selected difficulty level later.
     */
    public void uusiPeli() {
        sudoku = new Sudoku(this);
        sudoku.alusta("random");
    }

    /**
     * Creates a list of dummy high scores to beat. Top 5 list from 300 to 100.
     */
    public void luoHighScoret() {
        for (int i = 1; i <= 5; i++) {      // Five top scores
            String rivi = ("" + (350 - i * 50) + " - TPT");
            highscoret.add(rivi);
        }
    }

    /**
     * Adds a high score to the list if there's a lower score on it. Pushes the
     * rest down one spot and removes the last entry.
     *
     * @param rivi The string to be added. Format: "000 - XXX".
     */
    public void lisaaHighScore(String rivi) {
        int ehdokas = arvotaHighScore(rivi);

        for (int indeksi = 0; indeksi < highscoret.size(); indeksi++) {
            if (ehdokas > arvotaHighScore(highscoret.get(indeksi))) {
                highscoret.add(indeksi, rivi);
                highscoret.remove(highscoret.size() - 1);
                break;
            }
        }
    }

    /**
     * Looks at how good the scores are.
     *
     * @param rivi The passed string Format: "000 - XXX".
     * @return The numerical representation of the score.
     */
    public int arvotaHighScore(String rivi) {
        String[] osat = rivi.split(" - ");
        return Integer.valueOf(osat[0]);
    }

    /**
     * Returns a single row from the High Scores list. Used to loop through
     * while looking if a new score should be added.
     *
     * @param indeksi The index requested.
     * @return String found in the requested position. Format: "000 - XXX".
     */
    public String getHighScore(int indeksi) {
        return highscoret.get(indeksi);
    }

    public List<String> getHighscoreLista() {
        return highscoret;
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public Valikko getValikko() {
        return valikko;
    }

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }
}
