package racing;

public class CarName {
	private static final int MIN_NAME_LIMIT = 1;
	private static final int MAX_NAME_LIMIT = 5;

	private final String name;

	public CarName(String name) {
		valid(name);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void valid(String name) {
		if (name == null || name.trim().length() < MIN_NAME_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은" + MIN_NAME_LIMIT + "자 이상이어야 합니다");
		}
		if (name.trim().length() > MAX_NAME_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은" + MAX_NAME_LIMIT + "자를 초과할 수 없습니다.");
		}
	}

}
