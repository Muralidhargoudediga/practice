package org.mge.ds.tree;

import java.util.NoSuchElementException;

public class MaxHeap {
	
	private int size;
	private int capacity;
	private int[] heap;

	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();
		h.add(1);
		h.add(3);
		h.add(5);
		h.add(2);
		System.out.println(h.extractMax());
		System.out.println(h.getMax());
		h.remove(3);
		System.out.println(h.extractMax());
	}
	
	public MaxHeap(){
		capacity = 10;
		heap = new int[capacity];
	}
	
	public void add(int p) {
		heap[size] = p;
		siftUp(size);
		size++;
	}
	
	public int getMax(){
		if(size == 0)
			throw new NoSuchElementException();
		return heap[0];
	}
	
	public int extractMax(){
		int d = heap[0];
		heap[0] = heap[size - 1];
		size = size - 1;
		siftDown(0);
		return d;
	}
	
	public void remove(int p) {
		int i = indexOf(p);
		heap[i] = Integer.MAX_VALUE;
		siftUp(i);
		extractMax();
	}
	
	public int indexOf(int p){
		for(int i = 0; i < size; i++){
			if(p == heap[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private void siftUp(int i){
		while(i > 0 && heap[parent(i)] < heap[i]) {
			int t = heap[parent(i)];
			heap[parent(i)] = heap[i];
			heap[i] = t;
			i = parent(i);
		}
	}
	
	private void siftDown(int i) {
		int maxChild = -1;
		while(true) {
			maxChild = i;
			if(leftChild(i) < size && heap[maxChild] < heap[leftChild(i)]) {
				maxChild = leftChild(i);
			}
			
			if(rightchild(i) < size && heap[maxChild] < heap[rightchild(i)]) {
				maxChild  = rightchild(i);
			}
			
			if(maxChild == i)
				break;
			int t = heap[maxChild];
			heap[maxChild] = heap[i];
			heap[i] = t;
			i = maxChild;
		}
	}
	
	private int parent(int i) {
		return (i-1) / 2;
	}
	
	private int leftChild(int i){
		return 2 * i + 1;
	}
	
	private int rightchild(int i) {
		return 2 * i + 2;
	}

}
