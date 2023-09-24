package kata.tdd.mars_rover_kata;

import java.util.List;

public class Rover {
    private static final List<Character> DIRECTION_LIST = List.of('W', 'N', 'E', 'S');

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
            Integer newDirectionIndex = (DIRECTION_LIST.indexOf(direction) + 1) % 4;
            this.direction = DIRECTION_LIST.get(newDirectionIndex);
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
