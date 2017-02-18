package com.tuomitie.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tuomas
 */
public class SudokuTest {

    Sudoku sudoku;
    private int[][] ratkaisu;
    private int[][] tilanne;
    private Kentta kentta;

    /**
     *
     */
    public SudokuTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        sudoku = new Sudoku();
        sudoku.alusta();
        this.ratkaisu = sudoku.haeRatkaisu();
        this.tilanne = sudoku.haeTilanne();
        this.kentta = sudoku.haeKentta();
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void alustuksenJalkeenTaulukkoOnOlemassa() {
        assertEquals(ratkaisu.length, 9);
    }

    /**
     *
     */
    @Test
    public void alustuksenJalkeenPelaajanNakymaOnOlemassa() {
        assertEquals(tilanne.length, 9);
    }

    /**
     *
     */
    @Test
    public void alustuksenJalkeenKenttaOnOlemassa() {
        assertNotNull(kentta.haeNakyma());
    }

    /**
     *
     */
    @Test
    public void luoRuudukkoPalauttaaOikeanmuotoisenTaulukon() {
        int[][] ruudukko = new int[9][9];
        ruudukko = sudoku.luoRuudukko(kentta.taulukkoNumeroina(kentta.haeNakyma()));
        assertEquals(ruudukko.length, 9);
        assertEquals(ruudukko[5].length, 9);
    }

    /**
     *
     */
    @Test
    public void luotuNakymaSisaltaaNollia() {
        int[][] ruudukko = new int[9][9];
        ruudukko = sudoku.luoRuudukko(kentta.taulukkoNumeroina(kentta.haeNakyma()));
        boolean tosi = false;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (ruudukko[a][b] == 0) {
                    tosi = true;
                }
            }
        }
        assertTrue(tosi);
    }

    /**
     *
     */
    @Test
    public void luotuPohjaEiSisallaNollia() {
        int[][] ruudukko = new int[9][9];
        ruudukko = sudoku.luoRuudukko(kentta.taulukkoNumeroina(kentta.haeVastaus()));
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                assertFalse(ratkaisu[a][b] == 0);
            }
        }
    }
