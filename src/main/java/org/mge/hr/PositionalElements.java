package org.mge.hr;

import java.util.Scanner;

public class PositionalElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a[][] = new int[m][n];
		int s[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(getNoOfPosElem(a, m, n, s));
		sc.close();
	}

	public static int getNoOfPosElem(int a[][], int m, int n, int s[][]) {
		for (int i = 0; i < m; i++) {
			int minJ = 0;
			int maxJ = 0;
			for (int j = 1; j < n; j++) {
				if (a[i][minJ] > a[i][j]) {
					if (minJ != maxJ)
						s[i][minJ] = -1;
					minJ = j;
				} else if (a[i][maxJ] < a[i][j]) {
					if (minJ != maxJ)
						s[i][maxJ] = -1;
					maxJ = j;
				} else if(a[i][minJ] == a[i][j] || a[i][maxJ] == a[i][j]){
					return -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int minJ = 0;
			int maxJ = 0;
			for (int j = 1; j < m; j++) {
				if (a[minJ][i] > a[j][i]) {
					if (minJ != maxJ)
						s[minJ][i] = -1;
					minJ = j;
					s[minJ][i] = 0;
				} else if (a[maxJ][i] < a[j][i]) {
					if (minJ != maxJ)
						s[maxJ][i] = -1;
					maxJ = j;
					s[maxJ][i] = 0;
				} else if(a[minJ][i] == a[j][i] || a[maxJ][i] == a[j][i]){
					return -1;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s[i][j] != -1)
					result++;
			}
		}

		return result;
	}
}
