Tesztelési jegyzőkönyv
======================

| Tesztelő  | Időpont | Utolsó commit | Elvégzett művelet | Eredmény | Helyes-e a működés? | Mit tesztelt ezzel? |
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| Fürjes-Benke Péter | 2020.12.06. 17:47 | d25abbb | 'Rules' gomb lenyomása a főképernyőn a Dao játéknál | Megjelennek a Dao játék szabályai | Igen | A Dao játékhoz tartozó 'Rules' gomb helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 17:50 | d25abbb | 'Rules' gomb lenyomása a főképernyőn úgy, hogy a szabályok meg vannak jelenítve. | A játék szabályai eltűnnek. | Igen | 'Rules' gomb helyes működése a főképernyőn.  |
| Fürjes-Benke Péter | 2020.12.06. 17:55 | c9c4216 | 'Start' gomb lenyomása a főképernyőn a Dao játéknál | Megjelenik a Dao játék előképernyője | Igen | A 'Start' gomb helyes működésének tesztelése |
| Fürjes-Benke Péter | 2020.12.06. 18:00 | 1c98b0e | Az első input mezőről való átlépés a következő input mezőre anélkül, hogy nevet adnánk meg | Megjelenik az 'Input Required' szöveg az input mező alatt. | Igen | Az első input mező üresen hagyásának helyes kezelése |
| Fürjes-Benke Péter | 2020.12.06. 18:04 | 1c98b0e | A második input mezőről való átlépés az első input mezőre anélkül, hogy nevet adnánk meg | A második input mező alatt megjelenik az 'Input Required' figeylmeztetés | Igen | A második input mező üresen hagyásának helyes kezelése. |
| Fürjes-Benke Péter | 2020.12.06. 18:07 | 1c98b0e | Az első input mező kitöltése úgy, hogy az 'Input Required' figyelmeztetés meg van jelenítve | Az 'Input Required' figyelmeztetés eltűnik | Igen | Az első input mező kitöltésébnek helyes kezelése |
| Fürjes-Benke Péter | 2020.12.06. 18:11 | 1c98b0e | A második input mező kitöltése úgy, hogy az 'Input Required' figyelmeztetés meg van jelenítve | Az 'Input Required' figyelmeztetés eltűnik | Igen | A második input mező kitöltésébnek helyes kezelése |
| Fürjes-Benke Péter | 2020.12.06. 18:16 | 11b8612 | 'Start' gomb lenyomása úgy, hogy valamelyik input mező nincs kitöltve a Dao játéknál| Az input mezők alatt megjelenik az 'Input Required' figyelmeztetés | Igen | A 'Start' gomb helyes működése, ha valamelyik input mező nincs kitöltve |
| Fürjes-Benke Péter | 2020.12.06. 18:20 | 11b8612 | 'Start' gomb lenyomása úgy, hogy input mindkét mező ki van töltve a Dao játéknál | Elindul a játék | Igen | A 'Start' gomb helyes működése, ha az input mezők ki vannak töltve |
| Fürjes-Benke Péter | 2020.12.06. 18:26 | c8be3b4 | 'Pause' gomb lenyomása a Dao játék ablakában | A stopper megáll és a játéktér elszürkül | Igen | A 'Pause' gomb helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:28 | c8be3b4 | 'Play' gomb lenyomása, amikor a játék meg van állítva | A stopper elindul és a játéktér aktiválódik | Igen | A 'Play' gomb helyes működése, ha a játék szünetel. |
| Fürjes-Benke Péter | 2020.12.06. 18:32 | e6b0cd9 | 'Restart' gomb lenyomása a Dao játéknál | A játék újraindul. | Igen | A 'Restart' gomb helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:34 | bbad640 | Bábura kattintás a Dao játéknál | Az üres mezők aktiválódnak | Igen | A Bábura kattintás helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:37 | bbad640 | Üres mezőre kattintás úgy, hogy nincs kiválasztva egy bábu sem a Dao játéknál | Nem történik semmi | Igen | Az üres mezőre kattintás helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:37 | bbad640 | Üres mezőre kattintás úgy, hogy van kiválasztva bábu a Dao játéknál| A bábu áthelyeződik az üres mezőre | Igen | Az üres mezőre kattintás helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:43 | 5d7e1fa | 'Give up' gomb lenyomása a Dao játéknál | Megjelenik az eredményeket összegző ablak | Igen | 'Give up' gomb helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:45 | 0ded313 | 'Rematch' gomb lenyomása az eredmény képernyőn a Dao játéknál | Elindul a játék a korábbi nevekkel | Igen | 'Rematch' gomb tesztelése a Dao játék eredményjelzőjénél |
| Fürjes-Benke Péter | 2020.12.06. 18:50 | a8458bd | 'Jump to home screen' gomb lenyomása az eredmény képernyőn a Dao játéknál | Megjelenik a főképernyő | Igen | A 'Jump to home screen' gomb helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:53 | 55be30d | 'Delete' gomb lenyomása a Dao játék eredmény képernyőjén | Eltűnnek a korábbi eredmények | Igen | 'Delete' gomb helyes működése |
| Fürjes-Benke Péter | 2020.12.06. 18:55 | 25ddeaf | TOP 5/ALL gomb lenyomsáa | Az gomb aktuális állása szerint megjelenik a Top 5 vagy All eredménylista | Igen | TOP 5/ALL gomb helyes működése |
| Szabó Benedek | 2020.12.06 07:25| d25abbb | Főmenü: Játékok közötti navigáció az oldalsó nyilak használatával, mind a két irányba | Sikeres váltás a játékok között, szép átvezető animáció | Igen | Főmenü: Játékok közötti navigáció |
| Szabó Benedek | 2020.12.06 17:29| d25abbb | Főmenü: Exit gomb lenyomása a Dao játék alatt | Kilépés | Igen | Főmenü: Dao exit gomb |
| Szabó Benedek | 2020.12.06 17:29| d25abbb | Főmenü: Exit gomb lenyomása a Minesweeper játék alatt | Kilépés | Igen | Főmenü: Minesweeper exit gomb |
| Szabó Benedek | 2020.12.06 17:29| d25abbb | Főmenü: Exit gomb lenyomása a PuckG játék alatt | Kilépés | Igen | Főmenü: PuckG exit gomb |
| Szabó Benedek | 2020.12.06 17:29| d25abbb | Főmenü: Exit gomb lenyomása a TriplePuck játék alatt | Kilépés | Igen | Főmenü: TriplePuck exit gomb |
| Szabó Benedek | 2020.12.06 17:33| d25abbb | Főmenü: Rules gomb első lenyomása a TriplePuck játék alatt | Szabályok megjelenítése | Igen | Főmenü: TriplePuck Rules gomb |
| Szabó Benedek | 2020.12.06 17:33| d25abbb | Főmenü: Rules gomb első lenyomása a PuckG játék alatt | Szabályok megjelenítése | Igen | Főmenü: PuckG Rules gomb |
| Szabó Benedek | 2020.12.06 17:33| d25abbb | Főmenü: Rules gomb első lenyomása a Minesweeper játék alatt | Szabályok megjelenítése | Igen | Főmenü: Minesweeper Rules gomb |
| Szabó Benedek | 2020.12.06 17:33| d25abbb | Főmenü: Rules gomb első lenyomása a Dao játék alatt | Szabályok megjelenítése | Igen | Főmenü: Dao Rules gomb |
| Szabó Benedek | 2020.12.06 17:38| d25abbb | Főmenü: Rules gomb második lenyomása a TriplePuck játék alatt | Szabályok eltűnése | Igen | Főmenü: TriplePuck Rules gomb |
| Szabó Benedek | 2020.12.06 17:38| d25abbb | Főmenü: Rules gomb második lenyomása a PuckG játék alatt | Szabályok eltűnése | Igen | Főmenü: PuckG Rules gomb |
| Szabó Benedek | 2020.12.06 17:38| d25abbb | Főmenü: Rules gomb második lenyomása a Minesweeper játék alatt | Szabályok eltűnése | Igen | Főmenü: Minesweeper Rules gomb |
| Szabó Benedek | 2020.12.06 17:38| d25abbb | Főmenü: Rules gomb második lenyomása a Dao játék alatt | Szabályok eltűnése | Igen | Főmenü: Dao Rules gomb |
| Szabó Benedek | 2020.12.06 17:40 | d25abbb | Főmenü: Intuitív grafikus felület | A felületen könnyedén el lehet igazodni, minden logikus, magától értetődő. | Igen | Főmenü: intuitív felület |
| Szabó Benedek | 2020.12.06 17:40 | d25abbb | Főmenü: Kellemes színvilág | A felületen színvilága modern, egymással összhangban lévő árnyalatokkal. | Igen | Főmenü: Színvilág |
| Szabó Benedek | 2020.12.06 17:43 | d25abbb | TriplePuck: Start gomb lenyomása | A játék kezdőképernyőjén találjuk magunkat | Igen | TriplePuck: Start gomb |
| Szabó Benedek | 2020.12.06 17:43 | d25abbb | TriplePuck: Start game gomb lenyomása, nevek nékül | A játék nem indul el | Igen | TriplePuck: Start game gomb |
| Szabó Benedek | 2020.12.06 17:43 | d25abbb | TriplePuck: Start game gomb lenyomása, a nevek megadása után | A játék elindul| Igen | TriplePuck: Start game gomb |
| Szabó Benedek | 2020.12.06 17:49 | d25abbb | TriplePuck: Ki jön? | Soron következő játékos kijelzése | Igen | TriplePuck: Soron következő játékos jelzése |
| Szabó Benedek | 2020.12.06 17:49 | d25abbb | TriplePuck: Lépések száma | Lépések számának kijelzése | Igen | TriplePuck: Lépések számának jelzése |
| Szabó Benedek | 2020.12.06 17:49 | d25abbb | TriplePuck: Idő | Eltelt idő kijelzése | Igen | TriplePuck: Eltelt idő kijelzése |
| Szabó Benedek | 2020.12.06 17:53 | d25abbb | TriplePuck: Give up gomb megnyomása| Győztes kijelzés, Finish gomb, stopper leáll | Igen | TriplePuck: Give up gomb |
| Szabó Benedek | 2020.12.06 17:53 | d25abbb | TriplePuck: Finish up gomb megnyomása| Eredményekhez navigálunk | Igen | TriplePuck: Finish gomb |
| Szabó Benedek | 2020.12.06 17:58 | d25abbb | TriplePuck: Lépések a táblán| Csak a soron következő játékos tud lépni, illetve csak a megfelelő mezők egyikére | Igen | TriplePuck: Korongok mozgatása |
| Szabó Benedek | 2020.12.06 17:58 | d25abbb | TriplePuck: Győzelem elérése | Győztes neve megjelenik, stopper leáll, finish gomb váltja a give up-ot | Igen | TriplePuck: Győzelem |
| Szabó Benedek | 2020.12.06 18:00 | d25abbb | TriplePuck: Eredményekhez navigálás | Mind a top5, mind a korábbi erdmények megjelennek | Igen | TriplePuck: Eredmények |
| Szabó Benedek | 2020.12.06 18:00 | d25abbb | TriplePuck: Delete gomb lenyomása| Törli a korábbi eredményeket | Igen | TriplePuck: Delete gomb |
| Szabó Benedek | 2020.12.06 18:00 | d25abbb | TriplePuck: Rematch gomb lenyomása| Visszavágó, az előbbi játékosnevekkel | Igen | TriplePuck: Rematch gomb |
| Szabó Benedek | 2020.12.06 18:00 | d25abbb | TriplePuck: Restart gomb lenyomása| Újbóli játék, más játékosnevekkel | Igen | TriplePuck: Restart gomb |
| Szabó Benedek | 2020.12.06 18:05 | d25abbb | TriplePuck: "Jump to home screen" gomb lenyomása| Visszaugrunk a kezdőképernyőre | Igen | TriplePuck: Home gomb |
| Szabó Benedek | 2020.12.06 18:05 | d25abbb | TriplePuck: Exit gomb lenyomása| Kilép az alkalmazás | Igen | TriplePuck: Exit gomb |
| Bartha Balázs | 2020.12.6. 14:58 | b9a03de | 'Rules' gomb lenyomása a főmenüben, a minesweeper menüpont alatt | Megjelennek a játék szabályai | Igen | Minesweeper: Rules gomb működése |
| Bartha Balázs | 2020.12.6. 15:00 | b9a03de | 'Rules' gomb lenyomása a főmenüben, úgy, hogy a minesweeper szabályok vannak megjelenítve | Eltűnnek a játék szabályai | Igen | Minesweeper: Rules gomb működése |
| Bartha Balázs | 2020.12.6. 15:03 | b9a03de | 'Start' gomb lenyomása a főmenüben, a minesweeper menüpont alatt | Betölt a minesweeper launch.fxml | Igen | Minesweeper: Start gomb működése |
| Bartha Balázs | 2020.12.6. 15:05 | b9a03de | 'Start Game' gomb lenyomása a minesweeper kezdőképernyőn, beírt név nélkül | Megjelenik a hibaüzenet | Igen | Minesweeper: Start game gomb működése |
| Bartha Balázs | 2020.12.6. 15:07 | b9a03de | 'Start Game' gomb lenyomása a minesweeper kezdőképernyőn, beírt névvel. | Betölt a minesweeper game.fxml | Igen | Minesweeper: Start game gomb működése, játék betöltése |
| Bartha Balázs | 2020.12.6. 15:10 | b9a03de | Bal klikkelés az egyik rejtett mezőre | A mezőn megjelenik a revealed2.png | Igen | Felfedés működése |
| Bartha Balázs | 2020.12.6. 15:12 | b9a03de | Bal klikkelés a 2-es mező körüli mezőkre | Vesztés, 2 bomba volt a mező körül | Igen | Szomszédos bombák számolása |
| Bartha Balázs | 2020.12.6. 15:13 | b9a03de | Játék szándékos elvesztése | Az összes mező felfedésre kerül, megjelenik a retry gomb és a game over szöveg. | Igen | Minesweeper: Játék elvesztése |
| Bartha Balázs | 2020.12.6. 15:15 | b9a03de | Retry gomb lenyomása | A játék állapota a kezdőállapot lesz | Igen | Minesweeper: Retry gomb működése |
| Bartha Balázs | 2020.12.6. 15:17 | b9a03de | Reset gomb lenyomása megkezdett játék közben | A játék állapota a kezdőállapot lesz | Igen | Minesweeper: Reset gomb működése |
| Bartha Balázs | 2020.12.6. 15:55 | 7c21548 | Jobb klikkelés rejtett mezőre | A mezőn megjelenik a flagged.png | Igen | Zászlórakás működése |
| Bartha Balázs | 2020.12.6. 15:57 | 7c21548 | Bal klikkelés zászlós mezőre | Semmi | Igen | Zászlózott mezők működése |
| Bartha Balázs | 2020.12.6. 15:58 | 7c21548 | Jobb klikkelés felfedett mezőre | Semmi | Igen | Zászlólerakás működése |
| Bartha Balázs | 2020.12.6. 16:00 | 7c21548 | Jobb klikkelés zászlózott mezőre | A zászló eltűnik | Igen | Zászlóeltávolítás működése |
| Bartha Balázs | 2020.12.6. 16:02 | 7c21548 | Bal klikkelés mezőre, mely körül nincs bomba | Felfedésre kerül a zóna, és minden körülötte lévő zóna, és az azok körüli összes, míg olyanba nem ütközik, mely körül van bomba. | Igen | Rekurzív felfedés működése |
| Bartha Balázs | 2020.12.6. 16:04 | 7c21548 | Minden bomba nélküli zóna felfedése | Megjelenik a finish gomb, és a gratuláló szöveg. | Igen | Minesweeper: Játék megnyerése |
| Bartha Balázs | 2020.12.6. 16:07 | 7c21548 | Finish gomb lenyomása | Betölt a minesweeper highscores.fxml | Igen | Minesweeper: Finish gomb működése |
| Bartha Balázs | 2020.12.6. 16:10 | 7c21548 | Top/All kapcsoló lenyomása | A felsorolt eredmények az összes eredmény helyett csak a legjobb 5-öt tartalmazzák | Igen | Minesweeper: Top eredmények és kapcsológomb működése |
| Bartha Balázs | 2020.12.6. 16:11 | 7c21548 | Delete gomb lenyomása | Az "all" adatbázis listája törlődik, de a "top" nem | Igen | Minesweeper: Delete gomb működése |
| Bartha Balázs | 2020.12.6. 16:11 | 7c21548 | Main Menu gomb lenyomása | Betölt a central start.fxml | Igen | Minesweeper: Main Menu gomb működése |
| Mezei Botond | 2020.12.06. 15:34 | 7c21548 | PuckG Rules gomb lenyomása | PuckG játék szabályainak megjelenése | Igen | A PuckG Rules gomb előhozza a játék szabályait |
| Mezei Botond | 2020.12.06. 15:36 | 7c21548 | PuckG Rules gomb lenyomása a szabály jelenlétében | PuckG játék szabályainak elrejtése | Igen | A szabály ablak eltűnése a Rules gomb ismételt lenyomásával |
| Mezei Botond | 2020.12.06. 15:41 | 7c21548 | PuckG Start gomb lenyomása | PuckG játék elindulása | Igen | PuckG játék elindul-e a Start gomb lenyomására |
| Mezei Botond | 2020.12.06. 15:44 | 7c21548 | PuckG - Start Game gomb lenyomása nevek nélkül | "Input required" hibaüzenet megjelenése | Igen | PuckG - játékosnév mezők állapotának ellenőrzése |
| Mezei Botond | 2020.12.06. 15:46 | 7c21548 | PuckG - Start Game gomb lenyomása az első játékos nevének megadása nélkül | "Input required" hibaüzenet megjelenése | Igen | PuckG - az első játékosnév mező állapotának ellenőrzése |
| Mezei Botond | 2020.12.06. 15:47 | 7c21548 | PuckG - Start Game gomb lenyomása a második játékos nevének megadása nélkül | "Input required" hibaüzenet megjelenése | Igen | PuckG - a második játékosnév mező állapotának ellenőrzése |
| Mezei Botond | 2020.12.06. 15:49 | 7c21548 | PuckG - Start Game gomb lenyomása megadott játékos nevekkel | Játék elindulása | Igen | PuckG - játék sikeres elindítása a megadott nevekkel |
| Mezei Botond | 2020.12.06. 15:51 | 7c21548 | PuckG - Reset gomb lenyomása | Játékállás, pontok és az időzítő alaphelyzetbe állása | Igen | PuckG - Reset gomb működése |
| Mezei Botond | 2020.12.06. 15:53 | 7c21548 | PuckG - Give Up gomb lenyomása | Váltás az eredmények képernyőre és az aktuális eredmény perzisztálása | Igen | PuckG - Give Up gomb működése |
| Mezei Botond | 2020.12.06. 15:54 | 7c21548 | PuckG - Új korong elhelyezése lehetséges mezőre | Új korong megjelenése | Igen | PuckG - korong elhelyezésének helyessége |
| Mezei Botond | 2020.12.06. 15:55 | 7c21548 | PuckG - Meglévő korong kijelölése és áthelyezése | Korong áthelyeződik a kívánt helyre | Igen | PuckG - korong áthelyezésének helyessége |
| Mezei Botond | 2020.12.06. 15:56 | 7c21548 | PuckG - Új korong elhelyezése nem elérhető mezőre | Nem kerül korong a mezőre, újra az aktuális játékos következik | Igen | PuckG - új korong elhelyezése nem elérhető mezőre |
| Mezei Botond | 2020.12.06. 15:58 | 7c21548 | PuckG - Korong áthelyezése nem elérhető mezőre | A korong nem helyeződik át, újra az aktuális játékos következik | Igen | PuckG - korong áthelyezése nem elérhető mezőre |
| Mezei Botond | 2020.12.06. 15:58 | 7c21548 | PuckG - Új korong elhelyezése az ellenfél korongjainak közelében | Új korong megjelenése és az ellenfél 8-szomszédos korongjai átszíneződnek | Igen | PuckG - Az ellenfél 8-szomszédos korongjainak átszínezése új korong elhelyezése esetén |
| Mezei Botond | 2020.12.06. 16:01 | 7c21548 | PuckG - Korong áthelyezése az ellenfél korongjainak közelébe | Korong áthelyezése és az ellenfél 8-szomszédos korongjai átszíneződnek | Igen | PuckG - Az ellenfél 8-szomszédos korongjainak átszínezése korong áthelyezése esetén |
| Mezei Botond | 2020.12.06. 16:07 | 342bfc2 | PuckG - Kattintás a fekete mezőre | Semmi sem történik, továbbra is az aktuális játékos következik | Igen | PuckG - A fekete mező működése |
| Mezei Botond | 2020.12.06. 16:09 | 342bfc2 | PuckG - Az utolsó ellenfél számára elérhető mező koronggal való lefedése | Győztes játékos nevének megjelenése, időzítő megállítása, Give Up gomb Finish-re változása | Igen | PuckG - Játék végének helyes detektálása(nincs több elérhető mező) |
| Mezei Botond | 2020.12.06. 16:12 | 342bfc2 | PuckG - Az ellenfél utolsó korongjának átváltoztatása | Játék vége(eredményjelző, időzítő, Finish gomb) | Igen | PuckG - Játék végének helyes detektálása(nincs több elérhető korong) |
| Mezei Botond | 2020.12.06. 16:14 | 342bfc2 | PuckG - Játék vége esetén a Finish gomb lenyomása | Eredmény perzisztálása és váltás az eredményjelzőre | Igen | PuckG - Finish gomb működése |
| Mezei Botond | 2020.12.06. 16:22 | 342bfc2 | PuckG - Eredményjelző Delete gombjának lenyomása | Korábbi eredmények kitörlése az adatbázisból | Igen | PuckG - Delete gomb működése |
| Mezei Botond | 2020.12.06. 16:25 | 342bfc2 | PuckG - Top 5 és Korábbi eredmény közötti váltógombra kattintás | A másik eredmény táblázat megjelenítése(Top5/Korábbi) | Igen | PuckG - eredményjelző váltókapcsoló működése |
| Mezei Botond | 2020.12.06. 16:26 | 342bfc2 | PuckG - Eredményjelző Restart gombjának lenyomása | Új játék kezdése az új nevek megadásától | Igen | PuckG - Restart gomb működése |
| Mezei Botond | 2020.12.06. 16:27 | 342bfc2 | PuckG - Eredményjelző Main Menu gombjának lenyomása | Főmenü megjelenése | Igen | PuckG - Main Menu gomb működése |
| Mezei Botond | 2020.12.06. 16:28 | 342bfc2 | PuckG - Eredményjelző Exit gombjának lenyomása | Program bezárása | Igen | PuckG - Exit gomb működése |
