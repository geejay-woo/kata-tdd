package kata.tdd.mars_rover_kata;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public enum Instruction {

    TURN_RIGHT(Rover::turnRight, 'r'),
    TURN_LEFT(Rover::turnLeft, 'l'),
    GO_FORWARD(Rover::goForward, 'f'),
    GO_BACKWARD(Rover::goBackward, 'b');

    Consumer<Rover> action;

    Character code;

    Instruction(Consumer<Rover> action, Character code) {
        this.action = action;
        this.code = code;
    }

    /**
     * getByCode
     * @param code
     * @return Instruction
     * null if not found by code
     */
    public static Instruction getByCode(Character code) {
        return Arrays.stream(Instruction.values())
                .filter(it-> Objects.equals(it.code, code))
                .findFirst()
                .orElse(null);
    }

    public Consumer<Rover> getAction() {
        return action;
    }

    public Character getCode() {
        return code;
    }
}
