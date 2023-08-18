package com.sunbeam;

public class SinglyLinearLinedListMain {

	public static void main(String[] args) {
		linkedList list = new linkedList();
		
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.addLast(50);
		
		list.delFirst();
		list.delLast();
		
		list.displayList();
		
		list.delAll();
	}

}
