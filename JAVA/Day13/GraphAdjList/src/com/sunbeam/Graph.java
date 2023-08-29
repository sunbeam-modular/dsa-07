package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	private int vertexCount, edgeCount;
	private List<Integer> adjlist[];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjlist = new List[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			adjlist[i] = new ArrayList<Integer>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjlist[src].add(dest);
			adjlist[dest].add(src);			// in case of directed graph this line is not needed
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print(i + " : ");
			for(Integer e : adjlist[i]) {
				System.out.print(e + " ");
			}
			System.out.println("");
		}
	}

}







