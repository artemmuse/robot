public class Robot {
    private int x;
    private int y;
    private Direction dir;

    public Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        if (dir == Direction.UP) {
            dir = Direction.LEFT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.DOWN;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.UP;
        }
    }

    public void turnRight() {
        if (dir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
        }
    }

    public void stepForward() {
        if (dir == Direction.UP) {
            y++;
        }
        if (dir == Direction.DOWN) {
            y--;
        }
        if (dir == Direction.LEFT) {
            x--;
        }
        if (dir == Direction.RIGHT) {
            x++;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int xRelative = toX - robot.getX();
        int yRelative = toY - robot.getY();

        if (xRelative > 0) {
            turnToDirection(robot, Direction.RIGHT);
        } else if (xRelative < 0) {
            turnToDirection(robot, Direction.LEFT);
        }

        for (int i = 0; i < Math.abs(xRelative); i++)
            robot.stepForward();

        if (yRelative > 0) {
            turnToDirection(robot, Direction.UP);
        } else if (yRelative < 0) {
            turnToDirection(robot, Direction.DOWN);
        }

        for (int i = 0; i < Math.abs(yRelative); i++)
            robot.stepForward();
    }

    public static void turnToDirection(Robot robot, Direction dir) {
        while (dir != robot.getDirection())
            robot.turnRight();
    }
}