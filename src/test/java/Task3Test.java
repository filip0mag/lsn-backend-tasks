import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    public void basicTest() {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{4, 3});
        edges.add(new int[]{1, 4});
        edges.add(new int[]{5, 6});

        String out = Task3.run(edges);
        assertEquals("2", out);
    }

    @Test
    public void basicTest2() {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{4, 5});

        String out = Task3.run(edges);
        assertEquals("2", out);
    }

    @Test
    public void emptyInputHandled() {
        List<int[]> edges = new ArrayList<>();

        String out = Task3.run(edges);
        assertEquals("0", out); // no graph was created
    }

    @Test
    public void singleChainIsOneGraph() {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{3, 4});

        String out = Task3.run(edges);
        assertEquals("1", out);
    }

    @Test
    public void testLargeGraph() {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            edges.add(new int[]{i, i + 1});
        }
        String out = Task3.run(edges);
        assertEquals("1", out);
    }
}
