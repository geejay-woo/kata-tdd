package kata.tdd.christmas_lights_kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class BulbGridTest {

    @Test
    public void should_0_0_to_999_999_one_level_when_turn_on() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnBulbsByRange(0, 0, 999, 999);

        // then
        assertThat(bulbGrid.getBrightLevel(0, 0)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(0, 999)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(999, 0)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(999, 999)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(500, 500)).isEqualTo(1);
        assertThat(bulbGrid.getTotalBrightLevel()).isEqualTo(1000_000);

    }

    @Test
    public void should_0_0_3_level_and_other_2_level_when_toggle_given_0_0_on_and_other_off() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnSingleBulb(0, 0);
        bulbGrid.toggleBulbsByRange(0, 0, 999, 0);

        // then
        assertThat(bulbGrid.getBrightLevel(0, 0)).isEqualTo(3);
        assertThat(bulbGrid.getBrightLevel(500, 0)).isEqualTo(2);
        assertThat(bulbGrid.getBrightLevel(999, 0)).isEqualTo(2);
        assertThat(bulbGrid.getTotalBrightLevel()).isEqualTo(2000 + 1);

    }

    @Test
    public void should_middle_four_bulbs_0_level_when_turn_off_bulbs_given_turn_off_499_499_500_500() {

        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnBulbsByRange(0, 0, 999, 999);
        bulbGrid.turnOffBulbsByRange(499, 499, 500, 500);

        // then
        assertThat(bulbGrid.getBrightLevel(0, 0)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(999, 0)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(0, 999)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(999, 999)).isEqualTo(1);
        assertThat(bulbGrid.getBrightLevel(499, 499)).isEqualTo(0);
        assertThat(bulbGrid.getBrightLevel(499, 500)).isEqualTo(0);
        assertThat(bulbGrid.getBrightLevel(500, 499)).isEqualTo(0);
        assertThat(bulbGrid.getBrightLevel(500, 500)).isEqualTo(0);
        assertThat(bulbGrid.getTotalBrightLevel()).isEqualTo(1000_000 - 4);
    }


    @Test
    public void should_get_0_brightness_level_when_turn_off() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1, 1);
        bulbGrid.turnOffBulbsByRange(0, 0, 0, 0);

        // then
        assertThat(bulbGrid.getTotalBrightLevel()).isEqualTo(0);
    }

    @Test
    public void should_get_right_brightness_when_instruct_given_instruct() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnBulbsByRange(0, 0, 0, 0);
        bulbGrid.toggleBulbsByRange(0, 0, 999, 999);

        // then
        assertThat(bulbGrid.getTotalBrightLevel()).isEqualTo(2000_000 + 1);
    }

}