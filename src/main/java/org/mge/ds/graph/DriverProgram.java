package org.mge.ds.graph;

public class DriverProgram {
	public static void main(String[] args) {
//		GraphWithAdjucencyMatrix graphWithAdjucencyMatrix = new GraphWithAdjucencyMatrix(4);
//		
//		graphWithAdjucencyMatrix.addEdge(0, 1);
//		graphWithAdjucencyMatrix.addEdge(0, 2);
//		graphWithAdjucencyMatrix.addEdge(1, 2);
//		graphWithAdjucencyMatrix.addEdge(2, 0);
//		graphWithAdjucencyMatrix.addEdge(2, 3);
//		graphWithAdjucencyMatrix.addEdge(3, 3);
//		
//		graphWithAdjucencyMatrix.printGraph();
		
		GraphWithAdjucencyList graphWithAdjucencyList = new GraphWithAdjucencyList(4);
		
		graphWithAdjucencyList.addEdge(0, 1);
		graphWithAdjucencyList.addEdge(0, 2);
		graphWithAdjucencyList.addEdge(1, 2);
		graphWithAdjucencyList.addEdge(2, 0);
		graphWithAdjucencyList.addEdge(2, 3);
		graphWithAdjucencyList.addEdge(3, 3);
		
		graphWithAdjucencyList.printBFS(2);
		
		System.out.println();
		
		graphWithAdjucencyList.printDFS(2);
	}
}
