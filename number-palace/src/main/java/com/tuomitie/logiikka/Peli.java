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
        System.out.print(
                "Number Palace!\n"
                + " käytettävissä olevat komennot:\n"
                + " 1 alusta peli\n"
                + " 2 tulosta peli\n"
                + " 3 syötä numero\n"
                + " 4 tulosta ratkaisu\n"
                + " x lopeta\n"
                + "\n");
        while (true) {
            System.out.print("komento: ");
            String valinta = lukija.nextLine();
            if (valinta.equals("x")) {
                break;
            }
            suorita(valinta);
        }
    }

    public void suorita(String valinta) {
        if (valinta.equals("1")) {
            alusta();
        } else if (valinta.equals("2")) {
            tulostaPelikentta();
        } else if (valinta.equals("3")) {
            int[] vastaus = pyydaSyote();
            sudoku.asetaNumero(vastaus[0], vastaus[1], vastaus[2]);
            System.out.print("\n");
        } else if (valinta.equals("4")) {
            tulostaRatkaisu();
        } else {
            System.out.print("komento: ");
        }
    }

    public void alusta() {
        sudoku.alusta();
    }

    public void tulostaPelikentta() {
        int[][] peliKentta = sudoku.haePelaajanNakyma();
        sudoku.tulosta(peliKentta);
    }

    public void tulostaRatkaisu() {
        int[][] pohja = sudoku.haePohja();
        sudoku.tulosta(pohja);
    }

    public int[] pyydaSyote() {
        tulostaPelikentta();
        int[] syote = {-1, -1, -1};
        System.out.print("rivi: ");
        syote[0] = pyydaNumero();
        System.out.print("sarake: ");
        syote[1] = pyydaNumero();
        System.out.print("numero: ");
        syote[2] = pyydaNumero();
        return syote;
    }

    public int pyydaNumero() {
        int luku = -1;
        String s = lukija.nextLine();
        try {
            luku = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            //error
        }
        return luku;
    }

}
