package demolition;


public abstract class Displayable {
    protected int x;
    protected int y;

    /**
     * Class constructor.
     *
     * Creates new Displayable at (x,y) coordinates
     * @param x     the x-coordinate of the Displayable created
     * @param y     the y-coordinate of the Displayable created
     */
    public Displayable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws displayable to the application window
     * @param app   the application that is drawn to
     */
    public abstract void draw(App app);

    /**
     * Returns the x-coordinate of Displayable
     * @return the x-coordinate of the Displayable
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of Displayable
     * @return the y-coordinate of the Displayable
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate as the input value
     * @param y     the new y-coordinate value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the x coordinate as the input value
     * @param x     the new x-coordinate value
     */
    public void setX(int x) {
        this.x = x;
    }
}
