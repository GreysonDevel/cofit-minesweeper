package eu.greyson.minesweeper;

import eu.greyson.minesweeper.game.*;
import eu.greyson.minesweeper.game.InitGame;
import eu.greyson.minesweeper.game.MineField;

import java.io.IOException;

public class Launcher {
    /** You can pass map path to play. */
    public static void main(String[] arg) throws TimeoutException {
        String map = arg.length == 0 ? "map.txt" : arg[0];

        try {
            MineField game = InitGame.loadGame(map);
            Player player = new ImplementMePlayer(game);
            player.findMines();

            game.getScoreResult().printScore();
        } catch (IOException e) {
            System.out.println("Map not found.");
        }
    }
}
