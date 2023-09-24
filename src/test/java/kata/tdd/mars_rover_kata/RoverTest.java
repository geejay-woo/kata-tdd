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
        Rover rover = new Rover(0, 0, 'N');
        rover.execute('r');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo('E');
    }

    @Test
    public void should_get_north_direction_when_face_west_given_r_command() {
        // given

        // when
        Rover rover = new Rover(0, 0, 'W');
        rover.execute('r');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo('N');
    }

    @Test
    public void should_get_west_direction_when_face_north_given_l_command() {
        // given

        // when
        Rover rover = new Rover(0, 0, 'N');
        rover.execute('l');

        // then
        assertThat(rover.getXIndex()).isEqualTo(0);
        assertThat(rover.getYIndex()).isEqualTo(0);
        assertThat(rover.getDirection()).isEqualTo('W');
    }

}