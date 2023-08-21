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
	
	public void addPosition(int val, int pos) {
		//0. special condition 1 - pos == 1 or pos == cnt + 1
		//0. special condition 2 - pos < 1 or pos > cnt + 1
		//1. create node with given value
		Node newnode = new Node(val);
		//2. if list is empty
		if(isEmpty())
			//a. add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. traverse till pos-1 node
			Node trav = head;
			for(int i = 1 ; i < pos -1 ; i++)
				trav = trav.next;
			//b. add pos-1 node into prev of newnode
			newnode.prev = trav;
			//c. add pos node into next of newnode
			newnode.next = trav.next;
			//d. add nenwode into prev of pos node
			trav.next.prev = newnode;
			//e. add newnode into next of pos-1 node
			trav.next = newnode;
		}
	}
	
	public void delFirst() {
		//1.  if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move head on second node
			head = head.next;
			//b. make prev of second node equal to null
			head.prev = null;
		}
	}
	
	public void delLast() {
		//1.  if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move tail on second last node
			tail = tail.prev;
			//b. make next of second last node equal to null
			tail.next = null;
		}
	}
	
	public void delPosition(int pos) {
		//0. special condition 1 - pos == 1 or pos == cnt
		//0. special condition 2 - pos < 1 or pos > cnt
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos+1 node into next of pos-1 node
			trav.prev.next = trav.next;
			//c. add pos-1 node into prev of pos+1 node
			trav.next.prev = trav.prev;
		}
	}
}







