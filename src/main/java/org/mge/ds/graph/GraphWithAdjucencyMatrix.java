package org.mge.ds.graph;

public class GraphWithAdjucencyMatrix {
	private int[][] graph;
	
	public GraphWithAdjucencyMatrix(int V) {
		graph = new int[V][V];
	}
	
	public void addEdge(int src, int dest) {
		graph[src][dest] = 1;
	}
	
	public void printGraph(){
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				if(graph[i][j] == 1) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
}
