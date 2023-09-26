package kata.tdd.mars_rover_kata;

import kata.tdd.mars_rover_kata.error.BarrierBlockException;
import kata.tdd.mars_rover_kata.error.InstructCodeErrorException;

import java.util.*;
import java.util.function.Function;

public class Rover {
    private static final List<Direction> DIRECTION_LIST = List.of(Direction.WEST, Direction.NORTH, Direction.EAST, Direction.SOUTH);

    private static final Map<Direction, Function<Rover, Coordinate>> FORWARD_DIRECTION_MAP =
            Map.of(Direction.EAST, rover -> new Coordinate((rover.getXIndex() + rover.getPerimeter() + 1) % rover.getPerimeter(), rover.getYIndex()),
                    Direction.NORTH, rover -> new Coordinate(rover.getXIndex(), (rover.getYIndex() + rover.getPerimeter() + 1) % rover.getPerimeter()),
                    Direction.WEST, rover -> new Coordinate((rover.getXIndex() + rover.getPerimeter() - 1) % rover.getPerimeter(), rover.getYIndex()),
                    Direction.SOUTH, rover -> new Coordinate(rover.getXIndex(), (rover.getYIndex() + rover.getPerimeter() - 1) % rover.getPerimeter()));

    private static final Map<Direction, Function<Rover, Coordinate>> BACKWARD_DIRECTION_MAP =
            Map.of(Direction.EAST, rover -> new Coordinate((rover.getXIndex() + rover.getPerimeter() - 1) % rover.getPerimeter(), rover.getYIndex()),
                    Direction.NORTH, rover -> new Coordinate(rover.getXIndex(), (rover.getYIndex() + rover.getPerimeter() - 1) % rover.getPerimeter()),
                    Direction.WEST, rover -> new Coordinate((rover.getXIndex() + rover.getPerimeter() + 1) % rover.getPerimeter(), rover.getYIndex()),
                    Direction.SOUTH, rover -> new Coordinate(rover.getXIndex(), (rover.getYIndex() + rover.getPerimeter() + 1) % rover.getPerimeter()));

    private int perimeter;
    private int x;
    private int y;
    private Direction direction;
    private Set<Coordinate> barrierList = new HashSet<>();

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
        go(direction-> BACKWARD_DIRECTION_MAP.get(direction).apply(this));

    }

    public void goForward() {
        go(direction-> FORWARD_DIRECTION_MAP.get(direction).apply(this));
    }

    private void go(Function<Direction, Coordinate> coordinateGetter) {
        Coordinate nextPosition = coordinateGetter.apply(this.getDirection());
        if (hasBarrierAtTarget(nextPosition)) {
            throw new BarrierBlockException(String.format("blocked at (%d,%d), barrier position: (%d,%d)", this.x, this.y, nextPosition.getX(), nextPosition.getY()));
        }
        moveTo(nextPosition);
    }

    private void moveTo(Coordinate position) {
        this.x = position.getX();
        this.y = position.getY();
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

    public void setBarrierByPosition(int x, int y) {
        this.barrierList.add(new Coordinate(x, y));
    }

    public boolean hasBarrierAtTarget(Coordinate position) {
        return barrierList.contains(position);
    }
}
