package org.mge.ds.arrays;

public class FindDuplicates {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 2, 4, 6, 3};
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[Math.abs(arr[i])] < 0) {
				System.out.println(Math.abs(arr[i]) + " ");
			} else {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
		}
	}
}
