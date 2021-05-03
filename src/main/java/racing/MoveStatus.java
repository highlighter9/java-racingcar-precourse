package racing;

public enum MoveStatus {
	STOP(0), GO(1);

	private static final int MOVE_CHECK_COUNT = 4;
	private final int distance;

	MoveStatus(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public static MoveStatus getMoveStatus(int count) {
		return count < MOVE_CHECK_COUNT ? STOP : GO;
	}

}
