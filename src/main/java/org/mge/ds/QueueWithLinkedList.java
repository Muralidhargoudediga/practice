package org.mge.ds;

import java.util.NoSuchElementException;


public class QueueWithLinkedList {
	
	private Node head;
	private Node tail;
	private int size;

	public static void main(String[] args) {
		QueueWithLinkedList q = new QueueWithLinkedList();
		System.out.println(q.size);
		q.enqueue(1);
		System.out.println(q.dequeue());
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.size);
		System.out.println(q.dequeue());
		q.enqueue(6);
		q.enqueue(7);
		System.out.println(q.dequeue());
	}
	
	public void enqueue(int x){
		Node node = new Node(x);
		if(head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public int dequeue(){
		if(size == 0)
			throw new NoSuchElementException();
		int data = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		size--;
		return data;
	}

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
}
