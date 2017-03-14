package eu.greyson.minesweeper.game;

import java.util.*;

class MineFieldPlan {
    private int maxX;
    private int maxY;
    private Set<Field> mines;

    /**
     *
     * @param maxX Maximal valid X position on the plan
     * @param maxY Maximal valid Y position on the plan
     * @param mines Set of all mines
     */
    MineFieldPlan(int maxX, int maxY, Set<Field> mines) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.mines = mines;
    }

    /**
     * Returns whether there is a mine on selected position
     * @param position Selected position
     * @return True when there is a mine on the position, False otherwise
     */
    boolean isMine(Field position) {
        return mines.contains(position);
    }

    /**
     * Returns sorted list of distances from selected field to every mine on the plan. One number may occur multiple times when more mines have the same distance
     * @param field Field to count distances from
     * @return Sorted list of distances from selected field to every mine on the plan
     */
    List<Integer> countMineDistances(Field field) {
        ArrayList<Integer> mineDistances = new ArrayList<>();

        for (Field mine : mines) {
            mineDistances.add(getDistance(field, mine));
        }

        Collections.sort(mineDistances);

        return mineDistances;
    }

    /**
     * Get maximal valid X position on the plan
     * @return Maximal valid X position on the plan
     */
    int getMaxX() {
        return maxX;
    }

    /**
     * Get maximal valid Y position on the plan
     * @return Maximal valid Y position on the plan
     */
    int getMaxY() {
        return maxY;
    }

    /**
     * Get number of mines on the plan
     * @return Number of mines on the plan
     */
    int getNumberOfMines() {
        return mines.size();
    }

    /**
     * Calculate the distance between two positions
     * @param from Position to count distance from
     * @param to Position to count distance to
     * @return Distance between the two positions
     */
    static int getDistance(Field from, Field to) {
        int distance = 0;
        distance += Math.abs(from.getX() - to.getX());
        distance += Math.abs(from.getY() - to.getY());
        return distance;
    }
}
