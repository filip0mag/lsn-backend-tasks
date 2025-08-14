import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // first line: take in number of edges
        String firstLine = br.readLine();
        int n = firstLine == null || firstLine.trim().isEmpty() ? 0 : Integer.parseInt(firstLine.trim());

        // read n lines of edges
        List<int[]> edges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                edges.add(new int[]{u, v});
            }
        }
        // print only the number of graphs
        System.out.println(run(edges));
    }

    public static String run(List<int[]> edges) {
        Map<Integer, Integer> idMap = new HashMap<>();
        int idCounter = 0;

        // upper bound = 2 * edges.size() (max case is when each line is a new graph)
        UnionFind uf = new UnionFind(edges.size() * 2);

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            idMap.putIfAbsent(u, idCounter++);
            idMap.putIfAbsent(v, idCounter++);

            uf.union(idMap.get(u), idMap.get(v));
        }

        // count unique roots (answer), ignores any unused capacity slots
        Set<Integer> roots = new HashSet<>();
        for (int idx : idMap.values()) {
            roots.add(uf.find(idx));
        }

        return String.valueOf(roots.size());
    }

    static class UnionFind {
        int[] parent, size;

        // on creation set everyone's parent to themselves and size to 1
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            // if we haven't yet reached the root, then go up
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            // already connected, nothing to do
            if (a == b) return;

            // if b is parent of a bigger set, change the order, so that we add smaller set to bigger
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
