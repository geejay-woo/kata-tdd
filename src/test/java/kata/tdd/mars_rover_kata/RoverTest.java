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

}