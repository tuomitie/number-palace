package com.tuomitie.logiikka;

public class Kentta implements Comparable<Kentta> {

    private int vaikeustaso;
    private String nakyma;
    private String vastaus;

    public Kentta(int vaikeustaso, String nakyma, String vastaus) {
        this.vaikeustaso = vaikeustaso;
        this.nakyma = nakyma;
        this.vastaus = vastaus;
    }

    public int[] taulukkoNumeroina(String data) {       // Used to convert the Strings read from file to ints
        if (data.contains(".")) {                       // In the case of a player view get rid of the dots
            data = data.replaceAll("\\.", "0");         // and replace them with zeros
        }
        String[] merkit = data.split("");               // Split the String into pieces
        int[] numerot = new int[81];
        for (int i = 0; i < merkit.length; i++) {
            numerot[i] = Integer.valueOf(merkit[i]);    // Convert from String to int
        }
        return numerot;
    }

    public int haeVaikeustaso() {
        return vaikeustaso;
    }

    public String haeVastaus() {
        return vastaus;
    }

    public String haeNakyma() {
        return nakyma;
    }
    
    @Override
    public int compareTo(Kentta verrattava) {           // For comparing games by based on difficulty
        return this.vaikeustaso - verrattava.haeVaikeustaso();
    }
}
