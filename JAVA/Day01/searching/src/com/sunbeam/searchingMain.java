package com.sunbeam;

import java.util.Scanner;

public class searchingMain {

	public static int linearSearch(int arr[], int key) {
		// traverse the array from 0 to size-1
		for(int i = 0 ; i < arr.length ; i++) {
			// compare every element of array with key
			if(arr[i] == key)
				return i;	// if key key is found return i
		}
		return -1;	// if key is not found return -1
	}
	
	public static void main(String[] args) {
		int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 44};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key to be searhced : ");
		int key = sc.nextInt();
		
		int index = linearSearch(arr, key);
		if(index != -1)
			System.out.println("Key is found at index - " + index);
		else
			System.out.println("Key is not found");
		
		sc.close();
	}

}
