package org.mge.algos;

public class LCSDistance {

	public static void main(String[] args) {
		//distance("INTENTION", "EXECUTION"); 
		distance("abcde", "abcghid");
	}
	
	static void distance(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int d[][] = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(i == 0 || j == 0)
					d[i][j] = 0;
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					d[i][j] = d[i-1][j-1] + 1;
				} else {
					d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
				}
			}
		}
		System.out.println(d[m][n]);
		printLCS(d, s1, s2);
	}
	
	static void printLCS(int[][] d, String s1, String s2) {
		int i = s1.length();
		int j = s2.length();
		StringBuilder sb = new StringBuilder();
		while(i != 0 && j != 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				sb.append(s1.charAt(i-1));
				i--;j--;
			} else if(d[i][j] == d[i-1][j]) {
				i--;
			} 
			else if(d[i][j] == d[i][j-1]) {
				j--;
			} 
		}
		
		System.out.println(sb.reverse());
	}
	
	static void lcs(String s1, String s2){
		
	}
	static int min(int x, int y, int z) {
		if(x <= y && x <= z) 
			return x;
		if(y<=x && y<=z)
			return y;
		return z;
	}
}
