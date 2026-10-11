package prim_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim_algorithm {

	public static void main(String[] args) {
		int v = 12;
		List<List<Edge>> graph = new ArrayList<>();
		
		for(int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[][] knownEdges = {
				
				{0,1,3}, {0,2,5}, {0,3,4}, //from 0	
				{1,0,3}, {1,4,3}, {1,5,6}, //from 1				
				{2,0,5}, {2,3,2}, {2,6,4}, //from 2				
				{3,0,4}, {3,2,2}, {3,7,5}, //from 3				
				{4,1,3}, {4,5,2}, {4,8,4}, //from 4				
				{5,1,6}, {5,4,2}, {5,9,5}, //from 5			
				{6,2,4}, {6,7,3}, {6,10,6}, //from 6				
				{7,3,5}, {7,6,3}, {7,10,7}, //from 7			
				{8,4,4}, {8,7,6}, {8,9,3}, //from 8			
				{9,5,5}, {9,8,3}, {9,11,9}, //from 9				
				{10,6,6}, {10,7,7}, {10,11,8}, //from 10				
				{11,9,9}, {11,10,8}, //from 11
				
		};
		
		for(int[] edge : knownEdges) {
			int from = edge[0];
			int to = edge[1];
			int weight = edge[2];
			graph.get(from).add(new Edge(from, to, weight));	
		}
		
		boolean[] visited = new boolean[v];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		List<Edge> mst = new ArrayList<>();
		
		int startVertex = 0;
		visited[startVertex] = true;
		
		for(Edge e : graph.get(startVertex)) {
			pq.add(e);	
		}
		while(!pq.isEmpty()) {
			
			Edge minEdge = pq.poll();
			int nextVertex = minEdge.to;
			
			if(visited[nextVertex]) {
				continue;
			}
			
			visited[nextVertex] = true;
			
			mst.add(minEdge);
			
			for(Edge nextEdge : graph.get(nextVertex)) {
				
				if(!visited[nextEdge.to]) {
					pq.add(nextEdge);
				}
			}	
		}
		int totalWeight = 0;
		
		for(Edge e : mst) {
			System.out.println("Edge: " + e.from + "->" + e.to + " | weight: " + e.weight);
			totalWeight += e.weight;
		}
		System.out.println("The minimum total weight is: " + totalWeight);
			
	}

}
