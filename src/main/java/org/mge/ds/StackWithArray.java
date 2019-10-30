package org.mge.ds;

import java.util.Arrays;

public class StackWithArray {

	private int[] data;
	private int top = -1;
	private int size = 0;

	public static void main(String[] args) {
		StackWithArray s = new StackWithArray(2);
		System.out.println(s.isEmpty());
		System.out.println(s.capaity());
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.capaity());
		System.out.println(s.isEmpty());
		System.out.println(s.top());
		System.out.println(s.pop());
	}

	public StackWithArray() {
		data = new int[10];
	}

	public StackWithArray(int capacity) {
		data = new int[capacity];
	}

	public void push(int x) {
		if (top + 1 == data.length)
			increaseCapacity();
		data[++top] = x;
		size++;
	}

	public int pop() {
		if (top < 0)
			throw new ArrayIndexOutOfBoundsException(top);
		size--;
		return data[top--];
	}
	
	public int top() {
		return data[top];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void increaseCapacity(){
		data = Arrays.copyOf(data, data.length * 2);
	}
	
	public int capaity(){
		return data.length;
	}

}
