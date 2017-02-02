package com.tuomitie.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuTest {

    private int[][] pohja;
    private int[][] pelaajanNakyma;

    public SudokuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Sudoku sudoku = new Sudoku();
        sudoku.alusta();
        this.pohja = sudoku.haeRatkaisu();
        this.pelaajanNakyma = sudoku.haeTilanne();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustuksenJalkeenTaulukkoOnOlemassa() {
        assertEquals(pohja.length, 9);
    }

    @Test
    public void alustuksenJalkeenPelaajanNakymaOnOlemassa() {
        assertEquals(pelaajanNakyma.length, 9);
    }

    @Test
    public void alustuksenJalkeenTaulukotOvatSamat() {
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (pelaajanNakyma[a][b] != 0) {
                    assertEquals(pohja[a][b], pelaajanNakyma[a][b]);
                }
            }
        }
    }

    @Test
    public void alustuksenJalkeenTaulukotOvatSamanmittaiset() {
        assertEquals(pohja.length, pelaajanNakyma.length);
    }

    @Test
    public void rivienSummatOikein() {
        for (int a = 0; a < 9; a++) {
            int rivisumma = 0;
            for (int b = 0; b < 9; b++) {
                rivisumma += pohja[a][b];
            }
            assertEquals(rivisumma, 45);
        }
    }

    @Test
    public void sarakkeidenSummatOikein() {
        for (int a = 0; a < 9; a++) {
            int sarakesumma = 0;
            for (int b = 0; b < 9; b++) {
                sarakesumma += pohja[b][a];
            }
            assertEquals(sarakesumma, 45);
        }
    }

    @Test
    public void ensimmaisenSektorinSummaOikein() {
        int sarake = pohja[0][0] + pohja[0][1] + pohja[0][2] + pohja[1][0] + pohja[1][1] + pohja[1][2] + pohja[2][0] + pohja[2][1] + pohja[2][2];
        assertEquals(sarake, 45);
    }

    @Test
    public void toisenSektorinSummaOikein() {
        int sarake = pohja[0][3] + pohja[0][4] + pohja[0][5] + pohja[1][3] + pohja[1][4] + pohja[1][5] + pohja[2][3] + pohja[2][4] + pohja[2][5];
        assertEquals(sarake, 45);
    }

    @Test
    public void kolmannenSektorinSummaOikein() {
        int sarake = pohja[0][6] + pohja[0][7] + pohja[0][8] + pohja[1][6] + pohja[1][7] + pohja[1][8] + pohja[2][6] + pohja[2][7] + pohja[2][8];
        assertEquals(sarake, 45);
    }

    @Test
    public void neljannenSektorinSummaOikein() {
        int sarake = pohja[3][0] + pohja[3][1] + pohja[3][2] + pohja[4][0] + pohja[4][1] + pohja[4][2] + pohja[5][0] + pohja[5][1] + pohja[5][2];
        assertEquals(sarake, 45);
    }

    @Test
    public void viidennenSektorinSummaOikein() {
        int sarake = pohja[3][3] + pohja[3][4] + pohja[3][5] + pohja[4][3] + pohja[4][4] + pohja[4][5] + pohja[5][3] + pohja[5][4] + pohja[5][5];
        assertEquals(sarake, 45);
    }

    @Test
    public void kuudennenSektorinSummaOikein() {
        int sarake = pohja[3][6] + pohja[3][7] + pohja[3][8] + pohja[4][6] + pohja[4][7] + pohja[4][8] + pohja[5][6] + pohja[5][7] + pohja[5][8];
        assertEquals(sarake, 45);
    }

    @Test
    public void seitsemannenSektorinSummaOikein() {
        int sarake = pohja[6][0] + pohja[6][1] + pohja[6][2] + pohja[7][0] + pohja[7][1] + pohja[7][2] + pohja[8][0] + pohja[8][1] + pohja[8][2];
        assertEquals(sarake, 45);
    }

    @Test
    public void kahdeksannenSektorinSummaOikein() {
        int sarake = pohja[6][3] + pohja[6][4] + pohja[6][5] + pohja[7][3] + pohja[7][4] + pohja[7][5] + pohja[8][3] + pohja[8][4] + pohja[8][5];
        assertEquals(sarake, 45);
    }

    @Test
    public void yhdeksannenSektorinSummaOikein() {
        int sarake = pohja[6][6] + pohja[6][7] + pohja[6][8] + pohja[7][6] + pohja[7][7] + pohja[7][8] + pohja[8][6] + pohja[8][7] + pohja[8][8];
        assertEquals(sarake, 45);
    }
}
