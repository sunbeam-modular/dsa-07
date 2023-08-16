package com.sunbeam;

public class circularQueue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	
	public circularQueue(int size) {
		SIZE = size;
		arr = new int[size];
		front = rear = -1;
	}
	
	public void push(int data) {
		//a. inc rear
		rear = (rear + 1) % SIZE;
		//b. add data at rear index
		arr[rear] = data;
	}
	
	public void pop() {
		//a. inc front
		front = (front + 1) % SIZE;
		if(rear == front)
			rear = front = -1;
	}
	
	public int peek() {
		//a. read and return data of front + 1 index
		return arr[(front + 1) % SIZE];
	}
	
	public boolean isEmpty() {
		return rear == front && rear == -1;
	}
	
	public boolean isFull() {
		return (front == -1 && rear == SIZE -1) || (rear == front && rear != -1);
	}
}





