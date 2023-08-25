package com.sunbeam;

import java.util.Scanner;

public class Heap {
	private int SIZE;
	private int arr[];
	public Heap(int size) {
		SIZE = 0;
		arr = new int[size];
	}
	
	public void addHeap(int ele) {
		// increment heap size
		SIZE++;
		// add element into first empty index
		arr[SIZE] = ele;
		// find parent's index
		int pi = SIZE / 2;
		// adjust position of added element upto root
		while(pi >= 1) {
			// find index of left child
			int ci = pi * 2;				// right child ci + 1
			// find index of maximum child
			if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			// if parent is greater than maximum child then break the loop
			if(arr[pi] > arr[ci])
				break;
			// if parent is less than maximum child then swap parent and max child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			// update the parent of maximum child
			pi = pi / 2;
		}
	}
	
	public int deleteMax() {
		// swap root element with last element of heap
		int max = arr[1];
		arr[1] = arr[SIZE];
		arr[SIZE] = max;
		//decrement heap size
		SIZE--;
		// find the index of left child
		int ci = 1 * 2;
		// adjust position of root element till last element of heap
		while(ci <= SIZE) {
			// find parent's index
			int pi = ci / 2;
			// find index of maximum child
			if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			// if parent is greater than maximum child then break the loop
			if(arr[pi] > arr[ci])
				break;
			// if parent is less than maximum child then swap parent and max child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			// update the child of parent
			ci = ci * 2;
		}
		
		// return deleted value
		return max;
	}
	public void makeHeap(int size) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array elements : ");
		for(int i = 0 ; i < size ; i++)
			addHeap(sc.nextInt());
		sc.close();
	}
	public void deleteHeap(int size) {
		for(int i = 0 ; i < size ; i++)
			deleteMax();
	}
	
	public void heapSort(int size) {
		//1. create heap by using given values
		makeHeap(size);		// n log n 
		//2. delete all elements from heap
		deleteHeap(size);	// n log n
							// O(n log n)
	}
	
	public void printArray(int size) {
		System.out.print("Array : ");
		for(int i = 1 ; i <= size ; i++)
			System.out.print(" " + arr[i]);
	}

}





