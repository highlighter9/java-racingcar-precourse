package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class CarRaceTest {
	@Test
	void 경주_참가_자동차_목록_생성() {
		List<String> carNames = Arrays.asList(new String[] {"test1", "test2", "test3", "test4", "test5"});
		int raceCount = 10;
		CarRace carRace = new CarRace(carNames, raceCount);
		List<String> cars = carRace.getCars()
			.stream().map(Car::getName)
			.collect(Collectors.toList());
		System.out.println(cars);
		assertThat(cars).isEqualTo(carNames);
		assertThat(carRace.getRaceCount()).isEqualTo(raceCount);
	}

	@Test
	void 경주_참가_자동차_목록_중복체크() {
		List<String> carNames = Arrays.asList(new String[] {"test1", "test2", "test1", "test2", "test3"});
		int raceCount = 10;

		assertThatThrownBy(() -> {
			CarRace carRace = new CarRace(carNames, raceCount);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 경주_최소_참가_자동차수_미달() {
		List<String> carNames = Arrays.asList(new String[] {});
		int raceCount = 10;

		assertThatThrownBy(() -> {
			CarRace carRace = new CarRace(carNames, raceCount);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 경주_최소_시도_횟수_미달() {
		List<String> carNames = Arrays.asList(new String[] {"test1", "test2", "test1", "test2", "test3"});
		int raceCount = 0;

		assertThatThrownBy(() -> {
			CarRace carRace = new CarRace(carNames, raceCount);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 경주() {
		List<String> carNames = Arrays.asList(new String[] {"test1", "test2", "test3", "test4", "test5"});
		int raceCount = 10;
		CarRace carRace = new CarRace(carNames, raceCount);
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
