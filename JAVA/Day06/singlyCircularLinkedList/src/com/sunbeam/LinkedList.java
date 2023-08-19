package com.sunbeam;

public class LinkedList {
	static class Node{
		private char data;
		private Node next;
		
		public Node() {
			data = 0;
			next = null;
		}
		public Node(char val) {
			data = val;
			next = null;
		}
	}
	
	private Node head;
	private int count;
	
	public LinkedList() {
		head = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void displayList() {
		if(isEmpty())
			return;
		//1. create trav pointer and start at head
		Node trav = head;
		System.out.print("List : ");
		do {
			//2. print data of current node (trav)
			System.out.print("  " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while (trav != head);	//4. repeat step 2 and 3 till last node
		System.out.println("");
		System.out.println("Node count : " + count);
	}
	
	
	public void addFirst(char val) {
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			head.next = head;
		}else {
		//3. if list is not empty
			//a. add first node into next of newnode
			newnode.next = head;
			//b. traverse till last node
			Node trav = head;
			for( ; trav.next != head ; trav = trav.next);
			//c. add newnode into next of last node
			trav.next = newnode;
			//d. move head on newnode
			head = newnode;
		}
		count++;
	}
	
	public void addLast(char val) {
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			head.next = head;
		} else {
		//3. if list is not empty
			//a. add first node into next of newnode
			newnode.next = head;
			//b. traverse till last node
			Node trav = head;
			for( ; trav.next != head ; trav = trav.next);
			//c. add newnode into next of last node
			trav.next = newnode;
		}
		count++;
	}
	
	public void addPosition(char val, int pos) {
		// validate position -- 1 to Nodecount + 1 are valid positions
		if(pos < 1 || pos > count + 1)
			return;
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			head.next = head;
		}else if(pos == 1) {
			addFirst(val);
			return;
		}else {
		//3. if list is not empty
			//a. traverse till pos - 1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add nenwode into next of pos-1 node
			trav.next = newnode;
		}
		count++;
	}
	
	public void delFirst() {
		//1. if list is empty
		if(isEmpty())
			// do nothing
			return;
		//2. if list has single node
		else if(head.next == head)
			//a. make head = null
			head = null;
		//2. if list multiple nodes
		else {
			//a. traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			//b. add second node into next of last node
			trav.next = head.next;
			//c. move head on second node
			head = head.next;
		}
		count--;
	}
	
	public void delLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == head)
			//a. make head = null
			head = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			for( ; trav.next.next != head ; trav = trav.next);
			//b. add first node into next of second last node
			trav.next = head;
		}
		count--;
	}
	
	public void delPosition(int pos) {
		//validate position - 1 to node count are valid poitions
		if(pos < 1 || pos > count)
			return;
		//1. if list is empty
		if(isEmpty())
			// do nothing
			return;
		//2. if list has single node
		else if (head.next == head)
			//a. make head = null
			head = null;
		else if(pos == 1) {
			delFirst();
			return;
		}
		//3. if list has multiple nodes
		else {
			//a. traverse till pos -1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos + 1 node into next of pos - 1 node
			trav.next = trav.next.next;
		}
		count--;
	}

}







