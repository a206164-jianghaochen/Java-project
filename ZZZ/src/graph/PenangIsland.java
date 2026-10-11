package graph;
import java.util.*;
public class PenangIsland {
    private static final int NUM_DESTINATIONS = 8;
    private static final String[] DESTINATIONS = {
        "Airport", "B.Bendera", "Bt.Ferrenghi", "Tg.Tokong", 
        "U.S.M", "Muka Head", "Komtar", "B.Jambul"
    };
    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < NUM_DESTINATIONS; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    public static void primMST(int[][] graph) {
        int[] parent = new int[NUM_DESTINATIONS]; 
        int[] key = new int[NUM_DESTINATIONS]; 
        boolean[] mstSet = new boolean[NUM_DESTINATIONS]; 
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; 
        parent[0] = -1; 
        for (int count = 0; count < NUM_DESTINATIONS - 1; count++) {
            int u = minKey(key, mstSet); 
            mstSet[u] = true; 
            for (int v = 0; v < NUM_DESTINATIONS; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }
    private static void printMST(int[] parent, int[][] graph) {
        for (int i = 1; i < NUM_DESTINATIONS; i++) {
            System.out.println(DESTINATIONS[parent[i]] + " - " + DESTINATIONS[i] + "[" + graph[i][parent[i]] + "km]");
        }
    }
    public static void main(String[] args) {       
        int[][] graph = {
            {0, 25, 31, 22, 9, 37, 24, 6}, 
            {25, 0, 11, 9, 18, 25, 11, 20},  
            {31, 11, 0, 10, 23, 6, 16, 27},  
            {22, 9, 10, 0, 14, 17, 6, 17},   
            {9, 18, 23, 14, 0, 30, 11, 5},   
            {37, 25, 6, 17, 30, 0, 22, 33},  
            {24, 11, 16, 6, 11, 22, 0, 14}, 
            {6, 20, 27, 17, 5, 33, 14, 0}    
        };
      System.out.println("Destination[Length]");
        primMST(graph);
    }
}
