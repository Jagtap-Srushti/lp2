import java.util.*;

public class NQueens {

    // Check if placing queen is safe
    public static boolean isSafe(int row, int col, int[] board) {

        for (int i = 0; i < row; i++) {

            // same column
            if (board[i] == col) {
                return false;
            }

            // diagonal check
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }

    // Print solution
    public static void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Backtracking function
    public static void solveNQueens(int row, int n, int[] board) {

        if (row == n) {
            printBoard(board, n);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, board)) {
                board[row] = col;

                solveNQueens(row + 1, n, board);

                // backtrack
                board[row] = -1;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Queens (N): ");
        int n = sc.nextInt();

        int[] board = new int[n];

        Arrays.fill(board, -1);

        System.out.println("All possible solutions:");

        solveNQueens(0, n, board);

        sc.close();
    }
}