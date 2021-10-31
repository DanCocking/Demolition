package demolition;

import java.util.Random;


public enum Direction {
    left {
      @Override
      public Direction turn() { return up;}
    },
    right{
      @Override
      public Direction turn() { return down;}
    },
    up{
      @Override
      public Direction turn() { return right;}
    },

    down{
      @Override
      public Direction turn() { return left;}
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
