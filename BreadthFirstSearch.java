import java.util.*;

public class BreadthFirstSearch {

    // Edge class (no weight)
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int start, int v) {

        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        // start BFS
        vis[start] = true;
        q.add(start);

        System.out.println("BFS Traversal:");

        while (!q.isEmpty()) {

            int curr = q.poll();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter edges (src dest):");

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            // Undirected graph
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        bfs(graph, start, v);

        sc.close();
    }
}