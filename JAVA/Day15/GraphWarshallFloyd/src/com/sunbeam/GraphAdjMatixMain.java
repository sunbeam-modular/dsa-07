package com.sunbeam;

import java.util.Scanner;

public class GraphAdjMatixMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		g.print();
		
		g.warshallFloyd();
		
		
		sc.close();
	}

}


/*
4
6
0 1 8
3 1 2
3 2 9
2 0 4
0 3 1
1 2 1



*/











