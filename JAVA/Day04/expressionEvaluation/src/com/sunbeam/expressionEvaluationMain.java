package com.sunbeam;

public class expressionEvaluationMain {
	
	public static int calculate(int op1, int op2, char opr) {
		switch(opr) {
		case '+':	return op1 + op2;
		case '-':	return op1 - op2;
		case '*':	return op1 * op2;
		case '/':	return op1 / op2;
		case '%':	return op1 % op2;
		case '$':	return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int postfixEvaluate(String postfix) {
		stack st = new stack(10);
		//1. process postfix expr from left to right
		for(int i = 0 ; i < postfix.length() ; i++) {
			char ele = postfix.charAt(i);
			//2. if ele is operand, push it on stack (char --> int)
			if(Character.isDigit(ele))
				st.push(ele - '0');
			//3. if ele is operator. pop 2 elements from stack, perform arithmetic
			else {
				int op2 = st.pop();
				int op1 = st.pop();
				int res = calculate(op1, op2, ele);
				st.push(res);
			}
		}
		//4. when all elements form postfix are completed , pop result from  stack and return it
		int res = st.pop();
		return res;
	}
	
	public static int prefixEvaluate(String prefix) {
		stack st = new stack(20);
		//1. process prefix expr from right to left
		for(int i = prefix.length()-1 ; i >= 0 ; i--) {
			char ele = prefix.charAt(i);
			//2. if ele is operand, push it on stack (char --> int)
			if(Character.isDigit(ele))
				st.push(ele - '0');
			//3. if ele is operator. pop 2 elements from stack, perform arithmetic
			else {
				int op1 = st.pop();
				int op2 = st.pop();
				int res = calculate(op1, op2, ele);
				st.push(res);
			}
		}
		//4. when all elements form prefix are completed , pop result from  stack and return it
		int res = st.pop();
		return res;
	}


	public static void main(String[] args) {
		String postfix = "456*3/+9+7-";
		
		int result = postfixEvaluate(postfix);
		System.out.println(postfix + " : " + result);
		
		String prefix = "-++4/*56397";
		
		result = prefixEvaluate(prefix);
		System.out.println(prefix + " : " + result);

	}

}
