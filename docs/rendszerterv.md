Rendszerterv
============
A rendszer célja
----------------
A rendszer legfőbb célja, hogy segítse a szakkörön résztvevők logikai készségeinek fejlődését. Az alkalmazás játékos formában támogassa a szakkör tematikáját, ezzel a résztvevők érdeklődésének felkeltését hivatott szolgálni. A többszemélyes játékok célja többek között az egészséges versenyszellem ébresztése a diákokban, míg a csapatjátékok (vagy ha egy kétszemélyes játékot csapatban játszanak) esetén a tanulók összedolgozási, illetve együttműködési képességének a fejlesztése.

Cél továbbá a felhasználók hozzászoktatása a versenyhelyzetekhez, és azok kezeléséhez. Ez a játékok kompetitív jellegéből adódik, és továbbá fejleszti a tanulók koncentrálóképességét.

Az elért eredményeket fontos nyomon követni, hogy a diákok számon tarthassák korábbi eredményeiket. Ugyanakkor ehhez egy játékosnéven túl semmilyen személyes információt, adatot nem hivatott az alkalmazás tárolni, csupán a játékra vonatkozó legfontosabb adatokat. A rendszerre vonatkozó szabályoknak megfelelően az alkalmazás nem tárolhat semmit az adott iskolai gépen kívül.

A mai fiataloknak az egyre inkább digitális világban nagyon fontos, hogy elsajátítsák a modern technika helyes és hasznos használatát. A program ehhez is hozzájárul, illetve a technika iránti érdeklődést is növelni hivatott. A használatával a tanulók fejleszthetik számítógépes ismereteiket.

A rendszer célja továbbá az egyszerű, zökkenőmentes működés biztosítása, mivel a felhasználók nagy része nem rendelkezik különösebb informatikai szaktudással. A program Windows operációs rendszer alatt kell, hogy fusson. Ehhez korszerű gépek állnak a megrendelő rendelkezésére. Ugyancsak cél a telepítés, illetve karbantartás komplexitásának minimalizálása is.

Ezen felül a rendszernek célja, hogy a szakkörön meglévő játékokat inkább kiegészítse, mintsem helyettesítse.

Projekt terv
------------

Üzleti folyamatok modellje
--------------------------

Követelmények
-------------
### Funkcionális követelmények
- K01: Eredménytárolás adatbázisban
    - Játékosnév, Pontszám/Győztes és Dátum tárolása
    - mindenkori TOP 5 eredmény tárolása külön táblában a bajnokságok segítése érdekében
    - az összes korábbi eredmény törlésének biztosítása, leszámítva a Top 5 eredményt tartalmazó táblát
- K02: Játékok közötti váltás lehetőségének biztosítása egy központi felületen keresztül
    - a program indításakor ez a központi felület kell, hogy köszöntse a felhasználót
    - a programnak futási időben kezelnie kell a játékok közötti váltást
- K03: Aktuális játék újraindításának lehetősége
    - az újraindítás során a korábbi játékos nevet/neveket kell használni az új játszmához
- K04: Grafikus megjelenítés
    - programnak kötelezően rendelkeznie kell grafikus felhasználói felülettel
- K05: Egyszemélyes és többszemélyes játékok biztosítása
    - fontos, hogy mind a két kategóriából tartalmazzon legalább egy játékot a csomag

### Nemfunkcionális követelmények
- K01: Intuitív, felhasználóbarát UI
    - a grafikus felhasználói felületnek könnyen kezelhetőnek kell lennie
    - a használatához szükséges tudás elsajátítása nem lehet hosszabb 1-2 percnél
- K02: Kellemes színvilág
    - a program színvilágának olyannak kell lennie, hogy a diákok figyelmét felkeltse
    - fontos szempont, hogy ne legyen megterhelő a felhasználó szemének hosszabb játszmák során sem
- K03: Windows operációs rendszer támogatása
    - programnak Windows 7 és Windows 10 operációs rendszereket kell támogatnia
- K04: Program megbízható működése rejtélyes hibák, fagyások nélkül
    - az átadáskor a programnak stabilan kell működnie, csak optimalizációs problémák
    - nem fordulhat elő olyan, hogy játék közben hibával terminál a program
- K05: Az eredmények lokális tárolása
    - a játékok során gyűjtött adatokat nem szabad távoli szerveren tárolni, kizárólag azon a számítógépen, melyen telepítve van a programcsomag

### Törvényi előírások
- K01: GDPR szabályok betartása
    - a játékok során gyűjtött adatok minden esetben a GDPR-nak megfelelően kell kezelni

Funkcionális terv
-----------------

Fizikai környezet
-----------------

Absztrakt domain modell
-----------------------

Architektúrális terv
--------------------

