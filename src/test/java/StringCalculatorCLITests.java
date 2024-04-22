import org.junit.jupiter.api.Test;

import java.io.*;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorCLITests {
    @Test
    public void testSumOfNumbers() {

        boolean isFirstRun = true;

        String input = "scalc '1,2,3'\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertEquals("Welcome to String Calculator!\n" +
                "To use the calculator, enter 'scalc' followed by a string expression.\n" +
                "For example, type scalc '1,2,3' to calculate the sum of 1, 2, and 3.\n" +
                "Type 'exit' to quit the program.\nThe result is 6\nExiting...\n", outputStream.toString());
    }

   /* @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());

    }*/

    @Test
    public void testPrintingWelcomeText() {
        String input = "exit\n"; //
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "Welcome to String Calculator!" + lineSeparator +
                "To use the calculator, enter 'scalc' followed by a string expression." + lineSeparator +
                "For example, type scalc '1,2,3' to calculate the sum of 1, 2, and 3." + lineSeparator +
                "Type 'exit' to quit the program." + lineSeparator +
                "Exiting..." + lineSeparator;

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        InputStream oldIn = System.in;
        PrintStream oldOut = out;

        try {
            System.setIn(inputStream);
            System.setOut(printStream);

            StringCalculatorCLI cli = new StringCalculatorCLI();
            cli.run();

            String actualOutput = outputStream.toString();

            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

}