Követelmény specifikáció
=========================

Jelenlegi helyzet
-----------------
Az iskolánk egy átlagos általános iskola. Szerda délutánonként az érdeklődő gyerekek számára egy új szakkört indítottunk.  A szakkör alapjába véve a matematikai, illetve logikai készségeket kívánja fejleszteni. A matematikai és logikai feladatokon túl a gyerekeknek mindig van a szakkör végén idő egy kis kötetlen, szabad játékra. Ezek olyan fejlesztő játékok, melyekkel a gyerekek játékosan csiszolhatják az elméjüket, és egy kis versenyszellemet is ébreszt bennük. Ilyen játékok például a sakk, malom, amőba, illetve jónéhány táblás játék és logikai társasjáték is rendelkezésükre áll (Pentago, Kabaleo, Scrabble, Fedőnevek, Aranyásók, stb...). A játékok között az egyszemélyes játékokon kívül számos páros-, és csapatjáték található, hogy az összedolgozás, csapatmunka készségek is fejlődhessenek.
Fontos célja még a szakkörnek a fiatal diákok érdeklődésének felkeltése, ezért is szeretnénk, ha az egyre inkább digitális világban a gyerekek ilyen jellegű szoftvereket is használnának. Ez a digitális készségeik fejlesztéséhez is nagyban hozzájárulna, illetve a technika iránti érdeklődésükre is hatással lenne. Jelenleg több korszerű számítógép is rendelkezésünkre áll, melyek alkalmasak lennének az elkészült szoftverek használatára.

Vágyálom rendszer
-----------------
A gyerekek szakkörös tevékenységének, fejlődésének elősegítése céljából szeretnénk egy különféle logikai játékokat tartalmazó szoftvert. A szoftver célja, hogy a hagyományos típusú, kézzel fogható játkok mellett alternatívát nyújtson a játékos tanulásra.
Azon felül, hogy egy újabb, gyerekek számára manapság sokkal izgalmasabbnak tűnő világban játszva fejleszthetik logikai képességeiket, gondolkodásukat, fontos kiemelni, hogy ezzel a lehetőséggel a gyerekek digitális képességeinek gyaraposását is elősegítik. Ez ebben a digitális korban egyre inkább alapkövetelmény, mint kiemelendő képesség. Úgy érezzük, hogy iskola lévén kötelességünk ilyen téren is oktatni a gyerekeket. Ez további lehetőséget biztosít arra, hogy azon felül, hogy tudják is használni a rendelkezésükre álló eszközöket, felelős felhasználók legyenek.
A játékok legyenek egy- és többszemélyesek. E szempont célja, hogy több különféle helyzetben törekedjenek a gondolkodásra, például a többszemélyes játékok esetén az előre gondolkodás, előre látás képességét is elsajátíthassák.
Szeretnénk, ha a játékok közel hasonló stílussal rendelkezzenek, mely elősegítheti azt a folyamatot, mely során a gyerekek elsajátítják egy-egy új játék alapjait. Ez azért fontos, hogy egy új játék kipróbálása során ne az új stílusok befogadása és megértése kösse le a figyelmüket, hanem egy már jól ismert *világban* nézhessenek szembe az újabb kihívásokkal. A megjelenítéssel kapcsolatos további igény az egységen kívül az az, hogy egy gyerekek számára alkalmas kellemes környezetben jelenjenek meg a játékok.
Amit szívesen látnánk még a szoftver által nyújtott lehetőségek palettáján, az az eredménykövetés. Időről időre egy kisebb szakkörön belüli bajnokságot is szeretnénk szervezni a gyerekek versenyszellemének fejlesztése céljából. Ezért fontos lenne minden játékhoz egy eredményjelző tábla, hogy a játékban elért eredményket ne papíron kelljen nyomon követni.

Jelenlegi üzleti folyamatok
---------------------------

Igényelt üzleti folyamatok
--------------------------
- __Játék elindítása__: program megnyitása &rarr; választás az elérhető játékok között &rarr; annak eldöntése, hogy egyedül, vagy többen szeretnénk játszani &rarr; játékos nevek megadása &rarr; játék elkezdése

