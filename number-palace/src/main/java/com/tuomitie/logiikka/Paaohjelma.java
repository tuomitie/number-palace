package com.tuomitie.logiikka;

import com.tuomitie.gui.Valikko;
import javax.swing.SwingUtilities;

/**
 * Main method to start the game.
 *
 * @author Tuomas
 */
public class Paaohjelma {

    /**
     * Main method initializes the game with a keyboard scanner (used for
     * development).
     *
     * @see com.tuomitie.logiikka.Peli#kaynnista(String vaikeustaso)
     *
     * @param args You know what this is.
     */
    public static void main(String[] args) {
        Valikko valikko = new Valikko(new Peli());
        SwingUtilities.invokeLater(valikko);
    }
}
