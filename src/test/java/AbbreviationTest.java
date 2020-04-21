import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbbreviationTest {

    private final MethodsForTesting methods = new MethodsForTesting();

    @ParameterizedTest(name = "{index} => phrase={0}, abbreviation={1}")
    @DisplayName("Check abbreviations")
    @CsvSource({"Московский государственный университет, МГУ",
            "Санкт-Петербургский политехнический  университет, СПбПУ",
            "'', ''",
            "' ', ''",
            "'ты, я и наши друзья ...', ТЯНД"})
    void abbreviation(String input, String expected) {
        assertEquals(expected, methods.abbreviation(input));
    }
}
