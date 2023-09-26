package kata.tdd.mars_rover_kata;

import kata.tdd.mars_rover_kata.error.InstructCodeErrorException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Rover {
    private static final List<Direction> DIRECTION_LIST = List.of(Direction.WEST, Direction.NORTH, Direction.EAST, Direction.SOUTH);

    private static final Map<Direction, Consumer<Rover>> FORWARD_DIRECTION_MAP =
            Map.of(Direction.EAST, rover -> rover.setX((rover.getXIndex() + 1) % rover.getPerimeter()),
                    Direction.NORTH, rover -> rover.setY((rover.getYIndex() + 1) % rover.getPerimeter()),
                    Direction.WEST, rover -> rover.setX((rover.getXIndex() - 1) % rover.getPerimeter()),
                    Direction.SOUTH, rover -> rover.setY((rover.getYIndex() - 1) % rover.getPerimeter()));

    private static final Map<Direction, Consumer<Rover>> BACKWARD_DIRECTION_MAP =
            Map.of(Direction.EAST, rover -> rover.setX((rover.getXIndex() - 1) % rover.getPerimeter()),
                    Direction.NORTH, rover -> rover.setY((rover.getYIndex() - 1) % rover.getPerimeter()),
                    Direction.WEST, rover -> rover.setX((rover.getXIndex() + 1) % rover.getPerimeter()),
                    Direction.SOUTH, rover -> rover.setY((rover.getYIndex() + 1) % rover.getPerimeter()));

    private int perimeter;
    private int x;
    private int y;
    private Direction direction;

    /**
     * @param perimeter: 周长, 月球是个球体，走完周长则返回原点
     * @param x:         所在x轴坐标点
     * @param y:         所在y轴坐标点
     * @param direction: rover面向方向
     */
    public Rover(int perimeter, int x, int y, Direction direction) {
        this.perimeter = perimeter;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(char instruct) {
        Optional.ofNullable(Instruction.getByCode(instruct))
                .map(Optional::of)
                .orElseThrow(InstructCodeErrorException::new)
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

    public int getPerimeter() {
        return perimeter;
    }
}
