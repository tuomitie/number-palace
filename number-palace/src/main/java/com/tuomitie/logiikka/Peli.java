package com.tuomitie.logiikka;

import java.util.Scanner;

/**
 * Provides generic game controls like playing one turn, asking for input and
 * such. These controls are board agnostic, i.e. it doesn't matter if one is
 * playing sudoku or some other variant of the game.
 *
 * @author Tuomas
 */
public class Peli {

    private Scanner lukija;
    private Sudoku sudoku;

    /**
     * Initializes the game.
     *
     * @param lukija The Scanner object passed by the main method.
     */
    public Peli(Scanner lukija) {
        this.lukija = lukija;
        this.sudoku = new Sudoku();
    }

    /**
     * Command line interface to the logic. To be removed with full GUI
     * implementation. Calls the initializing method of the game to be started.
     *
     * @see com.tuomitie.logiikka.Sudoku#alusta()
     */
    public void kaynnista() {
        sudoku.alusta();

        sudoku.tulosta(sudoku.getRatkaisu());
        
//        while (true) {
//            System.out.print(
//                    "\nNumber Palace!\n"
//                    + " a uusi peli\n"
//                    + " x lopeta\n"
//                    + "\n");
//            String valinta = lukija.nextLine();
//            if (valinta.equals("x")) {
//                break;
//            }
//            suorita(valinta);   // Separated into another method to support future functionalities
//        }
    }

    /**
     * A remnant of the command line interface. To be removed with full GUI
     * implementation.
     *
     * @param valinta
     */
//    public void suorita(String valinta) {
//        if (valinta.equals("a")) {
//            pelaaKierros();
//        } else {
//            System.out.print("> ");
//        }
//    }

    /**
     * Command line controls input checks. Might become obsolete with GUI or be
     * rewritten.
     */
//    public void pelaaKierros() {
//        String syote = "";
//        while (true) {
//            tulostaTilanne();
//            syote = pyydaSyote();
//            if (syote.equals("x")) {
//                break;
//            } else {
//                sudoku.asetaNumero(syote);
//                if (sudoku.haeSiirtojenMaara() > 40) {   // Only start checking for completion after 40 turns
//                    if (sudoku.tarkistaRatkaisu()) {
//                        System.out.println("Jee, voitit!");
//                    }
//                }
//            }
//        }
//    }

    /**
     * Method to print out the player board.
     */
//    public void tulostaTilanne() {
//        sudoku.tulosta(sudoku.getTilanne());
//    }

    /**
     * Asks for keyboard input for coordinates. Obsolete with full GUI.
     *
     * @return
     */
//    public String pyydaSyote() {
//        System.out.print("Anna koordinaatit ja numero (muodossa 123) - x lopettaa\n"
//                + "> ");
//        String syote = lukija.nextLine();
//        return syote;
//    }
}
