package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

public class CounterUtilTest {

	@RepeatedTest(value = 100, name = "{currentRepetitions}/{totalRepetitions}" )
	void 랜덤카운터_반복() {
		assertThat(CounterUtil.randomCount()).matches(count -> count >= 0 && count <= 9);
	}
}
