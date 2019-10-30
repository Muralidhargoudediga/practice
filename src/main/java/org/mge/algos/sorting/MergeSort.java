package org.mge.algos.sorting;

public class MergeSort {
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		sort(a, low, mid);
		sort(a, mid + 1, high);

		merge(a, low, mid + 1, high);
	}

	private static void merge(int[] a, int low, int mid, int high) {
		int[] aux = new int[a.length];

		for (int i = low; i <= high; i++) {
			aux[i] = a[i];
		}

		int i = low, j = mid, k = low;
		while (i < mid && j <= high) {
			if (aux[i] > aux[j]) {
				a[k] = aux[j];
				j++;
			} else if (aux[i] <= aux[j]) {
				a[k] = aux[i];
				i++;
			} 
			k++;
		}

		while (i < mid) {
			a[k++] = aux[i++];
		}

		while (j < high) {
			a[k++] = aux[j++];
		}
	}
}
