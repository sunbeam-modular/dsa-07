package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjmat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		for(int  i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				adjmat[i][j] = INF;
			}
		}
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			//adjmat[dest][src] = wt;			//in case od directed graph this line is not needed
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print((adjmat[i][j]==INF ? "INF" : adjmat[i][j]) + "\t");
			}
			System.out.println("");
		}
	}
	
	public void warshallFloyd() {
		// initial distance -> adjacency matrix
		int[][] dist = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++)
				dist[u][v] = adjmat[u][v];
			dist[u][u] = 0;
		}
		
		// consider each vertex as intermediate vertex
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int u = 0 ; u < vertexCount ; u++) {
				for(int v = 0 ; v < vertexCount ; v++)
					if(dist[u][i] != INF && dist[i][v] != INF && dist[u][i] + dist[i][v] < dist[u][v])
						dist[u][v] = dist[u][i] + dist[i][v];
			}
		}
		
		System.out.println("Distances : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++)
				System.out.print(" " + dist[u][v]);
			System.out.println("");
		}
	}

}






