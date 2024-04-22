import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StringCalculatorLoggingTests {

    private Logger mockLogger;
    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        mockLogger = mock(Logger.class);
        calculator = new StringCalculator(mockLogger);
    }

    @Test
    public void testStringCalculatorDoesNotLogNumbersBelow1000(){
        calculator.add("");
        verify(mockLogger, never()).log(anyInt());
    }

    @Test
    public void testLoggerLogsNumbersAbove1000(){
        calculator.add("1001");
        verify(mockLogger, times(1)).log(1001);
    }
}
