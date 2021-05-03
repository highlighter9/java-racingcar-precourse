package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameMaker {
	public void startNewGame() {
		System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분");
		Scanner sc = new Scanner(System.in);
		String inputCarNames = sc.next();

		System.out.println("시도할 회수는 몇회인가요?");
		sc = new Scanner(System.in);
		int inputRaceCount = sc.nextInt();
		startRace(inputCarNames, inputRaceCount);
	}

	private void startRace(String inputCarNames, int inputRaceCount) {
		try {
			CarRace carRace = new CarRace(setCars(Arrays.asList(inputCarNames.split(","))), inputRaceCount);
			carRace.race();
			carRace.getWinner();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private List<Car> setCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}
}
