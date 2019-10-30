package org.mge.algos.sorting;

public class BubbleSort {
	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
					flag = false;
				}
			}
			if (flag)
				break;
		}
	}
}
