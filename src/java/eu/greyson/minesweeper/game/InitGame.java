package eu.greyson.minesweeper.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class InitGame {
    private static final String mapsPath = "src/maps/";
    private static final String emptyFieldChars = "Oo";
    private static final String mineChars = "Xx";

    /** Load map and return game. */
    public static MineField loadGame(String fileName) throws IOException {
        return new MineField(readFieldFromFile(new File(mapsPath + fileName)));
    }

    /** Load map and return game. */
    public static MineField loadGame(File map) throws IOException {
        return new MineField(readFieldFromFile(map));
    }

    private static MineFieldPlan readFieldFromFile(File map) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(map))) {

            Set<Field> mineList = new HashSet<>();
            int sizeX = 0;
            int sizeY = 0;
            int y = 0;
            String line = br.readLine();
            while (line != null) {
                for (int x = 0; x < line.length(); x++) {
                    char ch = line.charAt(x);
                    if (mineChars.indexOf(ch) >= 0) {
                        mineList.add(new Field(x + MineField.MIN_POSITION, y + MineField.MIN_POSITION));
                    }

                    if (emptyFieldChars.indexOf(ch) >= 0 || mineChars.indexOf(ch) >= 0) {
                        if (sizeX < x) {
                            sizeX = x;
                        }
                        if (sizeY < y) {
                            sizeY = y;
                        }
                    }
                }

                line = br.readLine();
                y++;
            }

            //we have remembered the last valid position (starting from 0), map size is lastValidPosition+1
            sizeX += 1;
            sizeY += 1;

            System.out.println("Map loaded: " + sizeX + "x" + sizeY + ", " + mineList.size() + " mines");
            return new MineFieldPlan(sizeX, sizeY, mineList);
        }
    }
}
