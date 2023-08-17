package com.sunbeam;

public class stack {
	private int arr[];
	private int top;
	private final int SIZE;
	
	public stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = -1;
	}
	
	public void push(int data) {
		//a. reposition top
		top++;
		//b. add data at top index
		arr[top] = data;
	}
	
	public int pop() {
		int data = arr[top];
		//a. reposition top
		top--;
		return data;
	}
	
	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return  top == SIZE -1;
	}
	

}





