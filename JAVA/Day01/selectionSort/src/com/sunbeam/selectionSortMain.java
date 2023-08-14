package com.sunbeam;

public class selectionSortMain {
	
	public static void selectionSort(int arr[]) {
		//1. select one position of array
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			//2. compare selected element with all other elements of array
			for(int j = i + 1 ; j < arr.length ; j++) {
				if(arr[i] > arr[j]) {	// if selected element is greater than other element then swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
	}
	
	public static void displayArray(int arr[]) {
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print("  " + arr[i]);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {40, 10, 50, 20, 60, 30};
		
		System.out.print("Array before sort : ");
		displayArray(arr);
		
		selectionSort(arr);
		
		System.out.print("Array After sort : ");
		displayArray(arr);
		
	}

}
