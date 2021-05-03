package racing;

import java.util.Collections;

public class CarDistance {
	private int distance;

	public CarDistance() {
		new CarDistance(0);
	}

	public CarDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public void add(int distance) {
		this.distance += distance;
	}

	@Override
	public String toString() {
		return String.join("", Collections.nCopies(distance, "-"));
	}
}
