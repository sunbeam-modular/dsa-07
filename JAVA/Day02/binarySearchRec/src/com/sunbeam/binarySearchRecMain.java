package com.sunbeam;

public class binarySearchRecMain {
	
	public static int binarySearchRec(int arr[] , int key, int left, int right) {
		//0. stop if partition is invalid
		if(left > right)
			return -1;
		//1. find mid of the array
		int i, mid = (left + right)/2;
		//2. compare middle element with key
		if(key == arr[mid])
			return mid;
		//3. if key is less than middle element then search key into left sub array
		else if(key < arr[mid])
			i =  binarySearchRec(arr, key, left, mid - 1);
		//4. if key is greater than middle element then serach key into right sub array
		else
			i =  binarySearchRec(arr, key, mid + 1, right);
		return i;
	}

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		int index = binarySearchRec(arr, 66, 0, arr.length-1);
		if(index != -1)
			System.out.println("Key is found at index : " + index);
		else
			System.out.println("Key is not found");

	}

}
