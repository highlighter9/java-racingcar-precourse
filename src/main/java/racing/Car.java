package racing;

public class Car {

	private final CarName carName;
	private final CarDistance carDistance;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance();
	}

	public String getName() {
		return this.carName.getName();
	}

	public int getDistance() {
		return this.carDistance.getDistance();
	}

	public void move(int count) {
		int distance = MoveStatus.getMoveStatus(count).distance;
		carDistance.add(distance);
	}
}
