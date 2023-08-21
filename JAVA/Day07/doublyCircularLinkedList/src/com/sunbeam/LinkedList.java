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

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void fDisplay() {
		if(isEmpty())
			return;
		//1. create trav and start at head
		Node trav = head;
		System.out.print("Forward List : ");
		do {
			//2. print data of current node
			System.out.print("  " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);	//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void rDisplay() {
		if(isEmpty())
			return;
		//1. create trav and start at last node
		Node trav = head.prev;
		System.out.print("Backward List : ");
		do {
			//2. print data of current node
			System.out.print("  " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}while(trav != head.prev);	//4. repeat step 2 and 3 till first node
		System.out.println("");
	}

	public void addFirst(int val) {
		//a. create a node using given value
		Node nn = new Node(val);
		//b. if list is empty
		if(isEmpty()) {
			//1. add newnode into head
			head = nn;
			//2. make list circular
			nn.next = nn.prev = nn;
		}else {
		//c. if list is not empty
			//1. add first node into next of newnode
			nn.next = head;
			//2. add last node into prev of newnode
			nn.prev = head.prev;
			//3. add newnode into next of last node
			head.prev.next = nn;
			//4. add newnode into prev of first node
			head.prev = nn;
			//5. add newnode into head
			head = nn;
		}
	}
	
	public void addLast(int val) {
		//a. create node
		Node nn = new Node(val);
		//b. if list is empty
		if(isEmpty()) {
			//1. add newnode into head
			head = nn;
			//2. make list circular
			nn.next = nn.prev = nn;
		}else {
		//c. if list is not empty
			//1. add first node into next of newnode
			nn.next = head;
			//2. add last node into prev of newnode
			nn.prev = head.prev;
			//3. add newnode into next of last node
			head.prev.next = nn;
			//4. add nenwode into prev of first node
			head.prev = nn;
		}
	}
	
	public void addPosition(int val, int pos) {
		//1. create node
		Node nn = new Node(val);
		//2. if list is empty
		if(isEmpty()) {
			//add newnode into head
			head = nn;
			//make list circular
			nn.next = nn.prev = nn;
		}else if(pos == 1) {
			addFirst(val);
		}else {
		//3. if list is not empty
			//traverse till pos-1 node
			Node trav = head;
			for(int i = 1 ; i < pos -1 ; i++)
				trav = trav.next;
			//add pos node into next of nn
			nn.next = trav.next;
			//add pos-1 node into prev of nn
			nn.prev = trav;
			//add nn into next of pos-1 node
			trav.next = nn;
			//add nn into prev of pos node
			nn.next.prev = nn;
		}
	}
	
	public void delFirst() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. add last node into prev of second node
			head.next.prev= head.prev;
			//b. add second node into next of last node
			head.prev.next = head.next;
			//c. add second node into head
			head = head.next;
		}
	}
	
	public void delLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. add first node into next of second last node
			head.prev.prev.next = head;
			//b. add second last node into prev of first node
			head.prev = head.prev.prev;
		}
	}
	
	public void delPosition(int pos) {
		//0. special 1 - invalid position : pos < 1 or pos > cnt + 1
		//0. special 2 - pos == 1
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if (head.next == head)
			head = null;
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






