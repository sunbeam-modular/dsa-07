package com.sunbeam;

import java.util.Arrays;

public class quickSortMain {
	public static void quickSort(int arr[], int left, int right) {
		//0. stop if single element partition or invalid partion
		if(left >= right)
			return;
		//1. Select pivot (axis/referance) element from array
		// arr[left] - > pivot
		int i = left, j = right;
		//2. Arrange all smaller elements than pivot on left side of pivot
		//3. Arrange all greater elements than pivot on right side of pivot
		while(i < j) {
			// find element which is greater than pivot
			while(i <= right && arr[i] <= arr[left])
				i++;
			// find element which is less or equal than pivot
			while(arr[j] > arr[left])
				j--;
			// if i anf j are not crossed then swap ith and jth element
			if(i < j ) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// if i and j are crossed then swap pivot with jth element
		int temp  = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;
		//4. Sort both left and right partitions of pivot individually by same method
		quickSort(arr, left, j-1);
		quickSort(arr, j+1, right);
	}

	public static void main(String[] args) {
		int arr[] = {66, 33, 99, 11, 77, 22, 55, 66, 88};
		
		System.out.println("Array Before sort :: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println("Array After sort :: " + Arrays.toString(arr));
	}

}
