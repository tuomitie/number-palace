package com.tuomitie.logiikka;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Reads Kentta (field) classes from a file and serves a random one to be used
 * as a basis for the game to be played.
 *
 * @author Tuomas
 */
public class Kenttamestari {

    private Scanner lukija;
    private InputStream is;
    private File tiedosto;
    private List<Kentta> kenttaLista;

    /**
     * Initializes the class with a preset file used to store the fields and a list to store them in.
     */
    public Kenttamestari() {
        lukija = null;
//      tiedosto = new File("src/main/resources/pohjat.txt");
        is = getClass().getClassLoader().getResourceAsStream("pohjat.txt");
        kenttaLista = new ArrayList<>();
    }

    /**
     * Tries to read the file specified in the constructor.
     *
     * @return The scanner.
     */
    public Scanner haeTiedosto() {
        try {
            lukija = new Scanner(is);    // This will be closed in haeKaikkiKentatListalle() method
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
        }
        return lukija;
    }

    /**
     * Adds all the read lines on a list, each as an numeric difficulty level
     * and two strings in an array.
     */
    public void haeKaikkiKentatListalle() {
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(" ");                                // Read each line from /src/main/resources/pohjat.txt
            int vaikeustaso = Integer.valueOf(osat[0]);                     // and split into diff. level, player view and solution
            kenttaLista.add(new Kentta(vaikeustaso, osat[1], osat[2]));     // make a list of these new bases
        }
        lukija.close();                                                     // Close the scanner opened in haeTiedosto
    }

    /**
     * Returns a random Kentta from the list.
     * @return One Kentta item.
     */
    public Kentta annaKentta() {
        Collections.shuffle(kenttaLista);       // Randomize the items on the list
        return kenttaLista.get(0);              // and return one
    }
}
