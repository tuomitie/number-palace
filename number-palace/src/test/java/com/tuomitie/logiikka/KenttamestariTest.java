package com.tuomitie.logiikka;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class KenttamestariTest {

    private Kenttamestari km;
    private InputStream is;
    private File tiedosto;
    private List<Kentta> kaikkiKentat;
    private List<Kentta> helpotKentat;
    private List<Kentta> semiKentat;
    private List<Kentta> vaikeatKentat;

    @Before
    public void setUp() {
        km = new Kenttamestari();
        is = getClass().getClassLoader().getResourceAsStream("pohjat.txt");
        kaikkiKentat = new ArrayList<>();
        helpotKentat = new ArrayList<>();
        semiKentat = new ArrayList<>();
        vaikeatKentat = new ArrayList<>();
        km.haeTiedosto();
        km.haeKaikkiKentatListalle();
    }

    @Test
    public void kenttaAnnetaan() {
        Kentta kentta = km.annaKentta();
        assertNotNull(kentta);
    }

    @Test
    public void kenttaVaikeustasollaToimii() {
        Kentta kentta = km.annaKenttaVaikeustasolla("easy");
        assertTrue(kentta.getVaikeustaso() <= 125);
        kentta = km.annaKenttaVaikeustasolla("semi");
        assertTrue(kentta.getVaikeustaso() > 125 && kentta.getVaikeustaso() <= 225);
        kentta = km.annaKenttaVaikeustasolla("hard");
        assertTrue(kentta.getVaikeustaso() > 225);
    }
}
