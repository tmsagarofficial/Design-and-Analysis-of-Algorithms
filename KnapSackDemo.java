package KnapSack;
import java.util.*;

class Item {
    int w;
    int v;

    public Item(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class KnapSackDemo {
	static double getMaxv(int c, Item[] items) {
        // Sort items by v per unit w in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.v / (double) b.w, a.v / (double) a.w));

        double totalv = 0;
        int currentw = 0;

        for (Item item : items) {
            if (currentw + item.w <= c) {
                currentw += item.w;
                totalv += item.v;
            } else {
                int remainingCapacity = c - currentw;
                totalv += (item.v / (double) item.w) * remainingCapacity;
                break;
            }
        }

        return totalv;
}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter w and v for item " + (i + 1) + ": ");
            int w = sc.nextInt();
            int v = sc.nextInt();
            items[i] = new Item(w, v);
        }

        System.out.print("Enter the c of the knapsack: ");
        int c = sc.nextInt();

        double maxv = getMaxv(c, items);
        System.out.println("The maximum profit that can be obtained is: " + maxv);

        sc.close();
	}

}