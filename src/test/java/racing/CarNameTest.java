package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 자동차_이름_유효성() {
        assertThat(CarName.valid("brown")).isTrue();
        assertThat(CarName.valid("r")).isTrue();
        assertThat(CarName.valid("")).isFalse();
        assertThat(CarName.valid(null)).isFalse();
        assertThat(CarName.valid("purple")).isFalse();
    }
}
