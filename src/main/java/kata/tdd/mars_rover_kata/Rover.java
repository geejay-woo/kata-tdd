package kata.tdd.mars_rover_kata;

import java.util.List;
import java.util.function.Function;

public class Rover {
    private static final List<Direction> DIRECTION_LIST = List.of(Direction.WEST, Direction.NORTH, Direction.EAST, Direction.SOUTH);

    private int x;
    private int y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
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
        if (instruct == 'f') {
            if (this.direction == Direction.EAST) {
                this.x = this.x + 1;
            }
            // Rover执行指令, 指令被解析from,
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

    public Direction getDirection() {
        return this.direction;
    }
}
