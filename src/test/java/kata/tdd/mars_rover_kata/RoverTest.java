package kata.tdd.mars_rover_kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


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
        Rover rover = new Rover(0, 0, Direction.NORTH);
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
        Rover rover = new Rover(0, 0, Direction.WEST);
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
        Rover rover = new Rover(0, 0, Direction.NORTH);
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
        Rover rover = new Rover(0, 0, Direction.EAST);
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
        Rover rover = new Rover(1, 1, Direction.SOUTH);
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
        Rover rover = new Rover(1, 1, Direction.SOUTH);
        rover.execute('b');

        // then
        assertThat(rover.getXIndex()).isEqualTo(1);
        assertThat(rover.getYIndex()).isEqualTo(2);
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

}