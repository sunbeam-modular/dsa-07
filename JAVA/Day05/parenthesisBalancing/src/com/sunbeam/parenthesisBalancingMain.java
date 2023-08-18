package com.sunbeam;

import java.util.Stack;

public class parenthesisBalancingMain {
	
	public static boolean isParenthesisBalanced(String expr) {
		String opening = "([{";
		String closing = ")]}";
		Stack<Character> st = new Stack <>();
		//1. traverse expr from start to end
		for(int i = 0 ; i < expr.length() ; i++) {
			char ele = expr.charAt(i);
			//2. if ele is opening parenthesis { or ( or [, then push it on stack
			if(opening.indexOf(ele) != -1)
				st.push(ele);
			//3. if ele is closing parenthesis } or ) or ], then check stack is empty or not, if not empty, then pop one ele from stack and compare
			else {
				int closingIndex = closing.indexOf(ele);
				if(closingIndex != -1) {
					if(st.isEmpty())
						return false;
					char open = st.pop();
					int openingIndex = opening.indexOf(open);
					if(openingIndex != closingIndex)
						return false;
				}
			}
		}
		// if stack is not empty, then one or more extra opening brackets are there
		if(!st.isEmpty())
			return false;
		//4. if all parenthesis are finished return true
		return true;
	}

	public static void main(String[] args) {
		String expr = "5+([9-4]*(8-{6/2}])";
		boolean balanced = isParenthesisBalanced(expr);
		System.out.println("Parenthesis Balanced : " + balanced);
	}

}



