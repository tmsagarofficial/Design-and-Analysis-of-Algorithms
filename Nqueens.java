package Algorithms;
import java.util.Scanner;
public class Nqueens {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the board size (N): ");
        int n = scanner.nextInt();
        scanner.close();
        solveNQueens(n);
	}
	public static void solveNQueens(int n) {
        int[] board = new int[n + 1];
        placeQueens(board, 1);
    }
	public static void placeQueens(int[] board, int row) {
        int n = board.length - 1;
        if (row == n + 1) {
            printBoard(board);
        } else {
            for (int col = 1; col <= n; col++) {
                if (isSafe(board, row, col)) {
                    board[row] = col;
                    placeQueens(board, row + 1);
                    board[row] = 0; // Backtrack
                }
            }
        }
    }
    public static void printBoard(int[] board) {
        int n = board.length - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
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
    public static boolean isSafe(int[] board, int row, int col) {
        for (int i = 1; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    
    
  
}