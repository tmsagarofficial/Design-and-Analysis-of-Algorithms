package Algorithms;
import java.util.Scanner;
public class bellmanford {

    static int[][] g;

    static int n ;
    static int[] d;
   

    public static void main(String[] args) {
        int s = 0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n=sc.nextInt();

        d = new int[n];
        System.out.println("Enter the matrix");
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		g[i][j]=sc.nextInt();
        	}
        }
        
        bellmanFord(s);

        System.out.println("Shortest ds from s vertex " + s + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + d[i]);
        }
    }

    static void bellmanFord(int s) {
        for (int i = 0; i < n; i++) {
            d[i] = 999;
            
        }
        d[s] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if ( d[u] + g[u][v] < d[v]&&g[u][v] != 0 && d[u] != 999) {
                      
                        d[v] = d[u] + g[u][v];
                    }
                }
            }
        }

        // Check for negative cycles
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (d[u] + g[u][v] < d[v]&&g[u][v] != 0 && d[u] != 999 ) {
                    System.out.println("g contains negative cycle.");
                    return;
                }
            }
        }
    }
}
