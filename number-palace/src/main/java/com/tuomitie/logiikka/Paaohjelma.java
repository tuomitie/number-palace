package com.tuomitie.logiikka;

import com.tuomitie.gui.Kayttoliittyma;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Paaohjelma {

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli(lukija);
        peli.kaynnista();
    }
}
