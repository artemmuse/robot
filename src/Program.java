public class Program {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        Robot.moveRobot(robot, -10, 20);
    }
}