Adatbázis terv
--------------
Az eredmények tárolásához egy H2 adatbázis lesz használva annak gyorsasága és open source jellege miatt. A felemerülő igények kielégítéséhez bőven elegendő a tudása és nem elhanyagolható szempont az alacsony rendszerigénye.
A játékok eredményeit külön-külön adatbázis táblában fogja tárolni a program,melyek esetén lehetőség lesz a teljes törlésre. Ezen felül minden játékhoz tartozni fog egy a legjobb 5 eredményt tároló tábla is, melyet nem lehet majd törölni. Előbbi táblák a bajnokságok nyomon követéséhez lesznek ideálisak, utóbbiak pedig a diákok versenyszellemét hivatottak fenntartani.

### Logikai modell
<p align="center">
    <img src="./images/logikai_modell.png" title="Logical model of the database">
</p>

### Tárolt eljárások
A jelenlegi igények mellett nincs szükség tárolt eljárások létrehozására. Egy esetleges továbbfejlesztés esetén újra mérlegelve lesz használatuk.

### Fizikai adatmodellt legeneráló SQL script
Az adatmodellek létrehozásához szükséges szkripteket a Hibernate programkönyvtár fogja legenerálni a DAO osztályoknak megfelelően. A jelenlegi logikai adatmodell alapján a következő SQL utasításokra lenne szükség:
```sql
CREATE TABLE DAO_RESULTS (
    RED VARCHAR(40),
    BLUE VARCHAR(40),
    WINNER VARCHAR(40),
    STEPS INT,
    DURATION TIME,
    DATE TIMESTAMP
);

CREATE TABLE DAO_ALL_TIME_TOP_50 (
    RED VARCHAR(40),
    BLUE VARCHAR(40),
    WINNER VARCHAR(40),
    STEPS INT,
    DURATION TIME,
    DATE TIMESTAMP
);
```

```sql
CREATE TABLE MINESWEEPER_RESULTS (
    PLAYER VARCHAR(40),
    DURATION TIME,
    DATE TIMESTAMP
);

CREATE TABLE MINESWEEPER_ALL_TIME_TOP_50 (
    PLAYER VARCHAR(40),
    DURATION TIME,
    DATE TIMESTAMP
);
```

```sql
CREATE TABLE TRIPLE_SHOT_RESULTS (
    RED VARCHAR(40),
    BLUE VARCHAR(40),
    WINNER VARCHAR(40),
    STEPS INT,
    DURATION TIME,
    DATE TIMESTAMP
);

CREATE TABLE TRIPLE_SHOT_ALL_TIME_TOP_50 (
    RED VARCHAR(40),
    BLUE VARCHAR(40),
    WINNER VARCHAR(40),
    STEPS INT,
    DURATION TIME,
    DATE TIMESTAMP
);
``` 

```sql
CREATE TABLE PUCKG_RESULTS (
    RED VARCHAR(40),
    RED_POINTS INT,
    BLUE VARCHAR(40),
    BLUE_POINTS INT,
    WINNER VARCHAR(40),
    DURATION TIME,
    DATE TIMESTAMP
);

CREATE TABLE PUCKG_ALL_TIME_TOP_50 (
    RED VARCHAR(40),
    RED_POINTS INT,
    BLUE VARCHAR(40),
    BLUE_POINTS INT,
    WINNER VARCHAR(40),
    DURATION TIME,
    DATE TIMESTAMP
);
``` 

Implementációs terv
-------------------

Tesztterv
---------

Telepítési terv
---------------
A megrendelő kívánsága szerint elkészített, megfelelően letesztelt alkalmazás az iskola saját rendszerének adminisztrátorainak, rendszergazdáinak kerül majd átadásra, akik elvégzik annak telepítését a kívánt iskolai számítógépekre.

Karbantartási terv
------------------
A karbantartás 2 részből áll az elkészítendő szoftver esetében. Egyrészről az esetlegesen felmerülő hibák javításának tervéről, másrészről pedig a szoftver bővítésének tervéről.

**Hibajavítási terv**: Amennyiben a szoftver átadását követően, a használat során bármilyen nemű hiba lép fel, a javítás a következő lépések szerint történik:

1. A hiba felfedezését követő legrövidebb időn belül a fejlesztők megkezdik annak feltárását, javítása.
2. A javítás elkészültével egy rövid tesztelési folyamaton megy át a javított szoftver.
3. Majd a kész szoftver díjmentesen újratelepítésre kerül az iskola számítógépein.

**Szoftverfrissítési terv**: Amennyiben az átadást követően a vásárló részéről új játékkal való bővítés igénye merülne fel, úgy az a következő lépések szerint történne:

1. Egy közös egyeztetés folyamán felmérjük az igényeket.
2. Az igényfelmérés alapján elkészítjük az árajánlatot és a pontos rendszertervet.
3. Ennek elfogadását követően megkezdődik az új játék fejlesztése, tesztelése
4. A tesztelés lezárultával pedig telepítjük a frissített szoftvereket az iskola számítógépeire.