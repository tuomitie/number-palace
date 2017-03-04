package com.tuomitie.gui;

import com.tuomitie.logiikka.Peli;
import com.tuomitie.logiikka.Sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * ActionListener for control buttons in the main menu and player board.
 *
 * @author Tuomas
 */
public class ToimintojenKuuntelija implements ActionListener {

    private String toiminto;
    private Kayttoliittyma kayttoliittyma;
    private Sudoku sudoku;
    private Peli peli;
    private Valikko valikko;

    /**
     * ActionListener for the user control buttons of the GUI.
     *
     * @param toiminto The action in question.
     * @param kali The GUI instance.
     * @param sudoku The Sudoku game the action affects.
     */
    public ToimintojenKuuntelija(String toiminto, Kayttoliittyma kali, Sudoku sudoku) {
        this.toiminto = toiminto;
        this.kayttoliittyma = kali;
        this.sudoku = sudoku;
        this.peli = sudoku.getPeli();
    }

    /**
     * Alternative constuctor to use with main menu controls.
     *
     * @param toiminto The action in question.
     * @param valikko The originating Valikko.
     * @param peli The Game instance.
     */
    public ToimintojenKuuntelija(String toiminto, Valikko valikko, Peli peli) {
        this.toiminto = toiminto;
        this.valikko = valikko;
        this.sudoku = peli.getSudoku();
        this.peli = peli;
    }

    /**
     * Handles the button specific actions that should happen when clicked.
     */
    public void suorita() {
        // Main menu 
        if (toiminto.equals("start") && peli != null) {
            String valinta = "" + valikko.getVaikeusLista().getSelectedItem();
            peli.kaynnista(valinta);
        }

        // Player board controls
        if (toiminto.equals("inspect")) {
            if (sudoku.tarkistaRatkaisu()) {
                peli.lisaaHighScore("" + peli.getSudoku().getKentta().getVaikeustaso() + " - YOU");
                kayttoliittyma.luoPopUp("You got it, champ!");
                peli.getValikko().paivitaScoret();
            } else {
                kayttoliittyma.luoPopUp("That's doesn't seem to be correct.\nKeep trying!");
            }
        }
        if (toiminto.equals("solution")) {
            kayttoliittyma.naytaRatkaisu();
            kayttoliittyma.disabloi("inspect");
            kayttoliittyma.disabloi("solution");
        }
        if (toiminto.equals("quit")) {
            kayttoliittyma.luoDialogi("Are you sure you want to end the game and return to main menu?");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        suorita();
    }
}
