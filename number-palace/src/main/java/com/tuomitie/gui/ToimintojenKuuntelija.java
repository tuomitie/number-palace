package com.tuomitie.gui;

import com.tuomitie.logiikka.Sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToimintojenKuuntelija implements ActionListener {

    private String toiminto;
    private Kayttoliittyma kali;
    private Sudoku sudoku;

    /**
     * ActionListener for the user control buttons of the GUI.
     * @param toiminto The action in question.
     * @param kali The GUI instance.
     * @param sudoku The Sudoku game the action affects.
     */
    public ToimintojenKuuntelija(String toiminto, Kayttoliittyma kali, Sudoku sudoku) {
        this.toiminto = toiminto;
        this.kali = kali;
        this.sudoku = sudoku;
    }

    /**
     * Handles the button specific actions that should happen when clicked.
     */
    public void suorita() {
        if (toiminto.equals("vastaus")) {
            kali.naytaRatkaisu();
            kali.disabloi("tarkista");
            kali.disabloi("katso vastaus");
        } else if (toiminto.equals("tarkista")) {
            if (sudoku.tarkistaRatkaisu()) {
                kali.luoPopUp("Oikein!!!");
            } else {
                kali.luoPopUp("Väärin meni.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        suorita();
    }
}
