import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    @Test
    public void basicTest() {
        List<Integer> in = Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);
        String out = Task2.run(in);

        String expected = """
                0 13
                3 10
                6 7
                6 7
                """;

        assertEquals(expected, out);
    }

    @Test
    public void emptyInputHandled() {
        List<Integer> in = new ArrayList<>();
        String out = Task2.run(in);
        assertEquals("", out);
    }

    @Test
    public void noPairsProducesEmptyOutput() {
        List<Integer> in = Arrays.asList(8, 7, 3);
        String out = Task2.run(in);
        assertEquals("", out);
    }

    @Test
    public void sameNumberPairs() {
        List<Integer> in = Arrays.asList(6, 6, 7, 7, 7);
        String out = Task2.run(in);
        String expected = """
                6 7
                6 7
                6 7
                6 7
                6 7
                6 7
                """;

        assertEquals(expected, out);
    }

    @Test
    public void testLargeDataset() {
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            in.add(i % 1000);
        }
        String out = Task2.run(in);
        assertTrue(out.contains("0 13"));
        assertTrue(out.contains("1 12"));
        assertTrue(out.contains("2 11"));
        assertTrue(out.contains("3 10"));
        assertTrue(out.contains("4 9"));
        assertTrue(out.contains("5 8"));
        assertTrue(out.contains("6 7"));
    }
}
