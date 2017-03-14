package eu.greyson.minesweeper.game;

/** Max time to execute is exceeded. */
public class TimeoutException extends Exception {
    public TimeoutException() {
        super("Vypršel časový limit");
    }
}
