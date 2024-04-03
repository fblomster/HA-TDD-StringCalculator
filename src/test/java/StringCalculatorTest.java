import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumberReturnsItself() {
        Assertions.assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbersSeparatedByComma() {
        Assertions.assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        Assertions.assertEquals(10, calculator.add("1,2,2,5"));
    }

    @Test
    public void testMultipleNumbersSeparatedByCommaOrNewLine() {
        Assertions.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        Assertions.assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testExceptionOnNegatives() {
            calculator.add("-1,-2,-3");
    }
}
