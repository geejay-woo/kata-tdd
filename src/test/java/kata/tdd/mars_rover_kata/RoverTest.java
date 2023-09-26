package kata.tdd.mars_rover_kata;

import kata.tdd.mars_rover_kata.error.BarrierBlockException;
import kata.tdd.mars_rover_kata.error.InstructCodeErrorException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


/**
 * tasks:
 * 1, 执行转向指令
 * 2，执行移动指令
 * 3，碰到障碍物终止序列
 */
public class RoverTest {
    @Test
    public void should_get_east_direction_when_face_north_given_r_command() {
        // given

        // when
        Rover rover = new Rover(4, 0, 0, Direction.NORTH);
        rover.execute('r');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_get_north_direction_when_face_west_given_r_command() {
        // given

        // when
        Rover rover = new Rover(4, 0, 0, Direction.WEST);
        rover.execute('r');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_get_west_direction_when_face_north_given_l_command() {
        // given

        // when
        Rover rover = new Rover(4, 0, 0, Direction.NORTH);
        rover.execute('l');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_get_1_0_position_when_f_given_face_east_at_0_0() {
        // given

        // when
        Rover rover = new Rover(4, 0, 0, Direction.EAST);
        rover.execute('f');

        // then
        assertThat(rover.getXIndex()).isEqualTo(1);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_get_1_0_when_forward_given_face_south_and_at_1_1() {
        // given

        // when
        Rover rover = new Rover(4, 1, 1, Direction.SOUTH);
        rover.execute('f');

        // then
        assertThat(rover.getXIndex()).isEqualTo(1);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void should_get_1_2_when_backward_given_face_south_and_at_1_1() {
        // given

        // when
        Rover rover = new Rover(4, 1, 1, Direction.SOUTH);
        rover.execute('b');

        // then
        assertThat(rover.getXIndex()).isEqualTo(1);
        assertThat(rover.getYIndex()).isEqualTo(2);
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void should_get_instruct_code_error_exception_when_execute_a_given_error_code() {
        // given

        // when
        Rover rover = new Rover(4, 0, 0, Direction.NORTH);
        Throwable throwable = catchThrowable(() -> rover.execute('g'));

        // then
        assertThat(throwable).isInstanceOf(InstructCodeErrorException.class);
    }

    @Test
    public void should_get_0_4_when_go_forward_given_at_4_4_position_and_face_east() {
        // given

        // when
        Rover rover = new Rover(5,4, 4, Direction.EAST);
        rover.execute('f');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(4);
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_get_4_4_when_go_forward_given_at_0_4_position_and_face_west() {
        // given

        // when
        Rover rover = new Rover(5,0, 4, Direction.WEST);
        rover.execute('f');

        // then
        assertThat(rover.getXIndex()).isEqualTo(4);
        assertThat(rover.getYIndex()).isEqualTo(4);
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_get_exception_report_1_0_has_barrier_when_go_forward_given_at_0_0_face_east() {
        // given

        // when
        Rover rover = new Rover(5, 0, 0, Direction.EAST);
        Throwable throwable = catchThrowable(() -> rover.execute('f'));

        // then
        assertThat(throwable).isInstanceOf(BarrierBlockException.class);
        assertThat(throwable).hasMessage("blocked at (0,0), barrier position: (1,0)");

    }

}