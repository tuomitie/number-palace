#Number Palace

![number-palace-logo](/number-palace/src/main/resources/number-palace-header.png "Logo")

Sudoku-sanan alkuperäinen merkitys on Wikipedian mukaan "number place". Se kuitenkin kuulostaa aika tylsältä - siksi number palace!

**Aihe:** Sudoku. Toteutetaan Sudokuohjelma, jonka perustoiminnallisuutena on tarjota pelaajalle mahdollisuus pelata perinteistä 9x9 ruudun Sudokua. Sovellus toimii Swingillä toteutetussa graafisessa käyttöliittymässä, jossa pelaaja syöttää numeroita hiiren ja näppäimistön avulla. Yksinkertaisimmillaan pelikierros päättyy, kun kaikki numerot on syötetty oikein.

**Käyttäjät:** Ajanvietepeleistä kiinnostuneet

**Tavanomainen pelikierros:**

* pelin käynnistäminen alkuvalikosta
* numeroiden sijoittaminen ruudukon tyhjiin kenttiin yksi kerrallaan
  * pelaaja osoittaa tyhjiä kenttiä hiirellä, ja kirjoittaa ehdottamansa numeron kenttään
* pelikierros päättyy, kun kaikki numerot on syötetty oikein

**Alkuvalikon toiminnot:**

* vaikeustasot:
  * helppo
  * tavallinen
  * vaikea
  * satunnainen

* highscoret näytetään alkuvalikon yhteydessä

**Luokkakaavio**

![Luokkakaavio 1.0](/dokumentaatio/kuvat/Luokkakaavio1_0.png "Luokkakaavio 1.0")

**Sekvenssikaaviot**

Kaavio kuvaa järjestelmässä tapahtuvia kutsuja, kun pelaaja painaa peliruudulla olevaa alkiota, jonka alkuarvo on 9. Uudeksi arvoksi tulee Sudokun numerotaulukossa 0, ja GUI:ssa napin tekstikenttä tyhjennetään.

![Sekvenssikaavio kasvata](/dokumentaatio/kuvat/sekvenssikaavio-kasvata.png "Sekvenssikaavio kasvata")

Alempi kaavio kuvaa välitettyjä kutsuja kun pelaaja painaa GUI:n Tarkista-painiketta, kun kaikki alkiot on täytetty oikein. Sudoku-luokka tarkistaa vastauksen, ja käyttöliittymä näyttää pelaajalle PopUp-ikkunan, jossa lukee innostava teksti.

![Sekvenssikaavio tarkista](/dokumentaatio/kuvat/sekvenssi-tarkista.png "Sekvenssikaavio tarkista")

**Jatkokehityskohteita:**

* Useampia pelitapoja: ajastettu, aikaa vastaan, erimuotoiset kentät?
* Highscore-listan tallentaminen, jotta se säilyisi pelikerrasta toiseen tallessa.
* Sävypaneelit myös dialogeihin.
* Muista Sudokusovelluksista erottuakseen pelissä voisi mahdollisesti olla toiminto, joka piirtää jokaisesta pelikerrasta värillisen 9x9 ruudukon esimerkiksi ratkaistujen numeroiden ajankohtien mukaan, ja liittäisi ne pelikierroksen päätteeksi osaksi "tilkkutäkkiä", joka muodostuisi orgaanisesti pelaajan pelien pohjalta (vrt. githubin commits-graafi).
* Ainakin tutustumista Sudokujen generointiin.

:japanese_castle: @tuomitie
