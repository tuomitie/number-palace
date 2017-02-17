package com.tuomitie.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tuomas on 2/16/17.
 */
public class ToimintojenKuuntelija implements ActionListener {

    private String toiminto;
    private Kayttoliittyma kali;

    public ToimintojenKuuntelija(String toiminto, Kayttoliittyma kali) {
        this.toiminto = toiminto;
        this.kali = kali;
    }

    public void suorita() {
        if (toiminto.equals("vastaus")) {
            kali.naytaRatkaisu();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        suorita();
    }
}
