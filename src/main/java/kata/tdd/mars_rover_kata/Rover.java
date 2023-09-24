package kata.tdd.mars_rover_kata;

import java.util.List;
import java.util.function.Function;

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
            modifyDirection(index -> index + 1);
        }
        if (instruct == 'l') {
            modifyDirection(index -> index - 1);
        }
    }

    private void modifyDirection(Function<Integer, Integer> newDirectionIndexGetter) {
        Integer newDirectionIndex = newDirectionIndexGetter.apply(DIRECTION_LIST.indexOf(direction)) % 4;
        this.direction = DIRECTION_LIST.get(newDirectionIndex);
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
