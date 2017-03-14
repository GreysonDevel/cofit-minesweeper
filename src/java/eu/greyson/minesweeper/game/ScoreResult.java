package eu.greyson.minesweeper.game;

public class ScoreResult {
    private Score score;

    ScoreResult(Score score) {
        this.score = score;
    }

    public int getWrongGuesses() {
        return score.getWrongGuesses();
    }

    public int getRevealedMines() {
        return score.getRevealedMines();
    }

    public int getUncoveredFields() {
        return score.getUncoveredFields();
    }

    public int getNumberOfMines() {
        return score.getNumberOfMines();
    }

    public long getScore() {
        return score.getScore();
    }

    public void printScore() {
        System.out.println("-----------------------------------");
        System.out.println("YOUR SCORE:");
        System.out.println("Score: " + score.getScore());
        System.out.println("Discovered mines: " + score.getRevealedMines() + "/" + score.getNumberOfMines());
        System.out.println("Uncovered fields: " + score.getUncoveredFields());
        System.out.println("Wrong guesses: " + score.getWrongGuesses());
    }
}
