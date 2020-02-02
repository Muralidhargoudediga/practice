package org.mge.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphWithAdjucencyList {
	private int V;
	private LinkedList<Integer> adjList[];

	public GraphWithAdjucencyList(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}

	public void printBFS(int s) {

		boolean[] visited = new boolean[V];
		LinkedList<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			s = q.poll();

			System.out.print(s + " ");

			Iterator<Integer> i = adjList[s].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					q.add(n);
					visited[n] = true;
				}
			}
		}
	}

	public void printDFS(int v) {
		boolean[] visited = new boolean[V];
		DFSUtil(v, visited);
	}
	
	//The above code traverses only the vertices reachable from a given source vertex. All the vertices may not be reachable from a given vertex (example Disconnected graph).
	public void printDFS() {
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			if(!visited[i])
				DFSUtil(i, visited);
		}
	}

	private void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;

		System.out.print(v + " ");

		Iterator<Integer> i = adjList[v].iterator();

		while (i.hasNext()) {
			int n = i.next();

			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
}