- __Korábbi eredmények megtekintés__: program megnyitása &rarr; eredménylista megnyitása &rarr; játék kiválasztása, melynek az eredményeire kíváncsiak vagyunk

A rendszerre vonatkozó szabályok
--------------------------------

Az alkalmazást Windows operációs rendszer alatt szeretnénk futtatni, korszerű gépeken. Annyi az elvárásunk ezzel kapcsolatban, hogy a programokat zökkenőmentesen lehessen telepíteni és használni, különösebb informatikai szaktudás nélkül is. Ennek a technikai megvalósítása számunkra lényegtelen.


A program tárolhatja a játékosok neveit (akár valódi, akár játékosnév), de más személyes adatokat nem. A játékosok játék során keletkező adatait, illetve a játékosok nevét ne tároljuk semmilyen más, külső szerveren, csak az adott iskolai számítógépen.

Követelménylista
----------------
- K01: Szép, könnyen használható felület
- K02: Grafikus megjelenítés
- K03: Kellemes színvilág
- K04: Korábbi játékok eredményeinek tárolása
    - Játékosnév megadása, tárolása
    - Pontszám/győztes játékos tárolása
    - Eredmény dátumának tárolása
- K05: Egy- és többszemélyes játékok

Fogalomszótár
-------------
- __Sakk__: Kétszemélyes játék, melyet egy 8x8-as táblán játszanak. Mind a két játékos 16 bábuval rendelkezik. Ebből 8 darab *paraszt*, 2 darab *bástya*, 2 darab *ló*, 2 darab *futó*, egy *király* és egy *királyné*. Minden bábunak meg van szabva, hogy hogyan léphet. Bármely bábú bármely bábut leüthet, ha szabály szerint érvényesen lép, és az adott négyzetben az ellenfél bábuja áll. A *paraszt* viszont kivétel, ugyanis csak átlósan lépve egyet tud bábut leütni, ha nem leüt éppen egy bábut, akkor csak előre vagy hátra léphet egyet. További kivétel, hogy a játék elején a kezdő játékos léphet kettőt is a parasztjával. A játék célja, hogy az ellenfél *király* bábuja ne tudjon lépni. A játék ezen állapotát nevezik sakknak. Bővebben: [https://hu.wikipedia.org/wiki/Sakk](https://hu.wikipedia.org/wiki/Sakk).
- __Malom__: Kétszemélyes táblás játék. Mindkét játékosnak 9 bábuja van. A bábukkal függőlegesen vagy vízszintesen lehet lépni. Cél, hogy az ellenfél összes bábuját levegyük, vagy olyan helyzetben hozzuk, hogy ne tudjon sehova lépni megmaradt bábuival. Bábut levenni akkor lehet, ha malmot rakunk ki, vagyis egy sorba, vagy egy oszlopban van 3 bábuja.
Bővebben: [https://hu.wikipedia.org/wiki/Malom_(játék)](https://hu.wikipedia.org/wiki/Malom_(j%C3%A1t%C3%A9k)).
- __Amőba__: Kétszemélyes stratégiai játék. Lehet játszani táblán is, de főleg négyzethálós papíron szokás játszani. A "tábla" mérete, és ennek megfelelően a bábuk száma sincs megszabva. A játékosok bábukat raknak le (jellemzően X-et és O-t írnak a négyzetekbe), és az győz, akinek sikerül legalább 5 bábuját egy vonalban leraknia. A játék neve onnan ered, hogy a győztes az alakzatot körberajzolja, és az így kialakult alakzat [amőbára](https://hu.wikipedia.org/wiki/Am%C5%91b%C3%A1k) hasonlít.
Bővebben: [https://hu.wikipedia.org/wiki/Amőba_(játék)](https://hu.wikipedia.org/wiki/Am%C5%91ba_(j%C3%A1t%C3%A9k))
- __Pentago__: Az Amőbához hasonló kétszemélyes stratégiai játék. A játékosok 4 darab 3x3-as táblán játszanak. Minden körben a játékos lerakja az egyik bábuját, és 90°-ban elfogatja az egyik táblát. Az győz, akinek elsőnek sikerül 5 darab bábut egy vonalban leraknia. Bővebben: [https://tarsasoznijo.blog.hu/2011/10/07/pentago_1](https://tarsasoznijo.blog.hu/2011/10/07/pentago_1)
- __Kabaleo__: 2-4 személyes társasjáték. A játék során különböző színű gúlákat kell egymásra helyezni. A gúlák között van egy csíkos és két csíkos. Ennek ott van jelentősége, amikor egymásra helyezünk gúlákat. Ugyanis tilos azonos színű gúlákat egymásra rakni, kivéve, ha a legfelső gúla két csíkos. Ebben az esetben a két azonos színű gúla kiesik a játékból, tehát az alattuk lévő gúla válik a legfelsővé. Minden játékos a játék elején kap egy felülről csupa fehér gúlát, így a játékosok nem tudják, hogy ki milyen színt kapott. Ennek belsejében található a szín, ami az adott játékos színe lesz a játszma során. A játékos akkor nyer, ha minden gúla elhelyezése után legfelül az ő színéből van a legtöbb.
Bővebben: [https://www.saseskos.hu/custom/saseskos/image/data/srattached/c32b59237bcdc8a928e73c3652e2b5bb_kabaleo_tarsasjatek_jatekszabaly.pdf](https://www.saseskos.hu/custom/saseskos/image/data/srattached/c32b59237bcdc8a928e73c3652e2b5bb_kabaleo_tarsasjatek_jatekszabaly.pdf)
- __Scrabble__: 2-4 fős betűjáték. A játék során egymáshoz kapcsolódó, értelmes szavakat kell kirakni, így formája hasonlít a keresztrejtvényhez. A szavakat betűzsetonok lerakásával lehet kirakni, melyek különböző értékkel rendelkeznek. Ezen felül tábla egyes mezői szorzókkal vannak ellátva. Az a játékos győz, aki a legtöbb pontot gyűjti össze a játék során.
Bővebben: [https://hu.wikipedia.org/wiki/Scrabble](https://hu.wikipedia.org/wiki/Scrabble)
- __Fedőnevek__: Szójáték, melyben 2-8+ vagy 4-8+ fő vehet részt. A játékosok 2 csapatot alkotnak. A játékosok célja, hogy felfedjék a másik csapat ügynökeit. Minden csapatban van egy fő, aki pontosan tudja, hogy a lerakott nevek közül a csapatának melyikeket kéne választania, köszönhetően a kulcskártyának. A kiemelt játékosok feladata, hogy a kódneveket egy fogalommá gyúrják össze, vagyis egy olyan fogalmat mondjanak, ami segítségével csapattársaik a lehető legtöbb ügynököt leplezik le. A játékban nehezítésként vannak még járókelők, és egy bérgyilkos is. A járókelők gyanusítása nem ér pontot, a másik csapat jön. A bérgyilkos esetén viszont a csapat veszít. Abban az esetben, ha saját ügynököt gyanúsítanak meg, akkor a másik csapat kapja a pontot. Az a csapat győz, aki hamarabb megtalálja az ellenfél ügynökeit.
Bővebben: [https://tarsasjatekrendeles.hu/shop_ordered/7237/pic/Gemklub/codenames-szabaly.pdf](https://tarsasjatekrendeles.hu/shop_ordered/7237/pic/Gemklub/codenames-szabaly.pdf)
- __Aranyásók__: Kártyajáték, melyet 3-10 fő játszhat. A játékosok lehetnek aranyásók vagy szabotőrök, akik akadályozzák az aranyásók tevékenységét. A játékosok nem tudják egymásról biztosan, hogy ki melyik csoportba tartozik, viszont az azonos csoportban lévőknek érdemes segíteniük egymást. Ha az aranyásók elérik a kincset, akkor övék minden arany, ellenben pedig a szabotőröké. Csak az arany elosztásánál derül ki, hogy ki melyik csapathoz tartozott. Az a játékos nyer, akinek a legtöbb aranya van 3 forduló után.
Bővebben: [http://ketaklub.hu/letoltes/Aranyasok%20Piatnik.pdf](http://ketaklub.hu/letoltes/Aranyasok%20Piatnik.pdf)
