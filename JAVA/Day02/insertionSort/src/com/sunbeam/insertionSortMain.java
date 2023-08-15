package com.sunbeam;

public class insertionSortMain {
	
	public static void insertionSort(int arr[], int size) {
		//1. count number of passes
		for(int i = 1 ; i < size ; i++) {
			//2. take backup of one element
			int j, temp = arr[i];
			//3. compare backuped element with all its left neighbours
			for(j = i - 1 ; j >= 0 && arr[j] > temp ; j--)
				arr[j + 1] = arr[j];
			//4. insert element at its appropriate position
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = {50, 40, 20, 60, 10, 30};
		
		System.out.println("Array before sort : ");
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print("  " + arr[i]);
		System.out.println("");
		
		insertionSort(arr, arr.length);
		
		System.out.println("Array after sort : ");
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print("  " + arr[i]);

	}

}
