package ccom.sunbeam;

import java.util.Arrays;

public class bubbleSortMain {

	public static void bubbleSort(int arr[], int size) {
		int passes = 0 , comps = 0;
		//1. write loop to count number of passes
		for(int i = 1 ; i < size ; i++) {	//1, 2, 3, 4, 5 
			passes++;
			//2. write loop to count number of comparisions in every pass
			for(int j = 0  ; j < size - 1 ; j++) {	//0, 1, 2, 3, 4
				comps++;
				//3. compare two consecutive elements
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("No of passes : " + passes);
		System.out.println("No of comps : " + comps);
	}
	
	public static void improvedBubbleSort(int arr[], int size) {
		int passes = 0 , comps = 0;
		//1. write loop to count number of passes
		for(int i = 1 ; i < size ; i++) {	//1, 2, 3, 4, 5 
			passes++;
			//2. write loop to count number of comparisions in every pass
			for(int j = 0  ; j < size - i ; j++) {	//0, 1, 2, 3, 4
				comps++;
				//3. compare two consecutive elements
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("No of passes : " + passes);
		System.out.println("No of comps : " + comps);
	}
	
	public static void furtherimprovedBubbleSort(int arr[], int size) {
		int passes = 0 , comps = 0, flag;
		//1. write loop to count number of passes
		for(int i = 1 ; i < size ; i++) {	//1, 2, 3, 4, 5 
			flag = 0;
			passes++;
			//2. write loop to count number of comparisions in every pass
			for(int j = 0  ; j < size - i ; j++) {	//0, 1, 2, 3, 4
				comps++;
				//3. compare two consecutive elements
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = 1;
				}
			}
			if(flag == 0)
				break;
		}
		System.out.println("No of passes : " + passes);
		System.out.println("No of comps : " + comps);
	}
	
	public static void main(String[] args) {
		//int arr[] = {30, 20, 60, 50, 40, 10};
		int arr[] = {10, 20, 30, 40, 50, 60};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));
		
		//bubbleSort(arr, arr.length);
		//improvedBubbleSort(arr, arr.length);
		furtherimprovedBubbleSort(arr, arr.length);
		
		System.out.println("Array After sort : " + Arrays.toString(arr));

	}

}
