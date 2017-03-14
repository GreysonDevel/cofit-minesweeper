package eu.greyson.minesweeper.game;

class Score {
    private static int SCORE_WRONG_GUESS = 10;
    private static int SCORE_UNCOVERED_FIELD = 1;

    private static long SCORE_COEFFICIENT = 20;

    private MineFieldPlan plan;
    private int wrongGuesses = 0;
    private int revealedMines = 0;
    private int uncoveredFields = 0;

    Score(MineFieldPlan plan) {
        this.plan = plan;
    }

    void incWrongGuesses() {
        if (wrongGuesses < Integer.MAX_VALUE) {
            wrongGuesses++;
        }
    }

    void incDiscoveredMines() {
        revealedMines++;
    }

    void incUncoveredFields() {
        if (uncoveredFields < Integer.MAX_VALUE) {
            uncoveredFields++;
        }
    }

    int getWrongGuesses() {
        return wrongGuesses;
    }

    int getRevealedMines() {
        return revealedMines;
    }

    int getUncoveredFields() {
        return uncoveredFields;
    }

    int getNumberOfMines() {
        return plan.getNumberOfMines();
    }

    long getMaxScore() {
        return SCORE_COEFFICIENT * (plan.getMaxX() + plan.getMaxY());
    }

    long getScore() {
        long score = (long)((getMaxScore() - SCORE_UNCOVERED_FIELD * uncoveredFields - SCORE_WRONG_GUESS * wrongGuesses)
                * (revealedMines * 1.0 / plan.getNumberOfMines()));
        int zeroScore = ((getRevealedMines() == getNumberOfMines()) ? revealedMines : 0);
        return Math.max(zeroScore, score);
    }
}
