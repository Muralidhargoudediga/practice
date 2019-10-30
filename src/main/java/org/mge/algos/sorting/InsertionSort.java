package org.mge.algos.sorting;

public class InsertionSort {
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int value = a[i];
			int p = i;
			while (p > 0 && a[p - 1] > value) {
				a[p] = a[p - 1];
				p--;
			}

			a[p] = value;
		}
	}
}
