package racing;

public enum MoveStatus {
	STOP(0), GO(1);

	public static final int MOVE_CHECK_COUNT = 5;
	public final int distance;

	MoveStatus(int distance) {
		this.distance = distance;
	}

	public static MoveStatus getMoveStatus(int count) {
		return count < MOVE_CHECK_COUNT ? STOP : GO;
	}
}
