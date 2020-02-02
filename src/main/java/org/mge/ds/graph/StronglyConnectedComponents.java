package org.mge.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//Source : https://www.geeksforgeeks.org/strongly-connected-components/
public class StronglyConnectedComponents {
	
	private LinkedList<Integer>[] adjList;
	private int V;
	
	public StronglyConnectedComponents(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) {
		StronglyConnectedComponents gr = new StronglyConnectedComponents(5);
		gr.addEdge(0, 2);
		gr.addEdge(0, 3);
		gr.addEdge(1, 0);
		gr.addEdge(2, 1);
		gr.addEdge(3, 4);
		
		gr.printSCCs();
	}
	
	void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	
	public void printSCCs() {
		Stack<Integer> s = new Stack<>();
		
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			if(!visited[i])
				fillOrder(i, visited, s);
		}
		
		StronglyConnectedComponents gr = getTranspose();
		
		for(int i = 0; i < V; i++) {
			visited[i] = false;
		}
		
		while(!s.isEmpty()) {
			int n = s.pop();
			
			if(!visited[n]) {
				gr.printDFS(n, visited);
				System.out.println();
			}
		}
	}
	
	public void fillOrder(int v, boolean visited[], Stack<Integer> s){
		visited[v] = true;
		
		Iterator<Integer> i = adjList[v].iterator();
		
		while(i.hasNext()) {
			int n = i.next();
			
			if(!visited[n]) {
				fillOrder(n, visited, s);
			}
		}
		s.add(v);
	}
	
	public StronglyConnectedComponents getTranspose(){
		StronglyConnectedComponents gr = new StronglyConnectedComponents(V);
		
		for(int i = 0; i < V; i++) {
			Iterator<Integer> itr = adjList[i].iterator();
			
			while(itr.hasNext()) {
				gr.adjList[itr.next()].add(i);
			}
		}
		
		return gr;
	}
	
	void printDFS(int v, boolean[] visited) {
		visited[v] = true;
		
		System.out.print(v + " ");
		
		Iterator<Integer> i = adjList[v].iterator();
		
		while(i.hasNext()) {
			int n = i.next();
			
			if(!visited[n]) {
				visited[n] = true;
				printDFS(n, visited);
			}
		}
	}
}
