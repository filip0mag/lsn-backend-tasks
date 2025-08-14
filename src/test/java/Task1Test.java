import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    @Test
    public void basicTest() {
        List<Integer> in = Arrays.asList(1, 10, 20, 20, 2, 5);
        String out = Task1.run(in);

        String expected = """
                1 2 5 10 20
                count: 6
                distinct: 5
                min: 1
                max: 20
                """;

        assertEquals(expected, out);
    }

    @Test
    public void emptyInputHandled() {
        List<Integer> in = Collections.emptyList();
        String out = Task1.run(in);

        String expected = """
                
                count: 0
                distinct: 0
                min:\s
                max:\s
                """;

        assertEquals(expected, out);
    }

    @Test public void sameNumbers() {
        List<Integer> in = Arrays.asList(3, 3, 3, 3, 3);
        String out = Task1.run(in);

        String expected = """
                3
                count: 5
                distinct: 1
                min: 3
                max: 3
                """;

        assertEquals(expected, out);
    }

    @Test
    public void testLargeDataset() {
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            in.add(i % 5000);
        }
        String out = Task1.run(in);
        assertTrue(out.contains("distinct: 5000"));
        assertTrue(out.contains("count: 200000"));
        assertTrue(out.contains("min: 0"));
        assertTrue(out.contains("max: 4999"));
    }
}
