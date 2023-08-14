package com.sunbeam;

import java.util.Scanner;

public class binarySearchMain {

	public static int binarySearch(int arr[], int key) {
		//1. decide left and right of array
		int left = 0, right = arr.length-1, mid;
		while(left <= right) {
			//2. find middle element of array
			mid = (left + right)/2;
			//3. compare middle element with key
			if(key == arr[mid])
				return mid;			// if key is found return mid
			else if(key < arr[mid])		//4. if key is less than middle element then search it in left sub array
				right = mid - 1;	
			else //5. if key is greater than middle element then search it in right sub array
				left = mid + 1;
		}//6. repeat step 2 to 5 untill key is not found or partition is valid
		return -1;		//7. if key is not found return -1
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int  index = binarySearch(arr, key);
		if(index != -1)
			System.out.println("Key is found at index : " + index);
		else
			System.out.println("Key is not found");
		
		sc.close();
		
	}

}





