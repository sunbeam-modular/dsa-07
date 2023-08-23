package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		private boolean visited;
		
		public Node(int val) {
			data = val;
			left = right = null;
			visited = false;
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
		System.out.print("Postorder : ");
		postorder(root);
		System.out.println("");
		
	}
	
	public void preOrderNonRecursive() {
		Stack<Node> st = new Stack <>();
		//1. start traversing from root
		Node trav = root;
		System.out.print("Preorder :: ");
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//2. visit trav
				System.out.print(" " + trav.data);
				//3. if trav has right, push trav->right on stack
				if(trav.right != null)
					st.push(trav.right);
				//4. go to left of trav
				trav = trav.left;
			}//5. repeat 2-4 until trav is null
			//6. pop node from stack into trav
			if(!st.isEmpty())
				trav = st.pop();
		}//7. repeat 2-6, until trav is null or stack is empty
		System.out.println("");
	}
	
	public void inOrderNonRecursive() {
		Stack<Node> st = new Stack <>();
		//1. start traversing from root
		Node trav = root;
		System.out.print("Inorder :: ");
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//2. push trav on stack
				st.push(trav);
				//3. go to left of trav
				trav = trav.left;
			}//4. repeat 2-3 until trav is null
			//5. pop node from stack into trav
			if(!st.isEmpty())
				trav = st.pop();
			//6. visit trav
			System.out.print(" " + trav.data);
			//7. go to the right
			trav = trav.right;
		}//8. repeat 2-7, until trav is null or stack is empty
		System.out.println("");
	}
	
	public void postOrderNonRecursive() {
		Stack<Node> st = new Stack <>();
		// start trav from root
		Node trav = root;
		System.out.print("Postorder :: ");
		// while trav is not null or stack is not empty
		while(trav != null || !st.isEmpty()) {
			// until null is reached
			while(trav != null) {
				// push trav on stack
				st.push(trav);
				// go to trav's left
				trav = trav.left;
			}
			// if stack is not empty
			if(!st.isEmpty()) {
				// pop node from stack into trav
				trav = st.pop();
				// if trav's right is not present or visited
				if(trav.right == null || trav.right.visited == true) {
					// visit trav & mark it as visited
					System.out.print(" " + trav.data);
					trav.visited = true;
					// make trav null (so that next node will be popped from stack)
					trav = null;
				}else {// otherwise
					// push node on stack
					st.push(trav);
					// go to its right
					trav = trav.right;
				}
			}
		}
		System.out.println("");
	}
	
	public void DFS() {
		Stack<Node> st = new Stack <>();
		//1. push root on stack
		st.push(root);
		System.out.print("DFS : ");
		while(!st.isEmpty()) {
			//2. pop node from stack
			Node trav = st.pop();
			//3. visit poped node
			System.out.print(" " + trav.data);
			//4. if popped node has right
			if(trav.right != null)
				st.push(trav.right);// push it on stack
			//5. if poped node has left
			if(trav.left != null)
				st.push(trav.left);// push it on stack
		}//6. repeat step 2 to 5 till stack iss not empty 
		System.out.println("");
	}
	
	public void BFS() {
		Queue<Node> q = new LinkedList<>();
		//1. push root on queue
		q.offer(root);
		System.out.print("BFS : ");
		while(!q.isEmpty()) {
			//2. pop node from queue
			Node trav = q.poll();
			//3. visit poped node
			System.out.print(" " + trav.data);
			//4. if poped node has left
			if(trav.left != null)
				q.offer(trav.left);// push it on queue
			//5. if popped node has right
			if(trav.right != null)
				q.offer(trav.right);// push it on queue
		}//6. repeat step 2 to 5 till stack iss not empty 
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
	
	public Node[] searchNodeWithParentt(int key) {
		Node parent = null;
		//1. start at root node
		Node trav = root;
		while(trav != null) {
			//2. compare key with current node
			//3. if key is equal to current node then return current node
			if(key == trav.data)
				break;
			parent = trav;
			//4. if key is less than current node then search key into left of current node
			if (key < trav.data)
				trav = trav.left;
			//5. if key is greater than current node then search key into right of current node
			else
				trav = trav.right;
		}//6. repeat step 2 to 5 till key is not found
		if(trav == null)
			parent = null;
		//7. if key is not found then return null;
		return new Node[] {trav, parent};
	}
	
	public void deleteNode(int key) {
		//1. search node with its parent
		Node []arr = searchNodeWithParentt(key);
		Node temp = arr[0], parent = arr[1];
		// if node is not found
		if(temp == null)
			return;
		//2. check if node has 2 childs
		if(temp.left != null && temp.right != null){
			Node pred = temp.left;
			parent = temp;
			while(pred.right != null){
				parent = pred;
				pred = pred.right;	
			}
			temp.data = pred.data;
			temp = pred;
		}
		//3. check if single child(right child)
		if(temp.left == null){
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp .right;
			else
				parent.right = temp.right;
		}
		//4. check if single chile(left child)
		else if(temp.right == null){
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else
				parent.right = temp.left;
		}
	}
	
	public int height(Node trav) {
		//0. if left or right sub tree is absent 
		if(trav == null)
			return 0;	//then return 0
		//1. find height of left subtree
		int hl = height(trav.left);
		//2. find height of right subtree
		int hr = height(trav.right);
		//3. find max height
		int max = Integer.max(hl, hr);
		//4. add one into max height(return)
		return max + 1;
	}
	
	public int height() {
		return height(root);
	}

}








