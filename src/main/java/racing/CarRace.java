package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
	public static final int  MIN_JOIN_COUNT = 1;
	public static final int  MIN_RACE_COUNT = 1;

	private final List<Car> cars;
	private int raceCount;

	public CarRace(List<Car> cars, int raceCount) {
		valid(cars, raceCount);
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getRaceCount() {
		return raceCount;
	}

	public void valid(List<Car> cars, int raceCount) {
		if (cars.size() < MIN_JOIN_COUNT) {
			throw new IllegalArgumentException("경주 참가 자동차 수는 " + MIN_JOIN_COUNT + "대 이상이어야 합니다.");
		}

		if (raceCount < MIN_RACE_COUNT) {
			throw new IllegalArgumentException("최소 시도 횟수는 " + MIN_RACE_COUNT + "회 이상이어야 합니다.");
		}
	}

	public void race() {
		for (int i = 0; i < raceCount; i++) {
			driveCars();
		}
	}

	private void driveCars() {
		for (Car car : cars) {
			car.move(CounterUtil.randomCount());
			reportCar(car);
		}
		System.out.println();
	}

	private void reportCar(Car car) {
		System.out.println(car.getName() + ":" + car.getDistanceStr());
	}

	public List<String> getWinner() {
		List<String> winners = new ArrayList<>();
		int maxDistance = getMaxDistance();

		for (Car car : cars) {
			addWinner(winners, maxDistance, car);
		}

		System.out.println(winners + "가 최종 우승했습니다.");
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
