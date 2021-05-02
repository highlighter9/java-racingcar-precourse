package racing;

public class Car {

	private CarName carName;
	private CarDistance carDistance;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance();
	}

	public Car(String name, int distance) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance(distance);
	}

	public String getName() {
		return this.carName.getName();
	}

	public int getDistance() {
		return this.carDistance.getDistance();
	}
}
