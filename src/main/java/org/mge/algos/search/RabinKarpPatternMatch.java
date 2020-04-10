package org.mge.algos;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpPatternMatch {

	public static void main(String[] args) {
		String s = "abcdabaabcabdabcaaabbabcabcabc";
		String p = "abc";
		List<Integer> pos = getPositions(s, p);
		
		for(int i : pos) {
			System.out.println(s.substring(i, i + p.length()));
		}
	}
	
	public static List<Integer> getPositions(String s, String p) {
		List<Integer> pos = new ArrayList<>();
		int[] h = precomputeHash(s, p.length(), 10000003, 15);
		int c = s.length() - p.length();
		int H = hash(p, 10000003, 15, p.length());
		
		for(int i = 0; i < c + 1; i++) {
			if(h[i] != H) 
				continue;
			if(equals(s, p, i)) {
				pos.add(i);
			}
		}
		
		return pos;
	}
	
	public static int[] precomputeHash(String s, int n, int p, int x){
		int[] h = new int[s.length() - n + 1];
		
		int c = s.length() - n;
		
		h[c] = hash(s.substring(c), p, x, n);
		
		for(int i = c - 1 ; i >= 0; i--) {
			h[i] = (x * h[i+1] + (int)s.charAt(i) - (int)s.charAt(i + n) * (int)Math.pow(x, n)) % p;
		}
		
		return h;
	}
	
	static int hash(String s, int p, int x, int n) {
		int h = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			h += ((int)s.charAt(i) * Math.pow(x, --n)) % p;  
		}
		return h;
	}
	
	public static boolean equals(String s, String p, int i) {
		int j = 0;
		while(j < p.length()) {
			if(s.charAt(i++) != p.charAt(j++)){
				return false;
			}
		}
		
		return true;
	}
}
