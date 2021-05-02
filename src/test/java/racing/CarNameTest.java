package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarNameTest {
    @ParameterizedTest
    @CsvSource(value = {"brown:true","r:true"}, delimiter = ':', nullValues={"null"})
    void 자동차_이름_생성_성공 (String name, boolean result) {
        assertThat(new CarName(name).getName()).isEqualTo(name);
    }

	@ParameterizedTest
	@CsvSource(value = {"'  ':false","null:false","purple:false"}, delimiter = ':', nullValues={"null"})
	void 자동차_이름_생성_실패 (String name, boolean result) {
		assertThatThrownBy(() -> {
			CarName carName = new CarName(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