//    @Test
//    public void alustuksenJalkeenTaulukotOvatSamat() {
//        for (int a = 0; a < 9; a++) {
//            for (int b = 0; b < 9; b++) {
//                if (tilanne[a][b] != 0) {
//                    assertEquals(ratkaisu[a][b], tilanne[a][b]);
//                }
//            }
//        }
//    }

    /**
     *
     */
    @Test
    public void alustuksenJalkeenTaulukotOvatSamanmittaiset() {
        assertEquals(ratkaisu.length, tilanne.length);
    }

    /**
     *
     */
    @Test
    public void rivienSummatOikein() {
        for (int a = 0; a < 9; a++) {
            int rivisumma = 0;
            for (int b = 0; b < 9; b++) {
                rivisumma += ratkaisu[a][b];
            }
            assertEquals(rivisumma, 45);
        }
    }

    /**
     *
     */
    @Test
    public void sarakkeidenSummatOikein() {
        for (int a = 0; a < 9; a++) {
            int sarakesumma = 0;
            for (int b = 0; b < 9; b++) {
                sarakesumma += ratkaisu[b][a];
            }
            assertEquals(sarakesumma, 45);
        }
    }

    /**
     *
     */
    @Test
    public void ensimmaisenSektorinSummaOikein() {
        int sarake = ratkaisu[0][0] + ratkaisu[0][1] + ratkaisu[0][2] + ratkaisu[1][0] + ratkaisu[1][1] + ratkaisu[1][2] + ratkaisu[2][0] + ratkaisu[2][1] + ratkaisu[2][2];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void toisenSektorinSummaOikein() {
        int sarake = ratkaisu[0][3] + ratkaisu[0][4] + ratkaisu[0][5] + ratkaisu[1][3] + ratkaisu[1][4] + ratkaisu[1][5] + ratkaisu[2][3] + ratkaisu[2][4] + ratkaisu[2][5];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void kolmannenSektorinSummaOikein() {
        int sarake = ratkaisu[0][6] + ratkaisu[0][7] + ratkaisu[0][8] + ratkaisu[1][6] + ratkaisu[1][7] + ratkaisu[1][8] + ratkaisu[2][6] + ratkaisu[2][7] + ratkaisu[2][8];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void neljannenSektorinSummaOikein() {
        int sarake = ratkaisu[3][0] + ratkaisu[3][1] + ratkaisu[3][2] + ratkaisu[4][0] + ratkaisu[4][1] + ratkaisu[4][2] + ratkaisu[5][0] + ratkaisu[5][1] + ratkaisu[5][2];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void viidennenSektorinSummaOikein() {
        int sarake = ratkaisu[3][3] + ratkaisu[3][4] + ratkaisu[3][5] + ratkaisu[4][3] + ratkaisu[4][4] + ratkaisu[4][5] + ratkaisu[5][3] + ratkaisu[5][4] + ratkaisu[5][5];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void kuudennenSektorinSummaOikein() {
        int sarake = ratkaisu[3][6] + ratkaisu[3][7] + ratkaisu[3][8] + ratkaisu[4][6] + ratkaisu[4][7] + ratkaisu[4][8] + ratkaisu[5][6] + ratkaisu[5][7] + ratkaisu[5][8];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void seitsemannenSektorinSummaOikein() {
        int sarake = ratkaisu[6][0] + ratkaisu[6][1] + ratkaisu[6][2] + ratkaisu[7][0] + ratkaisu[7][1] + ratkaisu[7][2] + ratkaisu[8][0] + ratkaisu[8][1] + ratkaisu[8][2];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void kahdeksannenSektorinSummaOikein() {
        int sarake = ratkaisu[6][3] + ratkaisu[6][4] + ratkaisu[6][5] + ratkaisu[7][3] + ratkaisu[7][4] + ratkaisu[7][5] + ratkaisu[8][3] + ratkaisu[8][4] + ratkaisu[8][5];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void yhdeksannenSektorinSummaOikein() {
        int sarake = ratkaisu[6][6] + ratkaisu[6][7] + ratkaisu[6][8] + ratkaisu[7][6] + ratkaisu[7][7] + ratkaisu[7][8] + ratkaisu[8][6] + ratkaisu[8][7] + ratkaisu[8][8];
        assertEquals(sarake, 45);
    }

    /**
     *
     */
    @Test
    public void validiSyoteLisataanNakymaan() {
        tilanne = sudoku.haeTilanne();
        for (int b = 0; b < 9; b++) {
            if (tilanne[0][b] == 0) {
                sudoku.asetaNumero("" + "1" + (b + 1) + "5");       // User coordinates are one larger than Java arrays'
                tilanne = sudoku.haeTilanne();
                assertEquals(tilanne[0][b], 5);
            }
        }
    }

    /**
     *
     */
    @Test
    public void huonoaSyotettaEiLisataanNakymaan() {
        tilanne = sudoku.haeTilanne();
        for (int b = 0; b < 9; b++) {
            if (tilanne[0][b] == 0) {
                sudoku.asetaNumero("" + "1" + (b + 1) + "K");       // Pass a non-numeric value to be entered to the grid
                String merkki = String.valueOf(sudoku.haePelikentanSolu(0, b));
                assertFalse(merkki.equals("K"));
            }
        }
    }

    /**
     *
     */
//    @Test
//    public void pohjanPaalleEiLisata() {
//        tilanne = sudoku.haeTilanne();
//        for (int b = 0; b < 9; b++) {
//            if (tilanne[0][b] != 0 & tilanne[0][b] != 5) {
//                sudoku.asetaNumero("" + "1" + (b + 1) + "5");       // Try to overwrite original numbers
//                assertFalse(tilanne[0][b] == 5);
//            }
//        }
//    }

    /**
     *
     */
    @Test
    public void syotteenKasittelyToimii() {
        int[] osat = sudoku.kasitteleSyote("112");
        assertEquals(osat[0], 0);
        assertEquals(osat[1], 0);
        assertEquals(osat[2], 2);
    }

    @Test
    public void ratkaisunTarkistaminenToimii() {
        for (int a = 0; a < 9; a++) {               // Rows
            for (int b = 0; b < 9; b++) {           // Cells
                if (tilanne[a][b] == 0) {
                    tilanne[a][b] = ratkaisu[a][b];
                }
            }
        }
        assertTrue(sudoku.tarkistaRatkaisu());
    }
}