package com.tuomitie.logiikka;

import java.util.Scanner;
import com.tuomitie.gui.Valikko;
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

    /**
     * Initializes the game.
     *
     * @param lukija The Scanner object passed by the main method.
     */
    public Peli() {
        this.sudoku = new Sudoku(this);
        this.valikko = new Valikko(this);
    }

    /**
     * Command line interface to the logic. To be removed with full GUI
     * implementation. Calls the initializing method of the game to be started.
     *
     * @see com.tuomitie.logiikka.Sudoku#alusta()
     */
    public void kaynnista(String vaikeustaso) {
        sudoku.alusta(vaikeustaso);
        SwingUtilities.invokeLater(sudoku.getKayttoliittyma());
    }

    public void uusiPeli() {
        sudoku = new Sudoku(this);
        sudoku.alusta("random");
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public Valikko getValikko() {
        return valikko;
    }
}
