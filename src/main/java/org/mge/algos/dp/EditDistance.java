package org.mge.algos.dp;

public class EditDistance {

	public static void main(String[] args) {
		//distance("INTENTION", "EXECUTION"); 
		distance("really", "bread");
	}
	
	static void distance(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int d[][] = new int[m+1][n+1];
		for(int i = 0; i <= m; i++){
			d[i][0] = i;
		}
		for(int j = 0; j <= n; j++){
			d[0][j] = j;
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					d[i][j] = d[i-1][j-1];
				} else {
					d[i][j] = min(d[i][j-1] + 1, d[i-1][j] + 1, d[i-1][j-1] + 1);
				}
			}
		}
		System.out.println(d[m][n]);
		print(d, s1, s2);
	}
	
	static void print(int d[][], String s1, String s2){
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int i = s1.length();
		int j = s2.length();
		while(i != 0 && j != 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				sb.append(s1.charAt(i-1));
				sb2.append(s2.charAt(j-1));
				i--;j--;
			} else if(d[i][j] == d[i-1][j-1]+1) {
				sb.append(s1.charAt(i-1));
				sb2.append(s2.charAt(j-1));
				i--;j--;
			}  else if(d[i][j] == d[i-1][j] + 1) {
				sb.append(s1.charAt(i-1));
				sb2.append("*");
				i--;
			} 
			else if(d[i][j] == d[i][j-1] + 1) {
				sb.append("*");
				sb2.append(s2.charAt(j-1));
				j--;
			} 
		}
		
		while(i > 0){
			sb.append(s1.charAt(i-1));
			sb2.append("*");
			i--;
		}
		
		while(j > 0){
			sb2.append(s2.charAt(j-1));
			sb.append("*");
			j--;
		}
		
		System.out.println(sb.reverse());
		System.out.println(sb2.reverse());
	}
	
	static int min(int x, int y, int z) {
		if(x <= y && x <= z) 
			return x;
		if(y<=x && y<=z)
			return y;
		return z;
	}
}
