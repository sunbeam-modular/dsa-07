package com.sunbeam;

import java.util.Scanner;

public class CircularQueueMain {

	public static void main(String[] args) {
		circularQueue q = new circularQueue(5);
		int choice, data;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("0. Exit");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:	// push
					if(q.isFull())
						System.out.println("Queue is full");
					else {
						System.out.println("Enter data to be inserted : ");
						data = sc.nextInt();
						q.push(data);
					}
					break;
					
				case 2: // pop
					if(q.isEmpty())
						System.out.println("Queue is Empty");
					else {
						q.pop();
					}
					break;
					
				case 3:  // peek
					if(q.isEmpty())
						System.out.println("Queue is Empty");
					else
						System.out.println("Peeked Data : " + q.peek());
					break;
			}
		}while(choice != 0);
		
		sc.close();


	}

}
