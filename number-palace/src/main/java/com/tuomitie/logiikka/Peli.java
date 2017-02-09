package com.tuomitie.logiikka;

import java.util.Scanner;

public class Peli {

    private Scanner lukija;
    private Sudoku sudoku;

    public Peli(Scanner lukija) {
        this.lukija = lukija;
        this.sudoku = new Sudoku();

    }

    public void kaynnista() {
        sudoku.alusta();

        while (true) {
            System.out.print(
                    "\nNumber Palace!\n"
                    + " a uusi peli\n"
                    + " x lopeta\n"
                    + "\n");
            String valinta = lukija.nextLine();
            if (valinta.equals("x")) {
                break;
            }
            suorita(valinta);   // Separated into another method to support future functionalities
        }
    }

    public void suorita(String valinta) {
        if (valinta.equals("a")) {
            pelaaKierros();
        } else {
            System.out.print("> ");
        }
    }

    public void pelaaKierros() {
        String syote = "";
        while (true) {
            tulostaTilanne();
            syote = pyydaSyote();
            if (syote.equals("x")) {
                break;
            } else if (syote.equals("z")) {
                peruSiirto();
            } else {
                sudoku.asetaNumero(syote);
                if (sudoku.haeSiirtojenMaara() > 40) {   // Only start checking for completion after 40 turns
                    if (sudoku.tarkistaRatkaisu()) {
                        System.out.println("Jee, voitit!");
                    }
                }
            }
        }
    }

    public void tulostaTilanne() {
        sudoku.tulosta(sudoku.haeTilanne());
    }

    public String pyydaSyote() {
        System.out.print("Anna koordinaatit ja numero (muodossa 123) - z peruu siirron - x lopettaa\n"
                + "> ");
        String syote = lukija.nextLine();
        return syote;
    }

    public void peruSiirto() {
        sudoku.peruViimeisinSiirto();
    }
}
