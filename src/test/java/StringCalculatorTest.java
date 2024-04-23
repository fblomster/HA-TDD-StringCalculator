import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumberReturnsItself() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbersSeparatedByComma() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(10, calculator.add("1,2,2,5"));
    }

    @Test
    public void testMultipleNumbersSeparatedByCommaOrNewLine() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    //@Test
    //public void testExceptionOnNegatives() {
     //       calculator.add("-1,-2,-3");
    //}

    @Test
    public void testExceptionOnNegatives2() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.add("-1,-2,-3"));
        assertEquals("Negatives not allowed: -1, -2, -3", exception.getMessage());
    }

    @Test
    public void testCustomDelimiter2() {
        assertEquals(6, calculator.add("//#\n1#2#3"));
    }

    @Test
    public void testDelimiters() {
        assertEquals(7, calculator.add("//[***][%%%]\n1***2%%%4"));
    }
}
