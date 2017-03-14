package eu.greyson.minesweeper.game;

public class Field {
    private int x;
    private int y;

    /**
     *
     * @param x X position
     * @param y Y position
     */
    public Field(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Get X position of the field
     * @return X position of the field
     */
    public int getX() {
        return x;
    }

    /**
     * Get Y position of the field
     * @return Y position of the field
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Field other = (Field) obj;
        return (this.x == other.x && this.y == other.y);

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
