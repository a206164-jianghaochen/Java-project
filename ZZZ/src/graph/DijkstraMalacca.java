package graph;
import java.util.*;
public class DijkstraMalacca {
    private static String getCityName(int index) {
        switch (index) {
            case 0: return "Masjid Tanah";
            case 1: return "Alor Gajah";
            case 2: return "Tangga Batu";
            case 3: return "Bukit Katil";
            case 4: return "Kota Melaka";
            case 5: return "Jasin";
            default: return "Unknown";
        }
    }
    public static void dijkstra(int[][] graph, int start, int destination) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes]; 
        boolean[] visited = new boolean[numNodes]; 
        int[] previousNodes = new int[numNodes]; 
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previousNodes, -1);
        distances[start] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(node -> distances[node]));
        pq.add(start);
        while (!pq.isEmpty()) {
            int currentNode = pq.poll();
            visited[currentNode] = true;
            for (int neighbor = 0; neighbor < numNodes; neighbor++) {
                if (graph[currentNode][neighbor] != 0 && !visited[neighbor]) { // If there's an edge and it's not visited
                    int newDist = distances[currentNode] + graph[currentNode][neighbor];
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        previousNodes[neighbor] = currentNode;
                        pq.add(neighbor);
                    }
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        for (int at = destination; at != -1; at = previousNodes[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        if (distances[destination] == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + getCityName(start) + " to " + getCityName(destination));
        } else {
            System.out.print("The Shorted Path from " + getCityName(start) + " to " + getCityName(destination) + " is " + distances[destination] + " km");          
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 14, 15, 0, 0, 0}, 
                {14, 0, 25, 27, 0, 32}, 
                {15, 25, 0, 23, 16, 0}, 
                {0, 27, 23, 0, 10, 21}, 
                {0, 0, 16, 10, 0, 31}, 
                {0, 32, 0, 21, 31, 0}
        };
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int destination = scanner.nextInt();

        dijkstra(graph, start, destination);
    }
}
