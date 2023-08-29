package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	private final int INF = 999;
	class Table{
		private int keys[];
		private int parent[];
		private boolean mst[];
		
		public Table(int vCount) {
			keys = new int[vCount];
			parent = new int[vCount];
			mst = new boolean[vCount];
			for(int i = 0 ; i < vCount ; i++) {
				keys[i] = INF;
				parent[i] = -1;
				mst[i] = false;
			}
		}
		
		public int findMinKeyVertex(int vCount) {
			int minKey = INF, minKeyVertex = -1;
			for(int i = 0 ; i < vCount ; i++) {
				if(!mst[i] && keys[i] < minKey) {
					minKey = keys[i];
					minKeyVertex = i;
					
				}
			}
			return minKeyVertex;
		}
		
		public int printMST(int vCount) {
			int wt = 0;
			for(int i = 0 ; i < vCount ;i++) {
				wt += keys[i];
				System.out.println(parent[i] + "->" + i);
			}
			return wt;
		}
	}
	
	private int vertexCount, edgeCount;
	private int adjmat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				adjmat[i][j] = INF;
			}
		}
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			adjmat[dest][src] = wt;			//in case od directed graph this line is not needed
		}
	}
	
	public void primsMST(int start) {
		// create a table to keep track of mst, keys andd parent
		Table tbl = new Table(vertexCount);
		
		//make key of start vertex as 0
		tbl.keys[start] = 0;
		
		int count = 0;
		while(count < vertexCount) {
			// choose min key vertex
			int u = tbl.findMinKeyVertex(vertexCount);
			// add min key vertex into mst
			tbl.mst[u] = true;
			// increment count
			count++;
			// update key and parent of all adjacent vertices which are not added into mst 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] != INF && !tbl.mst[v] && adjmat[u][v] < tbl.keys[v]) {
					tbl.keys[v] = adjmat[u][v];
					tbl.parent[v] = u;
				}
			}
		}
		// print mst and find the weight - optional
		int wt = tbl.printMST(vertexCount);
		System.out.println("Weight of MST = " + wt);
	}
	
}

public class GraphBfsDfsAlgosMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		
		g.primsMST(2);
		
		sc.close();
	}

}

/*
7
12
2 0 4
0 1 2
1 4 10
4 6 6
6 5 1
5 2 5
3 2 2
3 0 1
3 1 3
3 4 7
3 6 4
3 5 8

*/





