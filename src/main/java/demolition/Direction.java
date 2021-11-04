package demolition;

import java.util.Random;

/**
 * Direction enum, provides 4 direction static states LEFT, RIGHT, UP, DOWN for moveables
 */
public enum Direction {
    /**
     * The direction pointing to the West of the window (Decreasing x values)
     */
    LEFT {

      /**
     * Returns the direction clockwise from the direction that the method is called on
     * @return    UP direction
     */
      @Override
      public Direction turn() { return UP;}
    },

    /**
     * The direction pointing to the East of the window (Increasing x values)
     */
    RIGHT{

    /**
     * Returns the direction clockwise from the direction that the method is called on
     * @return    DOWN direction
     */
      @Override
      public Direction turn() { return DOWN;}
    },

    /**
     * The direction pointing to the North of the window (Decreasing y values)
     */
    UP{

     /**
     * Returns the direction clockwise from the direction that the method is called on
     * @return    RIGHT direction
     */
      @Override
      public Direction turn() { return RIGHT;}
    },

    /**
     * The direction pointing to the South of the window (Increasing y values)
     */
    DOWN{

     /**
     * Returns the direction clockwise from the direction that the method is called on
     * @return    LEFT direction
     */
      @Override
      public Direction turn() { return LEFT;}
    };

    private static final Direction[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    /**
     * Returns a random Direction
     * @return a random direction
     */
    public static Direction getRandomDirection()  {
      return VALUES[RANDOM.nextInt(SIZE)];
    }

    /**
     * Returns the direction clockwise from the direction that the method is called on
     * @return the direction clockwise from the current direction
     */
    public Direction turn() {
        return null;
    }

}
