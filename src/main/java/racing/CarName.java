package racing;

public class CarName {
	private static final int NAME_MIN_LIMIT = 1;
	private static final int NAME_MAX_LIMIT = 5;
	private final String name;

	public CarName(String name) {
		valid(name);
		this.name = name;

	}

	public String getName() {
		return this.name;
	}

	private void valid(String name) {
		if (name == null || name.trim().length() < NAME_MIN_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은" + NAME_MIN_LIMIT + "자 이상이어야 합니다");
		}
		if (name.trim().length() > NAME_MAX_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은" + NAME_MAX_LIMIT + "자를 초과할 수 없습니다.");
		}
	}

}
