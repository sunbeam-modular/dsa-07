package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	private int vertexCount, edgeCount;
	private boolean adjmat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new boolean[vertexCount][vertexCount];
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjmat[src][dest] = true;
			adjmat[dest][src] = true;			//in case od directed graph this line is not needed
		}
	}
	
	public boolean isBipartite(int start) {
		//create a queue for bfs traversal
		Queue<Integer> q = new LinkedList<Integer>();
		//create array to store colors of vertices : color1 = -1, color2 = 1, no color = 0
		//initially all vertices are marked with no color
		int []color = new int[vertexCount];
		// push start vertex of queue and mark it with color 1
		q.offer(start);
		color[start] = -1;
		while(!q.isEmpty()) {
			// pop a vertex from queue
			int u = q.poll();
			//check color of all neighbours
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v]) {
					// if neighbour is in same color, then return false
					if(color[v] == color[u])
						return false;
					// if neighbour iss not colored
					if(color[v] == 0) {
						q.offer(v);
						color[v] = -1 * color[u];
					}
				}
			}
		}// repeat untill queue is empty
		//if all vertices are traversed and color of adj vertices are differnt
		return true;		
	}
	
	public void dfsSpanningTree(int start) {
		// create stack to push vertices
		Stack<Integer> s  =new Stack<>();
		// create array to mark vertices
		boolean[] marked = new boolean[vertexCount];
		//1. push starting vertex on stack & mark it.
		s.push(start);
		marked[start] = true;
		System.out.println("DFS spanning tree : ");
		while(!s.isEmpty()) {
			//2. pop the vertex.
			int u = s.pop();
			//3. push all its non-marked neighbors on the stack, mark them.
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					s.push(v);
					marked[v] = true;
					//Also print the vertex to neighboring vertex edges.
					System.out.println(u + "->" + v);
				}
			}
		}//4. repeat steps 2-3 until stack is empty.
	}
	
	public void bfsSpanningTree(int start) {
		// create a queue to push vertices
		Queue<Integer> q = new LinkedList<>();
		// create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. push starting vertex on queue & mark it.
		q.offer(start);
		marked[start] = true;
		System.out.println("BFS spanning tree : ");
		while(!q.isEmpty()) {
			//2. pop the vertex.
			int u = q.poll();
			//3. push all its non-marked neighbors on the queue, mark them.
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					q.offer(v);
					marked[v] = true;
					//Also print the vertex to neighboring vertex edges.
					System.out.println(u + "->" + v);
				}
			}
		}//4. repeat steps 2-3 until queue is empty.
	}
}

public class GraphBfsDfsAlgosMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		if(g.isBipartite(0))
			System.out.println("Graph is bipartite");
		else
			System.out.println("Graph is not bipartite");
		
		//g.dfsSpanningTree(0);
		g.bfsSpanningTree(0);
		
		sc.close();
	}

}

/*
6
7
0 3
0 4
1 3
2 3
2 4
2 5
4 5


*/





