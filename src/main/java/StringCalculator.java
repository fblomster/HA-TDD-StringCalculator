import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class StringCalculator {

    private final Logger logger;

    public StringCalculator(){
        logger = new LoggerStub();
    }

    public StringCalculator(Logger logger){
        this.logger = logger;
    }

            // TODO use your previous implementation, and include the tests too!
            public int add(String input) {
                // Check for empty input or "scalc ''"
                if (input.isEmpty() || input.equals("scalc ''")) {
                    return 0;
                }

                String delimiter = ",";

                // Handle "scalc" format
                if (input.startsWith("scalc '") && input.endsWith("'")) {
                    input = input.substring(7, input.length() - 1);// Remove "scalc '" and "'"
                } else if (input.startsWith("//")) {
                    // Custom delimiter specified
                    int delimiterIndex = input.indexOf("\n");
                    delimiter = input.substring(2, delimiterIndex);
                    input = input.substring(delimiterIndex + 1);
                }

                // Split the input using the delimiter pattern
                String[] nums = input.split("[\n" + Pattern.quote(delimiter) + "]");

                // Print the numbers after splitting
                System.out.println("Split numbers: " + Arrays.toString(nums));

                int sum = 0;
                List<String> negativeNumbers = new ArrayList<>();
                for (String num : nums) {
                    // Tar bort tomma strängar som replaceats med komma
                    if (!num.isEmpty()) {
                        int n = toInt(num);
                        if (n < 0) {
                            negativeNumbers.add(num);
                        }
                        sum += n;
                    }
                }

                // Log the sum if it's greater than 1000
                if (sum > 1000) {
                    logger.log(sum);
                }

                // Throw an exception for negative numbers
                if (!negativeNumbers.isEmpty()) {
                    throw new ArithmeticException("Negatives not allowed: " + String.join(", ", negativeNumbers));
                }

                return sum;
            }


    private static int toInt(String numbers) throws NumberFormatException {
        return Integer.parseInt(numbers);
    }
}
