package com.sunbeam;

class SinglyLinearList {
	static class Node {
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
	
	private Node head;
	private Node tail;

	public SinglyLinearList() {
		head = null;
		tail = null;
	}
	// time: O(1)
	public boolean isEmpty() {
		return (head == null);
	}
	// time: O(1)
	public void addLast(int val) {
		Node nn = new Node(val);
		if(isEmpty()) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
	}
	// time: O(1)
	public void addFirst(int val) {
		Node nn = new Node(val);
		if(isEmpty()) {
			head = nn;
			tail = nn;
		} else {
			nn.next = head;
			head = nn;
		}
	}
	// time: O(1)
	public int delFirst() {
		int val = 0;
		if(!isEmpty()) {
			val = head.data;
			if(head.next == null) {
				head = null;
				tail = null;
			}
			else {
				head = head.next;
			}
		}
		return val;
	}
}

public class SinglyLinearListMain {
	public static void main(String[] args) {
		SinglyLinearList s = new SinglyLinearList();
		int val;
		
		/*
		val = 10;
		s.addFirst(val);
		System.out.println("Add: " + val);
		val = 20;
		s.addFirst(val);
		System.out.println("Add: " + val);
		val = 30;
		s.addFirst(val);
		System.out.println("Add: " + val);
		val = 40;
		s.addFirst(val);
		System.out.println("Add: " + val);
		
		while(!s.isEmpty()) {
			val = s.delFirst();
			System.out.println("Removed: " + val);
		}
		*/
		
		val = 10;
		s.addLast(val);
		System.out.println("Add: " + val);
		val = 20;
		s.addLast(val);
		System.out.println("Add: " + val);
		val = 30;
		s.addLast(val);
		System.out.println("Add: " + val);
		val = 40;
		s.addLast(val);
		System.out.println("Add: " + val);
		
		while(!s.isEmpty()) {
			val = s.delFirst();
			System.out.println("Removed: " + val);
		}
	}
}
