import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringCalculatorCLI {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public StringCalculatorCLI(){
        inputStream = System.in;
        outputStream = System.out;
    }

    public StringCalculatorCLI(InputStream inputStream, OutputStream outputStream){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public void run() {
        Scanner scanner = new Scanner(inputStream);
        PrintStream out = new PrintStream(outputStream);

        //TODO print welcome message
        out.println("Welcome to String Calculator!");
        out.println("To use the calculator, enter 'scalc' followed by a string expression.");
        out.println("For example, type scalc '1,2,3' to calculate the sum of 1, 2, and 3.");
        out.println("Type 'exit' to quit the program.");

        StringCalculator calculator = new StringCalculator();
        // Loop until the user inputs "exit"
        while (true) {
            String input = scanner.nextLine(); // Read the next line of input

            // Check if the user wants to exit
            if ("exit".equalsIgnoreCase(input)) {
                break; // Exit the loop
            }

            // Avsluta loopen om input är tom
            if (input.isEmpty()) {
                break;
            }

            // Process the input
            //TODO Handle "scalc"-formatted string
            // Check if the input starts with "scalc"
            if (input.startsWith("scalc '") && input.endsWith("'")) {
                // Extract the expression from the input
                input = input.substring(7, input.length() - 1);// Remove "scalc 1" och "'"
                // Process the expression
                var result = calculator.add(input);
                // Print the result
                out.println("The result is " + result);
            } else {
                // Process the input as usual
                var result = calculator.add(input);

                out.println(result);
            }
        }

        scanner.close();
        out.println("Exiting...");

    }
}
