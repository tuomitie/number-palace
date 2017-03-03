package com.tuomitie.gui;

import com.tuomitie.logiikka.Peli;
import com.tuomitie.logiikka.Sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
    }

    /**
     * Alternative constuctor to use with main menu controls.
     *
     * @param toiminto The action in question.
     * @param peli The Game instance.
     */
    public ToimintojenKuuntelija(String toiminto, Valikko valikko, Peli peli) {
        this.toiminto = toiminto;
        this.valikko = valikko;
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
                kayttoliittyma.luoPopUp("You got it, champ!");
            } else {
                kayttoliittyma.luoPopUp("That's not correct. Keep trying!");
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
