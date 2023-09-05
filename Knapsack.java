package Algorithms;

import java.util.*;
public class Knapsack {
    static int c;
    static int n;
    static int[] w;
    static int[] v;
    static int[] r;
    public static int knapsack() {
        int maxProfit = 0;
        // Initialize variables
        int i = 0;
        int currentc = c;
        while (i < n) {
            if (w[i] <= currentc) {
                r[i] = 1;
                currentc -= w[i];
                maxProfit += v[i];
            } else {
                r[i] = 0;
            }
            i++;
        }
        // Print the selected items
        System.out.println("Selected items:");
        for (int j = 0; j < n; j++) {
            if (r[j] == 1) {
                System.out.println("Item " + (j + 1) + ": Weight=" + w[j] + ", Value=" + v[j]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the knapsack c: ");
        c = sc.nextInt();
        System.out.print("Enter the number of items: ");
        n = sc.nextInt();
        w = new int[n];
        v = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight for item " + (i + 1) + ": ");
            w[i] = sc.nextInt();
            System.out.print("Enter value for item " + (i + 1) + ": ");
            v[i] = sc.nextInt();
        }
        int maxProfit = knapsack();
        System.out.println("Maximum value: " + maxProfit);
        sc.close();
    }
}