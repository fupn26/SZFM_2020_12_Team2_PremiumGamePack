Funkcionális specifikáció
=========================

Rendszer céljai, nem céljai
---------------------------
### A rendszer célja, hogy:
- segítse a szakkörön résztvevők logikai készségeinek fejlődését.
- játékosan vezesse be a résztvevőket a szakkör tematikájába.
- csapatjátékok esetén növelje az együttműködési képességüket.
- hozzászoktassa a résztvevőket a versenyhelyzetekhez, és azok helyes kezeléséhez.
- javítsa koncentrálóképességüket.
- fejlessze a résztvevők számítógépes ismereteit.
- alternatívákat nyújtson a már jól ismert logikai játékok mellett.
- az elért eredmények egyszerűen visszakövethetőek legyenek.

Jelenlegi helyzet leírása
-------------------------
A megrendelő iskola egy átlagos általános iskola, egy pályázat keretében szeretne az egyik szakkörre egy játék összeállítást készíttetni. A szakkör alapjába véve a matematikai, illetve logikai készségeket kívánja fejleszteni. A matematikai és logikai feladatokon túl a gyerekeknek mindig van a szakkör végén idő egy kis kötetlen, szabad játékra. Ezek olyan fejlesztő játékok, melyekkel a gyerekek játékosan csiszolhatják az elméjüket, és egy kis versenyszellemet is ébreszt bennük. Ilyen játékok például a sakk, malom, amőba, illetve jónéhány táblás játék és logikai társasjáték is rendelkezésükre áll (Pentago, Kabaleo, Scrabble, Fedőnevek, Aranyásók, stb...). A játékok között az egyszemélyes játékokon kívül számos páros-, és csapatjáték található, hogy az összedolgozás, csapatmunka készségek is fejlődhessenek.
Fontos célja még a szakkörnek a fiatal diákok érdeklődésének felkeltése, ezért is szeretnék, ha az egyre inkább digitális világban a gyerekek ilyen jellegű szoftvereket is használnának. Ez a digitális készségeik fejlesztéséhez is nagyban hozzájárulna, illetve a technika iránti érdeklődésükre is hatással lenne. Jelenleg több korszerű számítógép is rendelkezésünkre áll, melyek alkalmasak lennének az elkészült szoftverek használatára.

A rendszerre vonatkozó szabályok
--------------------------------
Az alkalmazást Windows operációs rendszer alatt szeretnék futtatni, korszerű gépeken. Annyi az elvárás ezzel kapcsolatban, hogy a programokat zökkenőmentesen lehessen telepíteni és használni, különösebb informatikai szaktudás nélkül is. Ennek a technikai megvalósítása a megrendelő számára lényegtelen.

A program tárolhatja a játékosok neveit (akár valódi, akár játékosnév), de más személyes adatokat nem. A játékosok játék során keletkező adatait, illetve a játékosok nevét ne tároljuk semmilyen más, külső szerveren, csak az adott iskolai számítógépen.

Jelenlegi üzleti folyamatok
----------------------------

Igényelt üzleti folyamatok
--------------------------

Követelménylista
----------------
- K01: Intuitív, felhasználóbarát UI
- K02: Grafikus megjelenítés
- K03: Kellemes színvilág
- K04: Eredménytárolás adatbázisban
    - Játékosnév
    - Pontszám/győztes játékos
    - Dátum
- K05: Singleplayer és multiplayer játékok

Használati esetek
-----------------

Képernyőtervek
--------------

Forgatókönyvek
--------------
A szakkör szabadidős részében két gyermek úgy dönt, hogy a swe-game-mel játszik pár menetet egymás ellen. Ehhez a számítógép bekapcsolása után elindítják az alkalmazást, ahol a kezdőképernyőn kiválasztják a swe-game-t. Megadják a nevüket. Feri úgy dönt, hogy ő lesz a pirossal, tehát ő kezd.  A játékosok ezután felváltva lépnek, a négy szomszédos mező egyikére.
Lépegetnek, logikáznak, mig nem egyszer csak úgy alakul az állás, hogy Feri piros korongjaiból három lesz egymás mellett. Ekkor a menet játék ér, megjelenik a Győztes neve, illetve az adatbázisból láthatjuk a legutóbbi játszmák eredményeit. A játékosok választhatnak, hogy új játszmát indítanak, vagy másik játékkal szeretnének játszani, vagy pedig inkább kilépnek az alkalmazásból.
Géza nem hagyja az állást annyiban, ezért játszanak egy visszavágót.

Funkció-követelmény megfeleltetés
---------------------------------

Fogalomszótár
-------------
