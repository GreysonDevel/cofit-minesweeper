package eu.greyson.minesweeper;  // do not change

import eu.greyson.minesweeper.game.MineField;
import eu.greyson.minesweeper.game.Player;
import eu.greyson.minesweeper.game.TimeoutException;

public class ImplementMePlayer extends Player  {  // do not change
    public ImplementMePlayer(MineField game) {
        super(game);
    }  // do not change

    /**
     * IMPLEMENT THIS METHOD
     *
     * Goal of the game is to reveal all mines with using minimal information - uncovering the least fields!
     *
     * Run "Launcher" to test your algorithm and view your score
     *
     * HOW TO PLAY:
     * Use game.uncoverField(Field f) to get distances to all mines on the field
     * Use game.revealMine(Field m) to reveal mine
     *
     * GAME INFO:
     * game.getMinX() and game.getMinY() gives you the minimal used position on the plan
     * game.getMaxX() and game.getMaxY() gives you the maximal used position on X and Y axis respectively
     * game.getNumberOfAllMines() gives you number of mines in the current game
     * game.getDistance(Field f1, Field f2) helps you count the distance between two fields

     * Do not suppress Timeout exception.
     *
     * You cannot create custom inner classes.
     */
    @Override
    public void findMines() throws TimeoutException {  // do not change

    }
}
