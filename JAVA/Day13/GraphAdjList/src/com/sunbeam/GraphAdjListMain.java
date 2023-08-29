package com.sunbeam;

import java.util.Scanner;

public class GraphAdjListMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		g.print();
		
		sc.close();
	}

}
