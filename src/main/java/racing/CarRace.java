package racing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarRace {

	public static final int  MIN_JOIN_COUNT = 1;
	public static final int  MIN_RACE_COUNT = 1;

	private final List<Car> cars;
	private int raceCount;

	public CarRace(List<String> carNames, int raceCount) {
		validCars(carNames, raceCount);
		this.cars = setCars(carNames);
		this.raceCount = raceCount;
	}

	public void validCars(List<String> carNames, int raceCount) {
		if (carNames.size() < MIN_JOIN_COUNT) {
			throw new IllegalArgumentException("경주 참가 자동차 수는 " + MIN_JOIN_COUNT + "대 이상이어야 합니다.");
		}

		HashSet<String> carNameSet = new HashSet<>(carNames);
		if (carNameSet.size() != carNames.size()) {
			throw new IllegalArgumentException("중복된 참가 자동차 명이 존재합니다.");
		}

		if (raceCount < MIN_RACE_COUNT) {
			throw new IllegalArgumentException("최소 시도 횟수는 " + MIN_RACE_COUNT + "회 이상이어야 합니다.");
		}
	}

	private List<Car> setCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getRaceCount() {
		return raceCount;
	}

	public void race() {
		while (raceCount > 0) {
			raceCount--;
			driveCars();
		}
	}

	private void driveCars() {
		for (Car car : cars) {
			car.move(CounterUtil.randomCount());
		}
	}

	public List<String> getWinner() {
		List<String> winners = new ArrayList<>();
		int maxDistance = getMaxDistance();

		for (Car car : cars) {
			addWinner(winners, maxDistance, car);
		}
		return winners;
	}

	private int getMaxDistance() {
		int maxDistance = 0;
		for (Car car : cars) {
			maxDistance = Math.max(maxDistance, car.getDistance());
		}
		return maxDistance;
	}

	private void addWinner(List<String> winners, int maxDistance, Car car) {
		if (car.getDistance() == maxDistance) {
			winners.add(car.getName());
		}
	}


}
