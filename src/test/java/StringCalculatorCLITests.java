import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorCLITests {
    @Test
    public void testEmptyNumberString() {

        String input = "scalc ''\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());

    }

    @Test
    public void testStringCalculatorCLIPrintsWelcomeText() {
        // Förbered input och output streams
        String input = "exit\n"; // Simulerar användarens input
        String lineSeparator = System.lineSeparator(); // Hämta systemets radseparator
        String expectedOutput = "Welcome to String Calculator!" + lineSeparator +
                "To use the calculator, enter 'scalc' followed by a string expression." + lineSeparator +
                "For example, type 'scalc 1,2,3' to calculate the sum of 1, 2, and 3." + lineSeparator +
                "Type 'exit' to quit the program." + lineSeparator +
                "Exiting..." + lineSeparator; // Förväntad output

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Sparar den gamla System.in och System.out
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        try {
            // Byt ut System.in och System.out med våra streams
            System.setIn(inputStream);
            System.setOut(printStream);

            // Kör StringCalculatorCLI
            StringCalculatorCLI cli = new StringCalculatorCLI();
            cli.run();

            // Hämta den faktiska outputen från outputStream
            String actualOutput = outputStream.toString();

            // Jämför den faktiska outputen med den förväntade
            assertEquals(expectedOutput, actualOutput);
        } finally {
            // Återställ System.in och System.out till de tidigare värdena
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

}