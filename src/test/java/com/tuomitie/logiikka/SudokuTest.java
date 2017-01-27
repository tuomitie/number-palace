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
        this.pohja = sudoku.haePohja();
        this.pelaajanNakyma = sudoku.haePelaajanNakyma();
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
}
