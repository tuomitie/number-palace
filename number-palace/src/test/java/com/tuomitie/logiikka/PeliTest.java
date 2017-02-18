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
        this.sudoku = new Sudoku();
    }

    @Before
    public void setUp() {
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli(lukija);
        peli.kaynnista();

    }

    @Test
    public void kaynnistaminenAlustaa() {
        assertNotNull(sudoku.getKentta());
        assertNotNull(sudoku.getRatkaisu());
    }
}