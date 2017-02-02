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
        System.out.print(
                "Number Palace!\n"
                + " a aloita peli\n"
                + " x lopeta\n"
                + "\n");
        while (true) {
            System.out.print("> ");
            String valinta = lukija.nextLine();
            if (valinta.equals("x")) {
                break;
            }
            suorita(valinta);
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
            } else{
                sudoku.asetaNumero(syote);
            }
        }
    }

    public void tulostaTilanne() {
        sudoku.tulosta(sudoku.haeTilanne());
    }

    public String pyydaSyote() {
        System.out.print("Anna koordinaatit ja numero (muodossa 123) - x lopettaa\n"
                + "> ");
        String syote = lukija.nextLine();
        return syote;
    }

}
