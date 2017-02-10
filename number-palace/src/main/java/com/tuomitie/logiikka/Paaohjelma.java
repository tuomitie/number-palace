package com.tuomitie.logiikka;

import com.tuomitie.gui.Kayttoliittyma;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * Main method to start the game
 *
 * @author Tuomas
 */
public class Paaohjelma {

    /**
     * Main method initializes the game with a keyboard scanner (used for
     * development)
     *
     * @see com.tuomitie.logiikka.Peli#kaynnista()
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli(lukija);
        peli.kaynnista();
    }
}
