package racing;

public class CarName {
	private static final int NAME_MIN_LIMIT = 1;
	private static final int NAME_MAX_LIMIT = 5;
	private final String name;

	public CarName(String name) {
		this.name = name;
	}

	public boolean valid() {
		if (name == null || name.trim().length() < NAME_MIN_LIMIT) {
			System.out.printf("자동차 이름은 %d자 이상이어야 합니다.\n", NAME_MIN_LIMIT);
			return false;
		}
		if (name.trim().length() > NAME_MAX_LIMIT) {
			System.out.printf("자동차 이름은 %d자를 초과할 수 없습니다.\n", NAME_MAX_LIMIT);
			return false;
		}
		return true;
	}
}
