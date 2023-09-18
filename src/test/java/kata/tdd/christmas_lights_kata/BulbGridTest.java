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

}