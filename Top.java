package Topo;
import java.util.*;

public class Top {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the directed edges (vertex pairs) or type 'done' to finish:");
        while (true) {
            String input = sc.next();
            if (input.equals("done")) {
                break;
            }
            int v = Integer.parseInt(input);
            int w = sc.nextInt();
            adj.get(v).add(w);
        }

        System.out.println("Topological Sort:");
        topologicalSort(V, adj);
    }

    public static void topologicalSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, adj, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topologicalSortUtil(int v, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, adj, stack);
            }
        }

        stack.push(v);
    }
}