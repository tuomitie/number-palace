package com.tuomitie.logiikka;

public class Kentta implements Comparable<Kentta> {

    private int vaikeustaso;
    private String nakyma;
    private String vastaus;

    public Kentta(int vaikeus, String nakyma, String vastaus) {
        this.vastaus = vastaus;
        this.nakyma = nakyma;
        this.vaikeustaso = vaikeus;
    }

    public int getVaikeustaso() {
        return vaikeustaso;
    }

    public String getVastaus() {
        return vastaus;
    }

    public String getNakyma() {
        return nakyma;
    }

    public void setNakyma(String nakyma) {
        this.nakyma = nakyma;
    }

    @Override
    public int compareTo(Kentta verrattava) {
        return this.vaikeustaso - verrattava.getVaikeustaso();
    }
}
