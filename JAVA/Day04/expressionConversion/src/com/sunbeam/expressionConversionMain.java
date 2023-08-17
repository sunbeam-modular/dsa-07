package com.sunbeam;

import java.util.Stack;

public class expressionConversionMain {
	
	public static int priority(char opr) {
		switch(opr) {
		case '$':	return 10;
		case '*':	return 9;
		case '/':	return 9;
		case '%':	return 9;
		case '+':	return 8;
		case '-':	return 8;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> st = new Stack<>();
		//1. traverse infix expr from left to right
		for(int i = 0 ; i < infix.length() ; i++) {
			char ele = infix.charAt(i);
			//2. if ele is operand, append it into postfix expr
			if(Character.isDigit(ele))
				postfix.append(ele);
			//5. if ele is '(', push it on stack
			else if(ele == '(')
				st.push(ele);
			//6. if ele is ')', then pop all operators from stack and append into postfix expression till '('
			else if(ele == ')') {
				while(st.peek() != '(')
					postfix.append(st.pop());
				st.pop();
			}
			//3. if ele is operator
			else {
				// if priority of topmost element of stack is greater or equal to current element then pop element from stack and append it into postfix expr
				while ( !st.isEmpty() && priority(st.peek()) >= priority(ele))
					postfix.append(st.pop());
				st.push(ele);
			}
		}
		//4. if infix expression is completed then pop all remaining elements from stack and append into postfix expression one by one
		while(!st.isEmpty()) {
			postfix.append(st.pop());
		}
		return postfix.toString();
	}
	
	public static String infixToPrefix(String infix) {
		StringBuilder prefix = new StringBuilder();
		Stack<Character> st = new Stack<>();
		//1. traverse infix expr from right to left
		for(int i = infix.length()-1 ; i >= 0 ; i--) {
			char ele = infix.charAt(i);
			//2. if ele is operand, append it into prefix expr
			if(Character.isDigit(ele))
				prefix.append(ele);
			//5. if ele is ')', push it on stack
			else if(ele == ')')
				st.push(ele);
			//6. if ele is '(', then pop all operators from stack and append into postfix expression till ')'
			else if(ele == '(') {
				while(st.peek() != ')')
					prefix.append(st.pop());
				st.pop();
			}
			//3. if ele is operator
			else {
				// if priority of topmost element of stack is greater or equal to current element then pop element from stack and append it into postfix expr
				while ( !st.isEmpty() && priority(st.peek()) > priority(ele))
					prefix.append(st.pop());
				st.push(ele);
			}
		}
		//4. if infix expression is completed then pop all remaining elements from stack and append into postfix expression one by one
		while(!st.isEmpty()) {
			prefix.append(st.pop());
		}
		prefix.reverse();
		return prefix.toString();
	}

	public static void main(String[] args) {
		String infix = "1$9+3*4-(6+8/2)+7";
		
		String postfix = infixToPostfix(infix);
		
		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + postfix);
		
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix : " + prefix);

	}

}






