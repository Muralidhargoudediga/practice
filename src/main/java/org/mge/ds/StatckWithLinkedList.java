package org.mge.ds;

import java.util.NoSuchElementException;

public class StatckWithLinkedList {

	private Node head;
	private int size;
	public static void main(String[] args) {
		StatckWithLinkedList s = new StatckWithLinkedList();
		System.out.println(s.isEmpty());
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.isEmpty());
		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.top());
	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;
	}
	
	public int pop() {
		if(head == null)
			throw new NoSuchElementException();
		int data = head.data;
		head = head.next;
		size--;
		return data;
	}
	
	public int top(){
		if(head == null)
			throw new NoSuchElementException();
		return head.data;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
}
