import java.util.*;

public class KruskalMST {

    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    public static void kruskal(List<Edge> edges, int V) {

        // Step 1: Sort edges
        edges.sort((a, b) -> a.wt - b.wt);

        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        System.out.println("MST Edges:");

        int cost = 0;

        for (Edge e : edges) {

            int root1 = find(parent, e.src);
            int root2 = find(parent, e.dest);

            if (root1 != root2) {
                System.out.println(e.src + " - " + e.dest + " : " + e.wt);
                cost += e.wt;

                union(parent, root1, root2);
            }
        }

        System.out.println("Total Cost: " + cost);
    }

    public static void main(String[] args) {

        int V = 5;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        kruskal(edges, V);
    }
}