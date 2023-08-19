package com.sunbeam;

public class singlyCircularLinkedListMain {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.addFirst('E');
		list.addFirst('N');
		list.addFirst('U');
		list.addFirst('P');
		list.addLast('S');
		list.addLast('U');
		list.addLast('N');
		//list.addPosition('#', 1);
		
		//list.delFirst();
		//list.delLast();
		list.delPosition(8);
		list.displayList();
	}

}
