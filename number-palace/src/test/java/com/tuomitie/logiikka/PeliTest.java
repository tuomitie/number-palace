package com.tuomitie.logiikka;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    private Sudoku sudoku;
    private Peli peli;

    public PeliTest() {
        this.sudoku = new Sudoku(peli);
        this.peli = new Peli();
    }

    @Before
    public void setUp() {
        sudoku.alusta("easy");
    }

    @Test
    public void kaynnistaminenAlustaa() {
        assertNotNull(sudoku.getKentta());
        assertNotNull(sudoku.getRatkaisu());
        assertNotNull(peli.getHighScore(0));
        assertNotNull(peli.getSudoku());
        assertNotNull(peli.getValikko());
    }

    @Test
    public void kaynnistaminenVaikeustasollaToimii() {
        peli.kaynnista("easy");
        assertTrue(sudoku.getKentta().getVaikeustaso() <= 125);
    }

    @Test
    public void uusiPeliToimii() {
        peli.kaynnista("easy");
        Sudoku vanha = peli.getSudoku();
        peli.uusiPeli();
        assertFalse(peli.getSudoku() == vanha);
    }

    @Test
    public void sudokullaValittuVaikeustaso() {
        assertTrue(sudoku.getKentta().getVaikeustaso() <= 125);
    }

    @Test
    public void highScoretLuotuOikein() {
        assertEquals(peli.getHighScore(0), "300 - TPT");
        assertEquals(peli.getHighScore(4), "100 - TPT");
    }

    @Test
    public void highScorenPisteetOikein() {
        assertEquals(peli.arvotaHighScore(peli.getHighScore(0)), 300);
    }

    @Test
    public void highScorenLisaysToimii() {
        assertTrue(peli.getHighScore(4).contentEquals("100 - TPT"));
        peli.lisaaHighScore("500 - TPT");
        assertFalse(peli.getHighScore(4).contentEquals("100 - TPT"));
    }

    @Test
    public void pientaScoreaEiLisata() {
        assertTrue(peli.getHighScore(4).contentEquals("100 - TPT"));
        peli.lisaaHighScore("80 - TPT");
        assertTrue(peli.getHighScore(4).contentEquals("100 - TPT"));
    }

    @Test
    public void isoinScoreLisataanEnsimmaiseksi() {
        assertTrue(peli.getHighScore(0).contentEquals("300 - TPT"));
        peli.lisaaHighScore("500 - TPT");
        assertTrue(peli.getHighScore(0).contentEquals("500 - TPT"));
    }

    @Test
    public void scoreLisataanOikeaanPaikkaan() {
        assertTrue(peli.getHighScore(2).contentEquals("200 - TPT"));
        peli.lisaaHighScore("210 - TPT");
        assertTrue(peli.getHighScore(2).contentEquals("210 - TPT"));
        assertTrue(peli.getHighScore(3).contentEquals("200 - TPT"));
    }

    @Test
    public void lisaysEiKasvataTaulukonKokoa() {
        peli.lisaaHighScore("500 - TPT");
        assertTrue(peli.getHighscoreLista().size() == 5);
    }
}
