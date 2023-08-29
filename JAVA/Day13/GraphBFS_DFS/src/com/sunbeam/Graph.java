package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
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
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print((adjmat[i][j] ? "1" : "0") + " ");
			}
			System.out.println("");
		}
	}
	
	public void DFSTraversal(int start) {
		// create an array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//create a stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//1. Choose a vertex as start vertex. -- start 
		//2. Push start vertex on stack & mark it. 
		st.push(start);
		marked[start] = true;
		System.out.print("DFS : ");
		while(!st.isEmpty()) {
			//3. Pop vertex from stack.
			int u = st.pop();
			//4. Print the vertex.
			System.out.print(" " + u);
			//5. Put all non-visited neighbours of the vertex on the stack and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					st.push(v);
					marked[v] = true;
				}
			}
		}//6. Repeat 3-5 until stack is empty.
		System.out.println("");
	}
	
	public void BFSTraversal(int start) {
		// create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		// create a queue to push vertices
		Queue<Integer> q = new LinkedList<>();
		//1. Choose a vertex as start vertex. - start 
		//2. Push start vertex on queue & mark it 
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS : ");
		while(!q.isEmpty()) {
			//3. Pop vertex from queue. 
			int u = q.poll();
			//4. Print the vertex.
			System.out.print(" " + u);
			//5. Put all non-visited neighbours of the vertex on the queue and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					q.offer(v);
					marked[v] = true;
				}
			}
		}//6. Repeat 3-5 until queue is empty.
		System.out.println("");

	}
	
	public boolean isConnected(int start) {
		// create an array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//create a stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//1. Choose a vertex as start vertex. -- start 
		//2. Push start vertex on stack & mark it. 
		st.push(start);
		marked[start] = true;
		int count = 1;
		while(!st.isEmpty()) {
			//3. Pop vertex from stack.
			int u = st.pop();
			//5. Put all non-visited neighbours of the vertex on the stack and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					st.push(v);
					marked[v] = true;
					count++;
				}
			}
			// check if count is equal to vertxe count
			if(count == vertexCount)
				return true;		// graph is connected
		}//6. Repeat 3-5 until stack is empty.
		return false;		// graph is not connected
	}
	
	public void singleSourcePathLength(int start) {
		int dist[] = new int[vertexCount];
		// create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		// create a queue to push vertices
		Queue<Integer> q = new LinkedList<>();
		//1. Choose a vertex as start vertex. - start 
		//2. Push start vertex on queue & mark it 
		q.offer(start);
		marked[start] = true;
		dist[start] = 0;
		while(!q.isEmpty()) {
			//3. Pop vertex from queue. 
			int u = q.poll();
			//5. Put all non-visited neighbours of the vertex on the queue and mark them. 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] && !marked[v]) {
					q.offer(v);
					marked[v] = true;
					dist[v] = dist[u] + 1;
				}
			}
		}//6. Repeat 3-5 until queue is empty.
		System.out.println("Distances of all vertices from : " + start);
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(start + " to " + i + " = " + dist[i]);
	}

}






