package com.sunbeam;

import java.util.Arrays;

public class mergeSortMain {
	
	public static void mergeSort(int arr[], int left, int right) {
		//0. stop if partition has single element
		if(left == right)
			return;
		//1. Divide array into parts
		int mid = (left + right)/2;
		//2. Sort both partitions individually by applying same method
		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);
		//3. merge both sorted partitions into temp array in such a way that temp array is also sorted
		int i = left, j = mid + 1, k = 0;
		int size = right - left + 1;
		int temp[] = new int[size];
		while(i <= mid && j <= right) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			}else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		//if right partition is finished then add remaining elements of left partition into temp array
		while(i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		//if left partition is finished then add remaining elements of right partition into temp array
		while(j <= right) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		//4. overwrite temp array into original array
		for(i = 0 ; i < size ; i++)
			arr[i + left] = temp[i];
	}

	public static void main(String[] args) {
		int arr[] = {6, 1, 9, 3, 7, 2, 8, 4, 5};
		
		System.out.println("Array Before sort :: " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Array After sort :: " + Arrays.toString(arr));
	}

}
