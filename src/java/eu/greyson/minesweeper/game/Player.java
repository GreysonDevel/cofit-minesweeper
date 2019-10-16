package eu.greyson.minesweeper.game;

public abstract class Player extends Thread {
    protected final MineField game;

    protected Player(MineField game) {
        this.game = game;
    }

    public abstract void findMines() throws TimeoutException;

    @Override
    public void run() {
        try {
            findMines();
        } catch (TimeoutException e) {
            stop();
        }
    }
}
