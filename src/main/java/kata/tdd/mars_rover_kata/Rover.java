package kata.tdd.mars_rover_kata;

public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(char instruct) {
        if (instruct == 'r') {
            direction = 'E';
        }
    }

    public int getXIndex() {
        return this.x;
    }

    public int getYIndex() {
        return this.y;
    }

    public char getDirection() {
        return this.direction;
    }
}
