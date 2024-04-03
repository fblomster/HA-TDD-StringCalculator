import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        //custom delimiter
        String delimiter = ",";

        //checkar av vilken delimiter som kommer efter // och omvandlar till custom delimiter och splittar
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] nums = numbers.split("[,\n;]");
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<>();
        for (String num : nums) {
            int n = toInt(num);
            if (n < 0) {
                negativeNumbers.add(num);
            }
            sum += n;
        }

        // Throw exception if negative numbers found
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negativeNumbers));
        }
        return sum;
        }

    private static int toInt(String numbers) throws NumberFormatException {
        return Integer.parseInt(numbers);
    }
}
