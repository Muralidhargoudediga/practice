package org.mge.ds.arrays;

import java.util.Date;

public class Sudoku {
	static int[][] table = new int[9][9]; 
	
	public static void main(String[] args) {
		Date start = new Date();
		fillTable();
		printTable();
		Date end  = new Date();
		int time = (int)(end.getTime() - start.getTime()) / 1000;
		System.out.println("Time taken = " + time + " Seconds");
	}
	
	public static void fillTable() {
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table.length; j++) {
				int n = getRandomNumber(0);
				while(checkInRow(i, n) || checkInColumn(j, n) || checkInBox(i, j, n)){
					n = getRandomNumber(n);
				} 
				table[i][j] = n;
			}
		}
	}
	
	public static int getRandomNumber(int prevNum) {
		int n = (int)Math.floor(Math.random() * 9 + 1);
		while(n == prevNum) {
			n = (int)Math.floor(Math.random() * 9 + 1);
		}
		
		return n;
	}
	
	public static void printTable() {
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table.length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean checkInRow(int i, int num) {
		for(int j = 0; j < table.length; j++) {
			if(table[i][j] == num) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean checkInColumn(int j, int num) {
		for(int i = 0; i < table.length; i++) {
			if(table[i][j] == num) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean checkInBox(int i, int j, int num) {
		i = i - (i % 3);
		j = j - (j % 3);
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				if(table[i+x][j+y] == num) {
					return true;
				}
			}
		}
		
		return false;
	}
}
