package org.mge.algos.sorting;

import java.util.Random;

public class DriverProgram {

	public static void main(String[] args) {
		int a[] = { 6, 3, 9, 12, 35, 4, 7, 2 };
		int b[] = { 4,5,7,2,3 };
		InsertionSort.sort(b);
		for (int i : b)
			System.out.print(i + " ");

//		QuickSort.sort(b);
//		System.out.println();
		
//		for (int i : b)
//			System.out.print(i + " ");
//		Random random = new Random();
//		int r = (random.nextInt(15) + 5) % 15;
//		System.out.println();
//		System.out.println(r); Math.ma

	}
}
