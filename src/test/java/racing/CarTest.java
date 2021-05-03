package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    @Test
	void 자동차_초기생성 () {
    	String name = "test";
    	Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getDistance()).isEqualTo(0);
    }

	@Test
	void 자동차_초기생성_실패 () {
		String name = "testcar";
		assertThatThrownBy(() -> {
			Car car = new Car(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:1", "9:1", "3:0", "0:0"}, delimiter = ':')
	void 자동차_이동(int count, int distance) {
		String name = "test";
		Car car = new Car(name);
		car.move(count);
		assertThat(car.getDistance()).isEqualTo(distance);
	}
}
