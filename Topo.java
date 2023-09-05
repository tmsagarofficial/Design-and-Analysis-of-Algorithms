package Topo;
import java.util.*;

public class Topo {
    private List<List<Integer>> graph;
    private int[] iD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int n = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

            System.out.print("Enter the number of neighbors for vertex " + i + ": ");
            int numnbs = sc.nextInt();
            if(numnbs>=1) {
            	System.out.println("Enter the neighbors for vertex " + i + ": ");
                for (int j = 0; j < numnbs; j++) {
                    int nb = sc.nextInt();
                    graph.get(i).add(nb);
                }	
            }   
        }

        sc.close();

        Topo sourceRemovalAlgorithm = new Topo(graph);
        List<Integer> result = sourceRemovalAlgorithm.performTopologicalSort();

        if (result.isEmpty()) {
            System.out.println("The graph contains cycles.");
        } else {
            System.out.println("Topological Order: " + result);
        }
    }
    
    
    public Topo(List<List<Integer>> graph) {
        this.graph = graph;
        int n = graph.size();
        iD = new int[n];
        computeiD();
    }

    private void computeiD() {
        for (List<Integer> nbs : graph) {
            for (int nb : nbs) {
                iD[nb]++;
            }
        }
    }

    public List<Integer> performTopologicalSort() {
        int n = graph.size();
        List<Integer> topologicalOrder = new ArrayList<>();

        while (topologicalOrder.size() < n) {
            int source = findSourceVertex();
            if (source == -1) {
                // Graph contains cycles, return an empty list
                topologicalOrder.clear();
                break;
            }

            topologicalOrder.add(source);
            updateiD(source);
        }

        return topologicalOrder;
    }

    private int findSourceVertex() {
        int n = iD.length;
        for (int i = 0; i < n; i++) {
            if (iD[i] == 0) {
                iD[i] = -1; // Mark as visited
                return i;
            }
        }
        return -1; // No source vertex found
    }

    private void updateiD(int vertex) {
        for (int nb : graph.get(vertex)) {
            iD[nb]--;
        }
    }

    
}

