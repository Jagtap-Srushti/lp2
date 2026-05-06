import java.util.*;

public class AStarAlgorithm {

    // Node class
    static class Node {
        int x, y;
        int g, h, f;
        Node parent;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Heuristic function (Manhattan Distance)
    public static int calculateH(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Check if cell is valid
    public static boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                && grid[x][y] == 0;
    }

    // Print path
    public static void printPath(Node node) {
        if (node == null) return;
        printPath(node.parent);
        System.out.print("(" + node.x + "," + node.y + ") ");
    }

    // A* Algorithm
    public static void aStar(int[][] grid, int[] start, int[] goal) {

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        boolean[][] closedList = new boolean[grid.length][grid[0].length];

        Node startNode = new Node(start[0], start[1]);
        Node goalNode = new Node(goal[0], goal[1]);

        startNode.g = 0;
        startNode.h = calculateH(start[0], start[1], goal[0], goal[1]);
        startNode.f = startNode.g + startNode.h;

        openList.add(startNode);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!openList.isEmpty()) {

            Node current = openList.poll();

            if (current.x == goalNode.x && current.y == goalNode.y) {
                System.out.println("Path found:");
                printPath(current);
                return;
            }

            closedList[current.x][current.y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (isValid(newX, newY, grid) && !closedList[newX][newY]) {

                    Node neighbor = new Node(newX, newY);

                    neighbor.g = current.g + 1;
                    neighbor.h = calculateH(newX, newY, goal[0], goal[1]);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;

                    openList.add(neighbor);
                }
            }
        }

        System.out.println("No path found");
    }

    public static void main(String[] args) {

        /*
         Grid representation:
         0 = free cell
         1 = obstacle
        */

        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        int[] start = {0, 0};
        int[] goal = {3, 3};

        aStar(grid, start, goal);
    }
}