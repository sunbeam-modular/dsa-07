package com.sunbeam;

public class HashTable_ClosedAddressingMain {

	public static void main(String[] args) {
		HashTable tbl = new HashTable();
		
		tbl.put(8, "v1");
		tbl.put(3, "v2");
		tbl.put(10, "v3");
		tbl.put(4, "v4");
		tbl.put(6, "v5");
		tbl.put(13, "v6");
		tbl.put(23, "v7");
		tbl.put(26, "v8");
		
		String ret = tbl.search(33);
		if(ret != null)
			System.out.println("Key is found and value = " + ret);
		else
			System.out.println("Key is not found");

	}

}
