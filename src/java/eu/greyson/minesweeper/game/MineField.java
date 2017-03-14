package eu.greyson.minesweeper.game;

import java.util.*;

public class MineField {
    /**
     * Number of first position in the game plan (on X or Y axis)
     */
    static int MIN_POSITION = 1;

    private final MineFieldPlan mineFieldPlan;
    private final Score score;
    private final Set<Field> foundMines = new HashSet<>();
    private final Date created;


    MineField(MineFieldPlan mineFieldPlan) {
        this.mineFieldPlan = mineFieldPlan;
        this.score = new Score(mineFieldPlan);
        this.created = new Date();
    }

    /**
     * Reveal the mine. The goal is to reveal all mines in the game. There is a penalty for every wrong attempt (revealing position without a mine)
     * @param mine Mine position
     * @return True when there is a mine, False otherwise
     */
    public boolean revealMine(Field mine) throws TimeoutException {
        checkTimeout();
        boolean mineFound = mineFieldPlan.isMine(mine);
        if (mineFound) {
            if (!foundMines.contains(mine)) {
                foundMines.add(mine);
                score.incDiscoveredMines();
            }
        } else {
            score.incWrongGuesses();
        }
        return mineFound;
    }

    /**
     * Get distances from field position to every mine on the game plan (one distance for every mine, same number may occur multiple times)
     * @param field Field to count distances from
     * @return Sorted list with mine distances - one distance for every mine
     */
    public List<Integer> uncoverField(Field field) throws TimeoutException {
        checkTimeout();
        score.incUncoveredFields();
        return mineFieldPlan.countMineDistances(field);
    }

    /**
     * Get player's actual score
     * @return Player's score
     */
    public ScoreResult getScoreResult() throws TimeoutException {
        checkTimeout();
        return new ScoreResult(score);
    }

    /**
     * Returns minimal valid position on X axis
     * @return Minimal valid position on X axis
     */
    public int getMinX() throws TimeoutException {
        checkTimeout();
        return MIN_POSITION;
    }

    /**
     * Returns minimal valid position on Y axis
     * @return Minimal valid position on Y axis
     */
    public int getMinY() throws TimeoutException {
        checkTimeout();
        return MIN_POSITION;
    }

    /**
     * Returns maximal valid position on X axis
     * @return Maximal valid position on X axis
     */
    public int getMaxX() throws TimeoutException {
        checkTimeout();
        return mineFieldPlan.getMaxX();
    }

    /**
     * Returns maximal valid position on Y axis
     * @return Maximal valid position on Y axis
     */
    public int getMaxY() throws TimeoutException {
        checkTimeout();
        return mineFieldPlan.getMaxY();
    }

    /**
     * Returns number of mines in the game (both revealed and unrevealed)
     * @return Number of mines in the game (both revealed and unrevealed)
     */
    public int getNumberOfAllMines() throws TimeoutException {
        checkTimeout();
        return mineFieldPlan.getNumberOfMines();
    }

    /**
     * Calculate the distance between two positions
     * @param from Position to count distance from
     * @param to Position to count distance to
     * @return Distance between the two positions
     */
    public int getDistance(Field from, Field to) throws TimeoutException {
        checkTimeout();
        return MineFieldPlan.getDistance(from, to);
    }

    /** Check if max time to execute is exceeded. */
    private void checkTimeout() throws TimeoutException {
        if((new Date().getTime() - created.getTime()) > 30000) {
            throw new TimeoutException();
        }
    }

}
