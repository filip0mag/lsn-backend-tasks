import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        if(line != null && !line.trim().isEmpty()) {
            String[] tokens = line.trim().split("\\s+");
            for(String token : tokens) {
                numbers.add(Integer.parseInt(token));
            }
        }
        // print exact format accordin to specs
        System.out.print(run(numbers));
    }

    public static String run(List<Integer> numbers) {

        // result to be printed
        StringBuilder result = new StringBuilder();

        // tree set = unique + sorted in one gom in this case ascending
        TreeSet<Integer> sortedUnique = new TreeSet<>(numbers);

        // first line - distinct elements ascending, space separated
        Iterator<Integer> iterator = sortedUnique.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) result.append(' ');
        }
        result.append('\n');

        result.append("count: ").append(numbers.size()).append('\n');
        result.append("distinct: ").append(sortedUnique.size()).append('\n');

        if (!numbers.isEmpty()) {
            result.append("min: ").append(sortedUnique.first()).append('\n');
            result.append("max: ").append(sortedUnique.last()).append('\n');
        } else {
            result.append("min: \nmax: \n");
        }

        return result.toString();
    }
}
