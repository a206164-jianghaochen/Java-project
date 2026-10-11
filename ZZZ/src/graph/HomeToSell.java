package graph;
import java.util.*;
class Graph {
    private List<List<Integer>> adjList;
    private String[] roomNames;
    public Graph(int vertices) {
        adjList = new ArrayList<>(vertices);
        roomNames = new String[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void setRoomName(int vertex, String name) {
        roomNames[vertex] = name;
    }
    public String getRoomName(int vertex) {
        return roomNames[vertex];
    }
    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[roomNames.length];
        List<String> path = new ArrayList<>();
        dfsHelper(startVertex, visited, path);
        printPathWithTrailingArrow(path);
    }
    private void dfsHelper(int vertex, boolean[] visited, List<String> path) {
        visited[vertex] = true;
        path.add(roomNames[vertex]);
        List<Integer> neighbors = new ArrayList<>(adjList.get(vertex));
        Collections.sort(neighbors);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, path);
            }
        }
    }
    private void printPathWithTrailingArrow(List<String> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        if (!path.isEmpty()) {
            System.out.print(" -> ");
        }
        System.out.println(); 
    }
}
public class HomeToSell {
    public static void main(String[] args) {
        int vertices = 7;
        Graph houseGraph = new Graph(vertices);
        houseGraph.setRoomName(0, "Kitchen");
        houseGraph.setRoomName(1, "Pantry");
        houseGraph.setRoomName(2, "Dining Room");
        houseGraph.setRoomName(3, "Back Foyer");
        houseGraph.setRoomName(4, "Front Foyer");
        houseGraph.setRoomName(5, "Study Room");
        houseGraph.setRoomName(6, "Living Room");
        houseGraph.addEdge(0, 1); 
        houseGraph.addEdge(1, 2); 
        houseGraph.addEdge(2, 4); 
        houseGraph.addEdge(4, 3); 
        houseGraph.addEdge(3, 5); 
        houseGraph.addEdge(5, 6);      
        houseGraph.addEdge(1, 0); 
        houseGraph.addEdge(2, 1); 
        houseGraph.addEdge(4, 2); 
        houseGraph.addEdge(3, 4); 
        houseGraph.addEdge(5, 3); 
        houseGraph.addEdge(6, 5); 
        Scanner scanner = new Scanner(System.in);     
        int startVertex = scanner.nextInt();
        if (startVertex < 0 || startVertex >= vertices) {           
        } else {            
            houseGraph.dfs(startVertex);
        }
        scanner.close();
    }
}

