package com.sunbeam;

public class BSTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int val) {
			data = val;
			left = right = null;
		}
	}
	
	private Node root;
	
	public BSTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int val) {
		//1. Create node with given value
		Node newnode = new Node(val);
		//2. if tree is empty
		if(isEmpty())
			//a. add newnode into root itself
			root = newnode;
		//3. if tree is not empty
		else {
			//3.1 create trav referance and start at root
			Node trav = root;
			while(true) {
				//3.2 if value is less than current node data
				if(val < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						//3.2.1.1 add node into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						//3.2.2.1 go on left side of current
						trav = trav.left;
				}
				//3.3 if value is greater or equal than current node data
				else {
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						//3.3.1.1 add node into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						//3.3.2.1 go on right side of current
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 and 3.3 till node is not added into tree
		}
	}
	
	public void preorder(Node trav) {
		if(trav == null)
			return;
		//1. visit current node(print)
		System.out.print(" " + trav.data);
		//2. go in left of current node
		preorder(trav.left);
		//3. go in right of current node
		preorder(trav.right);
	}
	
	public void preorder() {		// wrapper method
		System.out.print("Preorder : ");
		preorder(root);
		System.out.println("");
		
	}
	
	public void inorder(Node trav) {
		if(trav == null)
			return;
		//2. go in left of current node
		inorder(trav.left);
		//1. visit current node(print)
		System.out.print(" " + trav.data);
		//3. go in right of current node
		inorder(trav.right);
	}
	
	public void inorder() {		// wrapper method
		System.out.print("Inorder : ");
		inorder(root);
		System.out.println("");
		
	}
	
	public void postorder(Node trav) {
		if(trav == null)
			return;
		//2. go in left of current node
		postorder(trav.left);
		//3. go in right of current node
		postorder(trav.right);
		//1. visit current node(print)
		System.out.print(" " + trav.data);
	}
	
	public void postorder() {		// wrapper method
		System.out.print("Preorder : ");
		postorder(root);
		System.out.println("");
		
	}
	
	public Node searchNode(int key) {
		//1. start at root node
		Node trav = root;
		while(trav != null) {
			//2. compare key with current node
			//3. if key is equal to current node then return current node
			if(key == trav.data)
				return trav;
			//4. if key is less than current node then search key into left of current node
			else if (key < trav.data)
				trav = trav.left;
			//5. if key is greater than current node then search key into right of current node
			else
				trav = trav.right;
		}//6. repeat step 2 to 5 till key is not found
		//7. if key is not found then return null;
		return null;
	}

}








