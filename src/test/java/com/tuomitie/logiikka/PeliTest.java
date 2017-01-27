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

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.sudoku = new Sudoku();
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void eiAnnaAsettaaLukujaTaulukonUlkopuolelle() {
//        sudoku.alusta();
//        for (int a = 0; a < 9; a++) {
//            for (int b = 0; b < 9; b++) {
//                if(sudoku.haePelikentanSolu(a, b) == 0);
//                sudoku.asetaNumero(a, b, 5);
//                assertEquals(5, sudoku.haePelikentanSolu(a, b));
//            }
//        }
//    }
}
