package com.sunbeam;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
	static class Entry{
		private int key;
		private String value;
		
		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}
	
	private final int SIZE = 10;
	private List<Entry> table[];
	
	public HashTable() {
		table = new List[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			table[i] = new LinkedList<>();
	}
	
	public int h(int k) {
		return  k % SIZE;
	}
	
	public void put(int key, String value) {
		//1. find slot corresponding to key
		int slot = h(key);
		
		//check if key is already exist, and if exist then update the older value
		if(!table[slot].isEmpty()) {
			for(Entry ent : table[slot]) {
				if(ent.key == key) {
					ent.value = value;
					return;
				}
			}
		}
		// create a new entry and add into list of corresponding slot
		Entry ent = new Entry(key, value);
		table[slot].add(ent);
	}
	
	public String search(int key) {
		//1. find slot corresponding to key
		int slot = h(key);		//hashcode

		//check if key is already exist, and if exist then update the older value
		if(!table[slot].isEmpty()) {
			for(Entry ent : table[slot]) {
				if(ent.key == key) {		// equals
					return ent.value;
				}
			}
		}
		return null;
	}
}










