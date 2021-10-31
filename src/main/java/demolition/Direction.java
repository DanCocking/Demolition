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

    public static Direction getRandomDirection()  {
      return VALUES[RANDOM.nextInt(SIZE)];
    }

    public Direction turn() {
        return null;
    }

}
