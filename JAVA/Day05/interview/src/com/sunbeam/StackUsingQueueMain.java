package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;

class Stack {
	private Queue<Integer> main;
	private Queue<Integer> temp;
	public Stack() {
		main = new LinkedList<>();
		temp = new LinkedList<>();
	}
	// Time: O(n)
	public void push(int val) {
		while(!main.isEmpty())
			temp.offer(main.poll());
		main.offer(val);
		while(!temp.isEmpty())
			main.offer(temp.poll());
	}
	// Time: O(1)
	public int pop() {
		return main.poll();
	}
	// Time: O(1)
	public int peek() {
		return main.peek();
	}
	// Time: O(1)
	public boolean isEmpty() {
		return main.isEmpty();
	}
}

public class StackUsingQueueMain {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(11);
		s.push(22);
		s.push(33);
		s.push(44);
		while(!s.isEmpty()) {
			int ele = s.pop();
			System.out.println("Popped: " + ele);
		}
	}

}
