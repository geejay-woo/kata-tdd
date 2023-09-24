package kata.tdd.mars_rover_kata;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Rover {
    private static final List<Direction> DIRECTION_LIST = List.of(Direction.WEST, Direction.NORTH, Direction.EAST, Direction.SOUTH);

    private static final Map<Direction, Consumer<Rover>> FORWARD_DIRECTION_MAP =
            Map.of(Direction.EAST, rover -> rover.setX(rover.getXIndex() + 1),
                    Direction.NORTH, rover -> rover.setY(rover.getYIndex() + 1),
                    Direction.WEST, rover -> rover.setX(rover.getXIndex() - 1),
                    Direction.SOUTH, rover -> rover.setY(rover.getYIndex() - 1));

    private static final Map<Direction, Consumer<Rover>> BACKWARD_DIRECTION_MAP =
            Map.of(Direction.EAST, rover -> rover.setX(rover.getXIndex() - 1),
                    Direction.NORTH, rover -> rover.setY(rover.getYIndex() - 1),
                    Direction.WEST, rover -> rover.setX(rover.getXIndex() + 1),
                    Direction.SOUTH, rover -> rover.setY(rover.getYIndex() + 1));

    private int x;
    private int y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(char instruct) {
        Optional.ofNullable(Instruction.getByCode(instruct))
                .map(Optional::of)
                .orElseThrow(RuntimeException::new)
                .ifPresent(ins -> ins.getAction().accept(this));
    }

    public void goBackward() {
        BACKWARD_DIRECTION_MAP.get(this.getDirection()).accept(this);
    }

    public void goForward() {
        FORWARD_DIRECTION_MAP.get(this.getDirection()).accept(this);
    }

    public void turnLeft() {
        modifyDirection(index -> index - 1);
    }

    public void turnRight() {
        modifyDirection(index -> index + 1);
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
