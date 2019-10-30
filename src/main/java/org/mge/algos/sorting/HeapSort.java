package org.mge.algos.sorting;


public class HeapSort {
	
	public static void main(String[] args) {
		int arr[] = {35, 21, 4, 1, 12, 42, 71, 55, 26};
		sort(arr);
		print(arr);
	}
	
	private static void print(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void sort(int[] arr){
		buildHeap(arr);
		int n = arr.length;
		int size = n;
		for(int i = 0; i < n; i++) {
			int t = arr[0];
			arr[0] = arr[size - 1];
			arr[size - 1] = t;
			
			size = size - 1;
			
			siftDown(arr, 0, size);
		}
	}
	
	private static void buildHeap(int[] arr){
		int n = arr.length;
		int i = n/2;
		while(i >= 0) {
			siftDown(arr, i, arr.length);
			i--;
		}
	}
	
	private static void siftDown(int[] arr, int i, int n){
		while(true){
			int maxChild = i;
			if(leftChild(i) < n && arr[maxChild] < arr[leftChild(i)]) {
				maxChild = leftChild(i);
			}
			
			if(rightChild(i) < n && arr[maxChild] < arr[rightChild(i)]) {
				maxChild = rightChild(i);
			}
			
			if(maxChild == i)
				break;
			int t = arr[maxChild];
			arr[maxChild] = arr[i];
			arr[i] = t;
			
			i = maxChild;
		}
	}
	
	private static int leftChild(int i){
		return i * 2 + 1;
	}
	
	private static int rightChild(int i) {
		return 2 * i + 2;
	}
	
}
