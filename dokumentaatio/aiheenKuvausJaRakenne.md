#Number Palace

Sudoku-sanan alkuperäinen merkitys on Wikipedian mukaan "number place". Se kuitenkin kuulostaa aika tylsältä - siksi number palace!

**Aihe:** Sudoku. Toteutetaan Sudokuohjelma, jonka perustoiminnallisuutena on tarjota pelaajalle mahdollisuus pelata perinteistä 9x9 ruudun Sudokua. Sovellus toimii Swingillä toteutetussa graafisessa käyttöliittymässä, jossa pelaaja syöttää numeroita hiiren ja näppäimistön avulla. Yksinkertaisimmillaan pelikierros päättyy, kun kaikki numerot on syötetty oikein.

Jos projekti etenee hyvin, voidaan pelin toimintaa laajentaa mm. lisäämällä ajastettu pelimuoto, jossa pelaaja saa sitä enemmän pisteitä, mitä nopeammin Sudoku ratkaistaan. Pisteet tallennetaan Highscore-listalle. Myös vaikeustasojen lisääminen (eli annettujen numeroiden määrän vähentäminen) voi olla mahdollinen kehitysvaihtoehto.

Muista Sudokusovelluksista erottuakseen pelissä voisi mahdollisesti olla toiminto, joka piirtää jokaisesta pelikerrasta värillisen 9x9 ruudukon esimerkiksi ratkaistujen numeroiden ajankohtien mukaan, ja liittäisi ne pelikierroksen päätteeksi osaksi "tilkkutäkkiä", joka muodostuisi orgaanisesti pelaajan pelien pohjalta. Tätä ei kuitenkaan voitane pitää kovin korkealle priorisoituna ominaisuutena.

**Käyttäjät:** Ajanvietepeleistä kiinnostuneet

**Tavanomainen pelikierros:**

* pelin käynnistäminen alkuvalikosta
* numeroiden sijoittaminen ruudukon tyhjiin kenttiin yksi kerrallaan
  * pelaaja osoittaa tyhjiä kenttiä hiirellä, ja kirjoittaa ehdottamansa numeron kenttään
* pelikierros päättyy, kun kaikki numerot on syötetty oikein

**Alkuvalikon toiminnot:**

* alkuvalikossa voi olla listattuna useampi pelitapa:
  * ajastettu
  * aikaa vastaan
  * erimuotoiset kentät?

* vaikeustasot:
  * helppo
  * tavallinen
  * vaikea
  * deity

* jos päädytään toteuttamaan edellä kuvailtu graafinen "tilkkutäkki", sitä pääsee myös tarkastelemaan alkuvalikosta

* highscoret näytetään alkuvalikon yhteydessä, jos niitä on

**Luokkakaavio**

![Luokkakaavio 0.1.0](/dokumentaatio/kuvat/Luokkakaavio.png "Luokkakaavio 0.1.0")

**Sekvenssikaaviot**

Kaavio kuvaa järjestelmässä tapahtuvia kutsuja, kun pelaaja painaa peliruudulla olevaa alkiota, jonka alkuarvo on 9. Uudeksi arvoksi tulee Sudokun numerotaulukossa 0, ja GUI:ssa napin tekstikenttä tyhjennetään.

![Sekvenssikaavio kasvata](/dokumentaatio/kuvat/sekvenssikaavio-kasvata.png "Sekvenssikaavio kasvata")

Alempi kaavio kuvaa välitettyjä kutsuja kun pelaaja painaa GUI:n Tarkista-painiketta, kun kaikki alkiot on täytetty oikein. Sudoku-luokka tarkistaa vastauksen, ja käyttöliittymä näyttää pelaajalle PopUp-ikkunan, jossa lukee innostava teksti.

![Sekvenssikaavio tarkista](/dokumentaatio/kuvat/sekvenssi-tarkista.png "Sekvenssikaavio tarkista")

:japanese_castle: @tuomitie
