import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinDigitTest {

    private final MethodsForTesting methods = new MethodsForTesting();

    @DisplayName("Should to find min value")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}, min={2}")
    @CsvSource({
            "100,         1,          2,           1",
            "-2147483648, 2147483647, 0,          -2147483648",
            "50,          0,          2147483647,  0",
            "2147483647,  23,        -2147483648, -2147483648",
            "0,          -2147483648, 8890,       -2147483648"
    })
    void minDigit(int a, int b, int c, int expected) {
        assertEquals(expected, methods.minDigit(a, b, c));
    }
}
