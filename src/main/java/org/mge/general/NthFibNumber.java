package org.mge.general;

public class NthFibNumber {
	public static void main(String[] args) {
		System.out.println(fibSpace(12));
		System.out.println(fibDyn(12));
		System.out.println(fibRec(12));
	}

	public static int fibRec(int n) {
		if (n <= 1)
			return n;

		return fibRec(n - 1) + fibRec(n - 2);
	}

	public static int fibDyn(int n) {
		int[] f = new int[n + 2];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	public static int fibSpace(int n) {
		int a = 0;
		int b = 1;

		for (int i = 2; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
