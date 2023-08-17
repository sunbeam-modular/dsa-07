package com.sunbeam;

import java.util.Scanner;

public class stackMain {

	public static void main(String[] args) {
		stack st = new stack(5);
		int choice, data;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					if(st.isFull())
						System.out.println("Stack is full...");
					else {
						System.out.println("Enter data : ");
						data = sc.nextInt();
						st.push(data);
					}
					break;
					
				case 2:
					if(st.isEmpty())
						System.out.println("Stack is Empty...");
					else {
						data = st.pop();
						System.out.println("Poped Data : " + data);
					}
					break;
					
				case 3:
					if(st.isEmpty())
						System.out.println("Stack is Empty....");
					else
						System.out.println("Peeked Data : " + st.peek());
					break;
			}
		}while(choice != 0);
		
		
		sc.close();
	}

}







