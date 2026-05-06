import java.util.*;

public class DepthFirstSearch {

    // Edge class (without weight)
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // DFS recursive function
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input vertices and edges
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter edges (src dest):");

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            // Undirected graph (add both sides)
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        dfs(graph, start, new boolean[v]);

        sc.close();
    }
}