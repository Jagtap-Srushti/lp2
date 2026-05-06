import java.util.*;

public class PrimMST {

    // Edge class
    static class Edge {
        int dest;
        int wt;

        Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    // Node class for Priority Queue
    static class Node {
        int vertex;
        int cost;

        Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }
    }

    // Prim's Algorithm
    public static void primMST(ArrayList<Edge>[] graph, int V) {

        boolean[] visited = new boolean[V];

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        // Start from vertex 0
        pq.add(new Node(0, 0));

        int totalCost = 0;

        System.out.println("MST Edges (Greedy - Prim's Algorithm):");

        while (!pq.isEmpty()) {

            Node curr = pq.poll();
            int u = curr.vertex;

            // Skip if already visited
            if (visited[u]) continue;

            visited[u] = true;
            totalCost += curr.cost;

            System.out.println("Visited vertex: " + u + " | Edge cost: " + curr.cost);

            // Add all adjacent edges
            for (Edge e : graph[u]) {
                if (!visited[e.dest]) {
                    pq.add(new Node(e.dest, e.wt));
                }
            }
        }

        System.out.println("Total Minimum Cost of MST: " + totalCost);
    }

    public static void main(String[] args) {

        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected weighted graph

        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(3, 6));

        graph[1].add(new Edge(0, 2));
        graph[1].add(new Edge(2, 3));
        graph[1].add(new Edge(3, 8));
        graph[1].add(new Edge(4, 5));

        graph[2].add(new Edge(1, 3));
        graph[2].add(new Edge(4, 7));

        graph[3].add(new Edge(0, 6));
        graph[3].add(new Edge(1, 8));

        graph[4].add(new Edge(1, 5));
        graph[4].add(new Edge(2, 7));

        primMST(graph, V);
    }
}