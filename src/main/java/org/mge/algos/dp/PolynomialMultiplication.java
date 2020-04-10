package org.mge.algos;

public class PolynomialMultiplication {

	public static void main(String[] args) {
		int[] a = {4, 3, 2, 1};
		int[] b = {1, 2, 3, 4};
		int res[] = new int[a.length+b.length-1];
		multiplication(a, b, a.length, 0, 0, res);
		
		for(int i : res) {
			System.out.print(i+" ");
		}
	}
	
	public static void multiplication(int[] a, int[] b, int n, int i, int j, int[] res){
		
		if(n == 0)
			return;
		if(n == 1){
			res[i+j] = a[i] * b[j];
			return;
		}
		multiplication(a, b, n/2, i, j, res);
		multiplication(a, b, n/2, i+(n-n/2), j+(n-n/2), res);
		int[] x = addition(a, i, i+(n-n/2), n);
		int[] y = addition(b, i, j+(n-n/2), n);
		int[] res1 = new int[x.length];
		multiplication(x, y, x.length, 0, 0, res1);
		int[] add = addition(res, i+j, (i+(n-n/2)+j+(n-n/2)), 2*n-1);
		substraction(res1, res, i, (i+(n-n/2)+j+(n-n/2)), res1.length);
		substraction(res1, res, (i+(n-n/2)+j+(n-n/2)), 0, res1.length);
	}
	
	public static int[] addition(int[] a, int i, int j, int n) {
		int l1 = n-n/2-i;
		int l2 = n-j;
		int[] r = new int[Math.max(l1, l2)];
		
		int k = 0;
		if(l1 > l2) {
			while(k < (l1-l2)) {
				r[k] = a[i++];
				k++;
			}
		}
		
		while(k < l1) {
			r[k] = a[i++] + a[j++];
			k++;
		}
		
		return r;
	}
	
	
	public static int[] substraction(int[] a, int[] b, int i, int j, int n) {
		int l1 = n-n/2-i;
		int l2 = n-j;
		int[] r = new int[Math.max(l1, l2)];
		
		int k = 0;
		if(l1 > l2) {
			while(k < (l1-l2)) {
				r[k] = a[i++];
				k++;
			}
		}
		
		while(k < l1) {
			r[k] = a[i++] - b[j++];
			k++;
		}
		
		return r;
	}
}
