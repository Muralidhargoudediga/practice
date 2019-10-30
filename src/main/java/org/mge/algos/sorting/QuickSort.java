package org.mge.algos.sorting;

public class QuickSort {
	public static void sort(int a[]) {
		sort(a, 0, a.length - 1);
	}

	public static void sort(int[] a, int s, int e) {
		if (s >= e)
			return;
		int pIndex = partition(a, s, e);

		sort(a, s, pIndex - 1);
		sort(a, pIndex + 1, a.length - 1);
	}

	private static int partition(int[] a, int s, int e) {
		int pIndex = s;
		int pivot = a[e];

		for (int i = s; i < e; i++) {
			if (a[i] <= pivot) {
				int t = a[i];
				a[i] = a[pIndex];
				a[pIndex] = t;
				pIndex++;
			}
		}

		int t = a[pIndex];
		a[pIndex] = a[e];
		a[e] = t;
		return pIndex;
	}
}
