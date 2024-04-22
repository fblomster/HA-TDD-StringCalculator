import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final Logger logger;

    public StringCalculator(){
        logger = new LoggerStub();
    }

    public StringCalculator(Logger logger){
        this.logger = logger;
    }

        public int add(String input) {
            // TODO use your previous implementation, and include the tests too!
            // Check for empty input or "scalc ''"
            if (input.isEmpty() || input.equals("scalc ''")) {
                return 0;
            }

            // Custom delimiter
            String delimiter = ",";

            // Check if input is in the "scalc" format
            if (input.startsWith("scalc '") && input.endsWith("'")) {
                String expression = input.substring(7, input.length() - 1); // Remove "scalc '" and "'"
                String[] nums = expression.split("[,\n]");

                int sum = 0;
                List<String> negativeNumbers = new ArrayList<>();
                for (String num : nums) {
                    int n = toInt(num);
                    if (n < 0) {
                        negativeNumbers.add(num);
                    }
                    sum += n;
                }

                if (sum > 1000) {
                    logger.log(sum);
                }

                // Throw exception for negative numbers
                if (!negativeNumbers.isEmpty()) {
                    throw new ArithmeticException("Negatives not allowed: " + String.join(", ", negativeNumbers));
                }
                return sum;
            } else {
                // Regular input processing
                String[] nums = input.split("[\n" + delimiter + "]");

                int sum = 0;
                List<String> negativeNumbers = new ArrayList<>();
                for (String num : nums) {
                    int n = toInt(num);
                    if (n < 0) {
                        negativeNumbers.add(num);
                    }
                    sum += n;
                }

                if (sum > 1000) {
                    logger.log(sum);
                }

                // Throw exception for negative numbers
                if (!negativeNumbers.isEmpty()) {
                    throw new ArithmeticException("Negatives not allowed: " + String.join(", ", negativeNumbers));
                }
                return sum;
            }
        }


    private static int toInt(String numbers) throws NumberFormatException {
        return Integer.parseInt(numbers);
    }
}
