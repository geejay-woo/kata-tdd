package kata.tdd.christmas_lights_kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class BulbGridTest {

    @Test
    public void should_turn_on_0_0_999_999_when_turn_on() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnBulbsByRange(0,0,999,999);

        // then
        assertThat(bulbGrid.isTurnOn(0,0)).isTrue();
        assertThat(bulbGrid.isTurnOn(999,0)).isTrue();
        assertThat(bulbGrid.isTurnOn(0,999)).isTrue();
        assertThat(bulbGrid.isTurnOn(999,999)).isTrue();
        assertThat(bulbGrid.isTurnOn(500,500)).isTrue();

    }

    @Test
    public void should_0_0_turn_off_and_other_turn_on_when_toggle_given_0_0_on_and_other_off() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnSingleBulb(0,0);
        bulbGrid.toggleBulbsByRange(0, 0, 999, 0);

        // then
        assertThat(bulbGrid.isTurnOff(0,0)).isTrue();
        assertThat(bulbGrid.isTurnOn(500,0)).isTrue();
        assertThat(bulbGrid.isTurnOn(999,0)).isTrue();

    }

    @Test
    public void should_turn_off_middle_four_bulbs_when_turn_off_bulbs_given_turn_off_499_499_500_500() {

        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnBulbsByRange(0,0,999,999);
        bulbGrid.turnOffBulbsByRange(499,499,500,500);

        // then
        assertThat(bulbGrid.isTurnOn(0, 0)).isTrue();
        assertThat(bulbGrid.isTurnOn(999, 0)).isTrue();
        assertThat(bulbGrid.isTurnOn(0, 999)).isTrue();
        assertThat(bulbGrid.isTurnOn(999, 999)).isTrue();
        assertThat(bulbGrid.isTurnOn(499, 499)).isFalse();
        assertThat(bulbGrid.isTurnOn(499, 500)).isFalse();
        assertThat(bulbGrid.isTurnOn(500, 499)).isFalse();
        assertThat(bulbGrid.isTurnOn(500, 500)).isFalse();
    }

    @Test
    public void should_get_right_turn_on_count() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOnBulbsByRange(887, 9, 959, 629);
        bulbGrid.turnOnBulbsByRange(454, 398, 844, 448);
        bulbGrid.turnOffBulbsByRange(539, 243, 559, 965);
        bulbGrid.turnOffBulbsByRange(370, 819, 676, 868);
        bulbGrid.turnOffBulbsByRange(145, 40, 370, 997);
        bulbGrid.turnOffBulbsByRange(301, 3, 808, 454);
        bulbGrid.turnOnBulbsByRange(351, 678, 951, 908);
        bulbGrid.toggleBulbsByRange(720, 196, 897, 994);
        bulbGrid.toggleBulbsByRange(831, 394, 904, 860);

        // then
        assertThat(bulbGrid.getTurnOnCount()).isEqualTo(230022);
    }

}