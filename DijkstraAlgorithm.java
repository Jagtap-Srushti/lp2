import java.util.*;

public class DijkstraAlgorithm {

    static class Edge {
        int dest;
        int wt;

        Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    static class Node {
        int vertex;
        int dist;

        Node(int v, int d) {
            vertex = v;
            dist = d;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int V, int src) {

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            if (visited[curr.vertex]) continue;

            visited[curr.vertex] = true;

            for (Edge e : graph[curr.vertex]) {

                if (!visited[e.dest] &&
                        dist[curr.vertex] + e.wt < dist[e.dest]) {

                    dist[e.dest] = dist[curr.vertex] + e.wt;
                    pq.add(new Node(e.dest, dist[e.dest]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");

        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
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
        graph[0].add(new Edge(2, 4));

        graph[1].add(new Edge(0, 2));
        graph[1].add(new Edge(2, 1));
        graph[1].add(new Edge(3, 7));

        graph[2].add(new Edge(0, 4));
        graph[2].add(new Edge(1, 1));
        graph[2].add(new Edge(4, 3));

        graph[3].add(new Edge(1, 7));
        graph[3].add(new Edge(4, 1));

        graph[4].add(new Edge(2, 3));
        graph[4].add(new Edge(3, 1));

        dijkstra(graph, V, 0);
    }
}