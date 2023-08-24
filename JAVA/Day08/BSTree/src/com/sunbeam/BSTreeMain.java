package com.sunbeam;

import com.sunbeam.BSTree.Node;

public class BSTreeMain {

	public static void main(String[] args) {
		
		BSTree bst = new BSTree();
		
		bst.addNode(8);
		bst.addNode(3);
		bst.addNode(10);
		bst.addNode(1);
		bst.addNode(6);
		bst.addNode(14);
		bst.addNode(4);
		bst.addNode(7);
		bst.addNode(13);
		
		bst.preorder();
		bst.inorder();
		bst.postorder();
		
		Node ret =  bst.searchNode(15);
		if(ret != null)
			System.out.println("Key is found");
		else
			System.out.println("Key is not found");

	}

}