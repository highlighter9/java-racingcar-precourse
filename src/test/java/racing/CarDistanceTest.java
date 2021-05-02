package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarDistanceTest {
	@Test
	void 전진_판별() {
		int[] distances = {1, 0, 0, 2};
		int distanceSum = 0;
		CarDistance carDistance = new CarDistance();

		for (int distance : distances) {
			carDistance.add(distance);
			distanceSum += distance;
			assertThat(carDistance.getDistance()).isEqualTo(distanceSum);
		}
	}
}
