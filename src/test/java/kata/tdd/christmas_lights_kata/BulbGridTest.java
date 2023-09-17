package kata.tdd.christmas_lights_kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class BulbGridTest {

    @Test
    public void should_turn_on_0_0_999_999_when_turn_on() {
        // given

        // when
        BulbGrid bulbGrid = new BulbGrid(1000, 1000);
        bulbGrid.turnOn(0,0,999,999);

        // then
        assertThat(bulbGrid.isTurnOn(0,0)).isTrue();
        assertThat(bulbGrid.isTurnOn(999,0)).isTrue();
        assertThat(bulbGrid.isTurnOn(0,999)).isTrue();
        assertThat(bulbGrid.isTurnOn(999,999)).isTrue();
        assertThat(bulbGrid.isTurnOn(500,500)).isTrue();

    }

}