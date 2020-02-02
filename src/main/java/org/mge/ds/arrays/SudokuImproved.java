package org.mge.ds.arrays;

import java.util.Date;

public class SudokuImproved {
	static int[][] table = new int[9][9];
	static int N = 9;
	static int SRN = 3;

	public static void main(String[] args) {
		Date start = new Date();
		fillTable();
		printTable();
		Date end = new Date();
		int time = (int) (end.getTime() - start.getTime()) / 1000;
		System.out.println("Time taken = " + time + " Seconds");
	}

	public static void fillTable() {
		int i = 0, j = 0;
		for (int k = 0; k < 3; k++) {
			fillBox(i, j);
			i += 3;
			j += 3;
		}

		fillRemaining(0, 3);
	}

	public static void fillBox(int i, int j) {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				int n = getRandomNumber(0);
				while (checkInBox(i + x, j + y, n)) {
					n = getRandomNumber(n);
				}
				table[i + x][j + y] = n;
			}
		}

	}

	private static boolean CheckIfSafe(int i, int j, int num) {
		return !checkInBox(i, j, num) && !checkInColumn(j, num)
				&& !checkInRow(i, num);
	}

	public static boolean fillRemaining(int i, int j) {
		
		if (i >= N && j >= N) {
			return true;
		}
		
		if (j >= N) {
			i = i + 1;
			j = 0;
		}

		if(i < SRN) {
			if(j < SRN) {
				j = SRN;
			}
		} else if(i < N - SRN) {
			if( j == (i/SRN) * SRN) {
				j += SRN;
			}
		} else if(j == N - SRN){
			j = 0;
			i = i + 1;
			if(i >= N) {
				return true;
			}
		}

		if (j < 9) {
			for (int n = 1; n <= 9; n++) {
				if (CheckIfSafe(i, j, n)) {
					table[i][j] = n;
					if (fillRemaining(i, j + 1)) {
						return true;
					}
					
					table[i][j] = 0;
				}
			}
		}
		return false;
	}

	public static int getRandomNumber(int prevNum) {
		int n = (int) Math.floor(Math.random() * 9 + 1);
		while (n == prevNum) {
			n = (int) Math.floor(Math.random() * 9 + 1);
		}

		return n;
	}

	public static void printTable() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean checkInRow(int i, int num) {
		for (int j = 0; j < table.length; j++) {
			if (table[i][j] == num) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkInColumn(int j, int num) {
		for (int i = 0; i < table.length; i++) {
			if (table[i][j] == num) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkInBox(int i, int j, int num) {
		i = i - (i % 3);
		j = j - (j % 3);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (table[i + x][j + y] == num) {
					return true;
				}
			}
		}

		return false;
	}

}
