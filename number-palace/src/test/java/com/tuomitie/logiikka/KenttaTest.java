package com.tuomitie.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KenttaTest {

    private int vaikeustaso;
    private String nakyma;
    private String ratkaisu;
    private Kentta kentta;

    public KenttaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kentta = new Kentta(343, "..5.6.97..6.4...5.7.89......816.....6......28.....74..2....61.581..9...2....4.68.", "425368971169472853738915264381624597647159328952837416294786135816593742573241689");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ratkaisuNumerotaulukkonaToimii() {
        int[] luvut = kentta.taulukkoNumeroina("425368971169472853738915264381624597647159328952837416294786135816593742573241689");
        assertEquals(luvut.length, 81);
    }

    @Test
    public void nakymaNumerotaulukkonaOikeaMitta() {
        int[] luvut = kentta.taulukkoNumeroina("..5.6.97..6.4...5.7.89......816.....6......28.....74..2....61.581..9...2....4.68.");
        assertEquals(luvut.length, 81);
    }

    @Test
    public void nakymaNumerotaulukkonaSisaltaaNollia() {
        int[] luvut = kentta.taulukkoNumeroina("..5.6.97..6.4...5.7.89......816.....6......28.....74..2....61.581..9...2....4.68.");
        assertEquals(luvut[0], 0);
        assertEquals(luvut[80], 0);
    }
}
