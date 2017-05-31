# Cofit Minesweeper game

## Pravidla soutěže:

Pravidla soutěže:

1. Naprogramuj algoritmus v Javě pro hledání min na slepé mapě. Účelem je najít algoritmus s nejmenším počtem volání metody <strong>uncoverField</strong>.
    
2. Pro implementaci používáte prostředí předpřipravené hry, která je k dispozici na <a
                href="https://github.com/GreysonDevel/cofit-minesweeper">https://github.com/GreysonDevel/cofit-minesweeper</a>.


## Cíl hry:

* Cílem hry je odhalit co nejvíc min s pomocí co nejmíň informací.
* Informace o minách získáváte voláním funkce <strong>uncoverField</strong>, která vrací manhattanské vzdálenosti min od daného políčka.</li>
* Nalezené miny se označují voláním funkce <strong>revealMine</strong>


## Instrukce ke hře:
1. Stáhni si hru z GitHubu: <a href="https://github.com/GreysonDevel/cofit-minesweeper">https://github.com/GreysonDevel/cofit-minesweeper</a>.
        git clone https://github.com/GreysonDevel/cofit-minesweeper.git
2. Otevři ve svém oblíbeném IDE jako Java SE projekt.
   
3. Ve složce <strong>game</strong> nic neměň, jinak si celou hru uděláš nekonzistentní s produkční hrou.
4. Ve složce <strong>maps</strong> je testovací mapa s minami, na které můžeš testovat svůj kód. Definici mapy můžeš libovolně měnit, aby sis vyzkoušel svůj algoritmus na jiných velikostech a rozmístění min.
5. Napiš svůj algoritmus do metody <strong>findMines()</strong> ve třídě <strong>ImplementMePlayer.java</strong>.
* Balíček třídy musí zůstat
                    <pre class="prettyprint">package eu.greyson.minesweeper</pre>
* Definice třídy musí zůstat
                    <pre class="prettyprint">public class ImplementMePlayer extends Player</pre>
* Konstruktor třídy musí zůstat
                    <pre class="prettyprint">public ImplementMePlayer(MineField game) { super(game); }</pre>
* Metoda musí vyhazovat vyjímku TimeoutException - nepotlačuj jí
                    <pre class="prettyprint">public void findMines() throws TimeoutException</pre>
6. Do metody <strong>findMines()</strong> můžeš psát libovolný java code potřebný pro nalezení všech min.
7. Některé java konstrukce, které bys k nalezení min určitě neměl potřebovat jsou však zakázané (např. čtení ze souboru, otevírání socketů apod.).

8. V rámci metody <strong>findMines()</strong> máš k dispozici objekt
                    <pre class="prettyprint">eu.greyson.minesweeper.game.MineField game</pre> , který obsahuje celou hru:
                    
                    
                            /**
                             * Reveal the mine. The goal is to reveal all mines in the game.
                             * There is a penalty for every wrong attempt (revealing position without a mine)
                             * @param mine Mine position
                             * @return True when there is a mine, False otherwise
                             */
                            public boolean revealMine(Field mine);

                            /**
                             * Get distances from field position to every mine on the game plan
                             * (one distance for every mine, same number may occur multiple times)
                             * @param field Field to count distances from
                             * @return Sorted list with mine distances - one distance for every mine
                             */
                            public List&lt;Integer> uncoverField(Field field);

                            /**
                             * Get player's actual score
                             * @return Player's score
                             */
                            public ScoreResult getScoreResult();

                            /**
                             * Returns minimal valid position on X axis
                             * @return Minimal valid position on X axis
                             */
                            public int getMinX();

                            /**
                             * Returns minimal valid position on Y axis
                             * @return Minimal valid position on Y axis
                             */
                            public int getMinY();

                            /**
                             * Returns maximal valid position on X axis
                             * @return Maximal valid position on X axis
                             */
                            public int getMaxX();

                            /**
                             * Returns maximal valid position on Y axis
                             * @return Maximal valid position on Y axis
                             */
                            public int getMaxY();

                            /**
                             * Returns number of mines in the game (both revealed and unrevealed)
                             * @return Number of mines in the game (both revealed and unrevealed)
                             */
                            public int getNumberOfAllMines();

                            /**
                             * Calculate the distance between two positions
                             * @param from Position to count distance from
                             * @param to Position to count distance to
                             * @return Distance between the two positions
                             */
                            public int getDistance(Field from, Field to);                      


9. Vyzkoušej svůj algoritmus tím, že spustíš <strong>Launcher.java</strong>
