package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
}
