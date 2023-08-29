package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	private final int INF = 999;
	class Table{
		private int dist[];
		private int parent[];
		private boolean spt[];
		
		public Table(int vCount) {
			dist = new int[vCount];
			parent = new int[vCount];
			spt = new boolean[vCount];
			for(int i = 0 ; i < vCount ; i++) {
				dist[i] = INF;
				parent[i] = -1;
				spt[i] = false;
			}
		}
		
		public int findMinDistVertex(int vCount) {
			int minDist = INF, minDistVertex = -1;
			for(int i = 0 ; i < vCount ; i++) {
				if(!spt[i] && dist[i] < minDist) {
					minDist = dist[i];
					minDistVertex = i;
					
				}
			}
			return minDistVertex;
		}
		
		public void printDist(int start, int vCount) {
			for(int i = 0 ; i < vCount ;i++) {
				System.out.println(start + "->" + i + ":" + dist[i]);
			}
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
			//adjmat[dest][src] = wt;			//in case od directed graph this line is not needed
		}
	}
	
	public void dijkshtraAlgo(int start) {
		// create a table to keep track of spt, dist and parent
		Table tbl = new Table(vertexCount);
		
		//make key of start vertex as 0
		tbl.dist[start] = 0;
		
		int count = 0;
		while(count < vertexCount) {
			// choose min dist vertex
			int u = tbl.findMinDistVertex(vertexCount);
			// add min key vertex into mst
			tbl.spt[u] = true;
			// increment count
			count++;
			// update key and parent of all adjacent vertices which are not added into mst 
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjmat[u][v] != INF && !tbl.spt[v] && tbl.dist[u] + adjmat[u][v] < tbl.dist[v]) {
					tbl.dist[v] = tbl.dist[u] + adjmat[u][v];
					tbl.parent[v] = u;
				}
			}
		}
		// print shortest path o f all other vertices from start vertex
		tbl.printDist(start, vertexCount);
	}
	
}

public class GraphBfsDfsAlgosMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		
		g.dijkshtraAlgo(2);
		
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
2 5 5
3 2 2
0 3 1
1 3 3
3 4 7
3 6 4
3 5 8

*/





