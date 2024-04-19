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

        if (input.isEmpty()) {
            return 0;
        }

        //custom delimiter
        String delimiter = ",";

        //checkar av vilken delimiter som kommer efter // och omvandlar till custom delimiter och splittar
        /*if (input.startsWith("scalc ")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(6, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }*/
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }


        //String[] nums = input.split("[,\n;]");
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

        // exception om negativa siffror
        if (!negativeNumbers.isEmpty()) {
            throw new ArithmeticException("Negatives not allowed: " + String.join(", ", negativeNumbers));
        }
        return sum;
        }

    private static int toInt(String numbers) throws NumberFormatException {
        return Integer.parseInt(numbers);
    }
}
