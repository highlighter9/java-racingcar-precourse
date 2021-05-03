package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRaceTest {
	List<String> carNames;
	List<Car> cars;
	int raceCount;

	List<Car> setCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}

	@BeforeEach
	void setUp() {
		raceCount = 10;
		carNames = Arrays.asList(new String[] {"test1", "test2", "test3", "test4", "test5"});
		cars = setCars(carNames);
	}



	@Test
	void 자동차경주_초기생성() {
		CarRace carRace = new CarRace(cars, raceCount);
		assertThat(carRace.getCars()).isEqualTo(cars);
		assertThat(carRace.getRaceCount()).isEqualTo(raceCount);
	}

	@Test
	void 자동차경주_최소_참가_자동차수_미달() {
		carNames = Arrays.asList(new String[] {});
		cars = setCars(carNames);
		int raceCount = 10;

		assertThatThrownBy(() ->
			new CarRace(cars, raceCount)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 자동차경주_최소_시도_횟수_미달() {
		int raceCount = 0;

		assertThatThrownBy(() ->
			new CarRace(cars, raceCount)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 경주() {
		CarRace carRace = new CarRace(cars, raceCount);
		int maxDistance = 0;
		carRace.race();
		List<String> winners = new ArrayList<>();

		for(Car car : carRace.getCars()) {
			if(maxDistance == car.getDistance()) {
				winners.add(car.getName());
			}
			if (maxDistance < car.getDistance()) {
				maxDistance = car.getDistance();
				winners.clear();
				winners.add(car.getName());
			}

		}
		assertThat(carRace.getWinner()).isEqualTo(winners);
	}
}
