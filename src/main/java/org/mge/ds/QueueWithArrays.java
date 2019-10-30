package org.mge.ds;

import java.util.NoSuchElementException;

public class QueueWithArrays {
	
	private int[] data;
	private int size;
	private int read;
	private int write;
		
	public static void main(String[] args) {
		QueueWithArrays q = new QueueWithArrays(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.size);
		System.out.println(q.dequeue());
		q.enqueue(6);
		q.enqueue(7);
		System.out.println(q.dequeue());
		System.out.println(q.data.length);
	}
	
	public QueueWithArrays() {
		data = new int[10];
	}
	
	public QueueWithArrays(int capacity) {
		data = new int[capacity];
	}
	
	public void enqueue(int x) {
		if(size == data.length)
			increaseCapacity();
		data[write] = x;
		write = (write + 1) % data.length;
		size++;
	}
	
	public int dequeue(){
		if(size == 0)
			throw new NoSuchElementException();
		int d = data[read];
		read = (read + 1) % data.length;
		size--;
		return d;
	}
	
	private void increaseCapacity(){
		int[] newData = new int[data.length * 2];
		int r = read;
		int w = write;
		int k = 0;
		if(r < w){
			while(r < w) {
				newData[k++] = data[r++];
			}
		} else {
			int i = 0;
			
			while(r < data.length) {
				newData[k++] = data[r++];
			}
			
			while(i < w) {
				newData[k++] = data[i++];
			}
		}
		
		read = 0;
		write = k;
		data = newData;
	}
}
