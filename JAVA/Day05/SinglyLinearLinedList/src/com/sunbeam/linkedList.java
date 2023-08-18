package com.sunbeam;

public class linkedList {
	static class Node{
		private int data;
		private Node next;
		public Node() {
			data = 0;
			next = null;
		}
		public Node(int val) {
			data = val;
			next = null;
		}
	}
	
	Node head;
	
	public linkedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int val) {
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head itself
			head = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. move head on newnode
			head = newnode;
		}
	}
	
	public void displayList() {
		//1. create trav referance and start pointing it on head
		Node trav = head;
		System.out.print("List :: ");
		while(trav != null) {
			//2. print data of current node (trav)
			System.out.print("  " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void addLast(int val) {
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head
			head = newnode;
		//3. if list is not empty
		else {
			//a. traverse till last node (trav = last node)
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			//b. add newnode into next of last node
			trav.next = newnode;
		}
	}
	
	public void delFirst() {
		//1. if list is empty
		if(isEmpty())
			// do nothing
			return;
		//2. if list is not empty
		else
			//a. move head on second node
			head = head.next;
	}
	
	public void delLast() {
		//1. if list is empty
		if(isEmpty())
			//do nothing
			return;
		//2. if list has single node
		else if(head.next == null)
			//a. make head equal to null
			head = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != null)
				trav = trav.next;
			//b. make next of second last node equal to null
			trav.next = null;
		}
	}
	
	public void delAll() {
		//Make head equal to null
		head = null;
	}

}
















