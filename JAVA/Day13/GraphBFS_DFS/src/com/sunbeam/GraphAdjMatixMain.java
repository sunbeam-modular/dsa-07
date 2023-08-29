package com.sunbeam;

import java.util.Scanner;

public class GraphAdjMatixMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		//g.print();
		g.DFSTraversal(2);
		g.BFSTraversal(2);
		if(g.isConnected(2))
			System.out.println("Graph is connected");
		else
			System.out.println("Graph is not connected");
		
		g.singleSourcePathLength(2);
		
		
		sc.close();
	}

}


/*
6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5


*/











