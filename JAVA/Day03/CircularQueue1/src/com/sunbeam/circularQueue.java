package com.sunbeam;

public class circularQueue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	private int count;
	public circularQueue(int size) {
		SIZE = size;
		arr = new int[size];
		front = rear = -1;
		count = 0;
	}
	
	public void push(int data) {
		//a. inc rear
		rear = (rear + 1) % SIZE;
		//b. add data at rear index
		arr[rear] = data;
		//c. inc count
		count++;
	}
	
	public void pop() {
		//a. inc front
		front = (front + 1) % SIZE;
		//b. dec count
		count--;
	}
	
	public int peek() {
		//a. read and return data of front + 1 index
		return arr[(front + 1) % SIZE];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == SIZE;
	}
}





