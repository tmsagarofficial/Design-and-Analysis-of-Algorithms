package Algorithms;
import java.util.Scanner;
public class warshalls {
    void warshal(int[][] w, int n) {
        int i, j, k;
        for (k = 1; k <= n; k++)
            for (i = 1; i <= n; i++)
                for (j = 1; j <= n; j++)
                    w[i][j] = (w[i][j] != 0) || ((w[i][k] != 0) && (w[k][j] != 0)) ? 1 : 0;
    }
    public static void main(String[] args) {
        int a[][] = new int[10][10];
        int n, i, j; 
        System.out.println("enter the number of vertices");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("Enter the weighted matrix");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        warshalls f = new warshalls();
        f.warshal(a, n);
        System.out.println("The shortest path matrix is"); 
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}