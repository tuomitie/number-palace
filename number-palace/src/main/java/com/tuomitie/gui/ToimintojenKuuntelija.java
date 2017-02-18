package com.tuomitie.gui;

import com.tuomitie.logiikka.Sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tuomas on 2/16/17.
 */
public class ToimintojenKuuntelija implements ActionListener {

    private String toiminto;
    private Kayttoliittyma kali;
    private Sudoku sudoku;

    public ToimintojenKuuntelija(String toiminto, Kayttoliittyma kali, Sudoku sudoku) {
        this.toiminto = toiminto;
        this.kali = kali;
        this.sudoku = sudoku;
    }

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
