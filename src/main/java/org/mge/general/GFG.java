package org.mge.general;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] a = new int[N];

			for (int k = 0; k < N; k++) {
				a[k] = Integer.parseInt(s[k]);
			}

			int d = Integer.parseInt(br.readLine());

			int result = extractKthMin(a, d, 0, N - 1);
			System.out.println(result);
		}
	}

	public static int extractKthMin(int[] a, int k, int l, int r) {

		int p = partition(a, l, r);

		if (p == k - 1) {
			return a[p];
		}

		if (p > k - 1) {
			return extractKthMin(a, k, l, p - 1);
		}

		return extractKthMin(a, k, p + 1, r);
	}

	static int partition(int[] a, int s, int e) {
		int i = s;
		int pIndex = (int) (Math.random() * (e - s));
		int t = a[s + pIndex];
		a[s + pIndex] = a[e];
		a[e] = t;
		int p = a[e];
		for (int j = s; j < e; j++) {
			if (a[j] <= p) {
				t = a[j];
				a[j] = a[i];
				a[i] = t;
				i++;
			}
		}

		t = a[i];
		a[i] = a[e];
		a[e] = t;

		return i;
	}
}
