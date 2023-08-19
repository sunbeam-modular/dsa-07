package com.sunbeam;

public class LinkedList {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		
		public Node(int val) {
			data = val;
			next = prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public LinkedList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void displayForward() {
		// forward display
		//1. create trav referance and start at head
		Node trav = head;
		System.out.print("Forward List :: ");
		while(trav != null) {
			//2. print data of current node
			System.out.print("  " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void displayBackward() {
		// backward display
		//1. create trav referance and start at tail
		Node trav = tail;
		System.out.print("Backward List :: ");
		while(trav != null) {
			//2. print data of current node
			System.out.print("  " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}//4. repeat step 2 and 3 till first node
		System.out.println("");
	}
	
	public void addFirst(int val) {
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
	}
	
	public void addLast(int val) {
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
	}

}







