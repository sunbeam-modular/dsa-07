package com.sunbeam;

public class heapSortMain {

	public static void main(String[] args) {
		// 6, 14, 3, 26, 8, 18, 21, 9, 5
		Heap h = new Heap(10);
		
		h.heapSort(9);
		
		h.printArray(9);

	}

}
