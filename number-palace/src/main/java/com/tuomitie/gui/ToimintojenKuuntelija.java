package com.tuomitie.gui;

import com.tuomitie.logiikka.Peli;
import com.tuomitie.logiikka.Sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToimintojenKuuntelija implements ActionListener {

    private String toiminto;
    private Kayttoliittyma kayttoliittyma;
    private Sudoku sudoku;
    private Peli peli;

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
     * @param toiminto The action in question.
     * @param peli The Game instance.
     */
    public ToimintojenKuuntelija(String toiminto, Peli peli) {
        this.toiminto = toiminto;
        this.peli = peli;
    }

    /**
     * Handles the button specific actions that should happen when clicked.
     */
    public void suorita() {
        if (toiminto.equals("vastaus")) {
            kayttoliittyma.naytaRatkaisu();
            kayttoliittyma.disabloi("tarkista");
            kayttoliittyma.disabloi("katso vastaus");
        } else if (toiminto.equals("tarkista")) {
            if (sudoku.tarkistaRatkaisu()) {
                kayttoliittyma.luoPopUp("Oikein!!!");
            } else {
                kayttoliittyma.luoPopUp("Väärin meni.");
            }
        } else if (toiminto.equals("aloita")) {
            // TODO Implement start screen functionality
            System.out.println("Aloita painettu.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        suorita();
    }
}
