import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        if (line != null && !line.trim().isEmpty()) {
            String[] tokens = line.trim().split("\\s+");
            for (String token : tokens) {
                numbers.add(Integer.parseInt(token));
            }
        }
        // print pairs
        System.out.print(run(numbers));
    }


    public static String run(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();

        // count how many times each number appears
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer number : numbers) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        // get different numbers in ascending order
        List<Integer> keys = new ArrayList<>(counts.keySet());
        Collections.sort(keys);

        for (int num1 : keys) {
            int num2 = 13 - num1;
            // we can stop there early, no new pairs will appear after this
            if (num1 > num2) break;

            Integer amount1 = counts.get(num1);
            Integer amount2 = counts.get(num2);
            // if number not found, skip
            if (amount2 == null) continue;

            // output each valid pair the correct number of times
            long times = (long) amount1 * amount2;
            for (int i = 0; i < times; i++) {
                result.append(num1).append(' ').append(num2).append('\n');
            }
        }

        return result.toString();
    }
}
