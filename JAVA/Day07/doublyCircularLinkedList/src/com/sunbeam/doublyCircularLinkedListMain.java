package com.sunbeam;

public class doublyCircularLinkedListMain {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.addLast(50);
		list.addLast(60);
		list.addPosition(70, 3);
		
		//list.delFirst();
		//list.delLast();
		list.delPosition(4);
		
		list.fDisplay();
		list.rDisplay();

	}

}
