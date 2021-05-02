package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarNameTest {
    @ParameterizedTest
    @CsvSource(value = {"brown:true","r:true","'  ':false","null:false","purple:false"}, delimiter = ':', nullValues={"null"})
    void 자동차_이름_유효성 (String name, boolean result) {
        assertThat(new CarName(name).valid()).isEqualTo(result);
    }
}
